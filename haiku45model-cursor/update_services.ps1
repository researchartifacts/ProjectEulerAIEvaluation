$problemsPath = "$PSScriptRoot\problems\201to300"
$servicesPath = "$PSScriptRoot\src\main\java\com\comparisonai\haiku45modelcursor\services\haiku45modelcursor\onebyone"

# Function to extract text from HTML content
function Get-ProblemText {
    param([string]$filePath)
    
    $content = Get-Content $filePath -Raw
    # Basic HTML to text conversion
    $text = $content -replace '<[^>]+>', ''
    $text = $text -replace '&nbsp;', ' '
    $text = $text -replace '&amp;', '&'
    $text = $text -replace '&lt;', '<'
    $text = $text -replace '&gt;', '>'
    $text = $text -replace '&quot;', '"'
    $text = $text -replace '&apos;', "'"
    $text = $text -replace '\s+', ' '
    $text = $text.Trim()
    
    return $text
}

# Get all problem files
$problemFiles = Get-ChildItem $problemsPath -Filter '*.txt' | Sort-Object { [int]$_.BaseName }

foreach ($file in $problemFiles) {
    $questionNumber = [int]$file.BaseName
    $className = "Haiku45OneByOneQ$questionNumber"
    $methodName = "Question$questionNumber"
    
    # Read problem description
    $problemText = Get-ProblemText $file.FullName
    
    # Create Java file content with placeholder for solution
    $javaContent = @"
package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem $questionNumber
 */
@Service
public class $className {

    public ResponseDto $methodName() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: $problemText
        // Generated logic to solve the problem:
        
        Object result = null;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
"@

    # Create file path
    $filePath = "$servicesPath\$className.java"
    
    # Write file (overwrite existing)
    Set-Content -Path $filePath -Value $javaContent -Encoding UTF8
    
    if ($questionNumber % 10 -eq 0) {
        Write-Host "Updated: $className.java"
    }
}

Write-Host "Total files updated: $($problemFiles.Count)"
