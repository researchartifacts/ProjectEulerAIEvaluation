package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ661 {

    public ResponseDto Question661() {
        ResponseDto responseDto = new ResponseDto();

        double totalH = 0;
        for (int k = 3; k <= 50; k++) {
            double pA = 1.0 / Math.sqrt(k + 3);
            double pB = 1.0 / Math.sqrt(k + 3) + 1.0 / (k * k);
            double p = 1.0 / (k * k * k);
            totalH += expectedA(pA, pB, p);
        }

        responseDto.setAnswer(Math.round(totalH * 10000.0) / 10000.0);
        return responseDto;
    }

    private double expectedA(double pA, double pB, double p) {
        double x = 1.0 - p;
        double q = 1.0 - pA - pB;
        
        double term1 = 1.0 - x * q;
        double term2 = 4.0 * x * x * pA * pB;
        double sqrtDelta = Math.sqrt(term1 * term1 - term2);
        
        // z1 = (term1 - sqrtDelta) / (2 * x * pA)
        double z1 = (term1 - sqrtDelta) / (2.0 * x * pA);
        
        // E = (1/x) * z1 / ((1-z1) * sqrtDelta)
        return (1.0 / x) * (z1 / ((1.0 - z1) * sqrtDelta));
    }
}
