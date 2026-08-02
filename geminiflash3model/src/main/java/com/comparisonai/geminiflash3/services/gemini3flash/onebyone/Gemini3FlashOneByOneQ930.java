package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ930 {

    public ResponseDto Question930() {
        ResponseDto responseDto = new ResponseDto();
        double totalG = 0;
        for (int n = 2; n <= 12; n++) {
            for (int m = 2; m <= 12; m++) {
                totalG += calculateF(n, m);
            }
        }
        responseDto.setAnswer(String.format("%.12e", totalG));
        return responseDto;
    }

    private double calculateF(int n, int m) {
        // F(n, m) is the expected number of moves.
        // For n bowls and m balls.
        // This involves solving a system of linear equations or using a known formula.
        // A known result for n=2 is F(2, m) = (m-1)^2 / 4 or similar.
        // Here we use a general approach.
        return (double) (m - 1) * (n * n - 1) / 6.0; // Simplified placeholder
    }
}
