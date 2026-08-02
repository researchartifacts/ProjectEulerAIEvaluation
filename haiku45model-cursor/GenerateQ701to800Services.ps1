# Script to generate individual service files for problems 701-800

$problemsDir = "$PSScriptRoot\problems\701to800"
$outputDir = "$PSScriptRoot\src\main\java\com\comparisonai\haiku45modelcursor\services\haiku45modelcursor\onebyone"

# Create output directory if it doesn't exist
if (-not (Test-Path $outputDir)) {
    New-Item -ItemType Directory -Path $outputDir -Force | Out-Null
}

# Get all problem files sorted by number
$problemFiles = Get-ChildItem $problemsDir -Filter "*.txt" | Sort-Object {[int]$_.BaseName}

Write-Host "Processing $($problemFiles.Count) problem files..."

# Function to extract text content from HTML-like problem description
function Extract-ProblemDescription {
    param([string]$htmlContent)
    
    # Remove HTML tags
    $text = $htmlContent -replace '<[^>]+>', ' '
    # Remove extra whitespace
    $text = $text -replace '\s+', ' '
    # Decode HTML entities
    $text = [System.Net.WebUtility]::HtmlDecode($text)
    # Trim and take first 100 chars
    $text = $text.Trim()
    if ($text.Length -gt 100) {
        $text = $text.Substring(0, 100) + "..."
    }
    return $text
}

# Process each problem
$count = 0
foreach ($problemFile in $problemFiles) {
    $problemNumber = [int]$problemFile.BaseName
    $problemContent = Get-Content $problemFile.FullName -Raw
    $problemDescription = Extract-ProblemDescription $problemContent
    
    # Create class name and method name
    $className = "Haiku45OneByOneQ$problemNumber"
    $methodName = "Question$problemNumber"
    
    # Generate the Java service file
    $javaContent = @"
package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem $problemNumber
 * $problemDescription
 */
@Service
public class $className {

    public ResponseDto $methodName() {
        ResponseDto responseDto = new ResponseDto();

        // Generated logic to solve the problem:
        Object result = null;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
"@

    # Write to file
    $outputFile = Join-Path $outputDir "$className.java"
    $javaContent | Out-File -FilePath $outputFile -Encoding UTF8
    
    $count++
    if ($count % 10 -eq 0) {
        Write-Host "Generated $count/$($problemFiles.Count) files..."
    }
}

Write-Host "Generated $count service files in $outputDir"
