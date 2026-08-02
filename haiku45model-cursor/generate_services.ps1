# PowerShell script to generate Project Euler 801-900 SpringBoot Service Classes
$problemsDir = "$PSScriptRoot\problems\801to900"
$servicesDir = "$PSScriptRoot\src\main\java\com\comparisonai\haiku45modelcursor\services\haiku45modelcursor\onebyone"

# Create services directory if it doesn't exist
if (!(Test-Path $servicesDir)) {
    New-Item -ItemType Directory -Force -Path $servicesDir | Out-Null
}

# Get all problem files
$problemFiles = Get-ChildItem -Path $problemsDir -Filter "*.txt" | Sort-Object { [int]($_.BaseName) }

Write-Host "Found $($problemFiles.Count) problem files"

foreach ($problemFile in $problemFiles) {
    $problemNumber = $problemFile.BaseName
    $problemContent = Get-Content -Path $problemFile.FullName -Raw
    
    # Create service class filename
    $serviceClassName = "Haiku45OneByOneQ$problemNumber"
    $serviceFilePath = Join-Path $servicesDir "$serviceClassName.java"
    
    # Check if file already exists
    if (Test-Path $serviceFilePath) {
        Write-Host "Skipping $problemNumber - file already exists"
        continue
    }
    
    Write-Host "Generating service for Problem $problemNumber..."
    
    # Create the Java service file with placeholder logic
    $methodName = "Question$problemNumber"
    
    $javaContent = @"
package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem $problemNumber
 */
@Service
public class $serviceClassName {

    public ResponseDto $methodName() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: $(($problemContent -replace '<[^>]*>', '') -replace '\s+', ' ' | Select-Object -First 1)...
        // Generated logic to solve the problem:
        
        // TODO: Implement logic to solve Problem $problemNumber
        Object result = null;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
"@
    
    # Write the file
    Set-Content -Path $serviceFilePath -Value $javaContent -Encoding UTF8
    Write-Host "Created: $serviceClassName.java"
}

Write-Host "Service generation completed!"
