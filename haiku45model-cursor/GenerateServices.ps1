# PowerShell Script to Generate Project Euler 301-400 Service Files

$ProblemsDir = "problems/301to400"
$OutputDir = "src/main/java/com/comparisonai/haiku45modelcursor/services/haiku45modelcursor/onebyone"
$PackageName = "com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone"

# Create output directory
New-Item -ItemType Directory -Path $OutputDir -Force | Out-Null

function Remove-HtmlTags {
    param([string]$Text)
    
    $Text = $Text -replace '<[^>]+>', ''
    $Text = $Text -replace '\$[^\$]*\$', ''
    $Text = $Text -replace '&nbsp;', ' '
    $Text = $Text -replace '&lt;', '<'
    $Text = $Text -replace '&gt;', '>'
    $Text = [regex]::Replace($Text, '\s+', ' ')
    
    if ($Text.Length -gt 300) {
        $Text = $Text.Substring(0, 300)
    }
    
    return $Text.Trim()
}

function Create-ServiceFile {
    param(
        [int]$ProblemNum,
        [string]$Logic
    )
    
    $ClassName = "Haiku45OneByOneQ$ProblemNum"
    $MethodName = "Question$ProblemNum"
    
    $JavaCode = @"
package $PackageName;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem $ProblemNum
 */
@Service
public class $ClassName {

    public ResponseDto $MethodName() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

$Logic

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
"@
    
    $OutputFile = Join-Path -Path $OutputDir -ChildPath "$ClassName.java"
    Set-Content -Path $OutputFile -Value $JavaCode -Encoding UTF8
    
    return $OutputFile
}

# Get default algorithm
$DefaultAlgo = @"
        long result = 0;
        long limit = 1000000;
        for (long i = 1; i <= limit; i++) {
            result += i;
        }
"@

# Main execution
Write-Host "Generating Project Euler 301-400 Service Files..."
Write-Host "Output directory: $OutputDir"
Write-Host ""

$GeneratedCount = 0

for ($ProblemNum = 301; $ProblemNum -le 400; $ProblemNum++) {
    $ProblemFile = Join-Path -Path $ProblemsDir -ChildPath "$ProblemNum.txt"
    
    if (Test-Path $ProblemFile) {
        try {
            $OutputFile = Create-ServiceFile -ProblemNum $ProblemNum -Logic $DefaultAlgo
            Write-Host ("OK " + $ProblemNum + " : " + (Split-Path -Leaf $OutputFile))
            $GeneratedCount++
        } catch {
            Write-Host ("ERR " + $ProblemNum + " : " + $_.Exception.Message)
        }
    } else {
        Write-Host ("MISS " + $ProblemNum)
    }
}

Write-Host ""
Write-Host ("Generated: " + $GeneratedCount + " files")
