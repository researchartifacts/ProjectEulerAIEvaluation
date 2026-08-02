package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ493 {

    public ResponseDto Question493() {
        ResponseDto responseDto = new ResponseDto();
        // Expected number of distinct colors in 20 balls from 70 (10 of each 7 colors).
        double expectedValue = 7.0 * (1.0 - combinations(60, 20) / combinations(70, 20));
        responseDto.setAnswer(String.format("%.9f", expectedValue));
        return responseDto;
    }

    private double combinations(int n, int k) {
        if (k < 0 || k > n) return 0;
        double res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
        }
        return res;
    }
}
