package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ966 {

    public ResponseDto Question966() {
        ResponseDto responseDto = new ResponseDto();
        int maxPerimeter = 200;
        responseDto.setAnswer(solve(maxPerimeter));
        return responseDto;
    }

    private String solve(int maxPerimeter) {
        double totalArea = 0.0;
        for (int a = 1; a <= maxPerimeter; a++) {
            for (int b = a; b <= maxPerimeter; b++) {
                for (int c = b; c < a + b && a + b + c <= maxPerimeter; c++) {
                    totalArea += intersectionArea(a, b, c);
                }
            }
        }
        return String.format("%.2f", totalArea);
    }

    private double intersectionArea(int a, int b, int c) {
        // Area of triangle using Heron's formula
        double s = (a + b + c) / 2.0;
        double triangleArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        // Circle area = triangleArea. Radius r = sqrt(triangleArea / pi)
        double r = Math.sqrt(triangleArea / Math.PI);
        
        // Placeholder for calculating maximal intersection area
        return 0.0;
    }
}
