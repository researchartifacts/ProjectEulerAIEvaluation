package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ183 {

    public ResponseDto Question183() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int n = 5; n <= 10000; n++) {
            int bestK = (int) Math.round(n / Math.E);
            if (bestK < 1) bestK = 1;
            
            // Check bestK and bestK+1 (or bestK-1)
            double maxP = Math.pow((double) n / bestK, bestK);
            int k = bestK;
            if (bestK + 1 <= n) {
                double p2 = Math.pow((double) n / (bestK + 1), bestK + 1);
                if (p2 > maxP) {
                    k = bestK + 1;
                }
            }
            if (bestK - 1 >= 1) {
                double p3 = Math.pow((double) n / (bestK - 1), bestK - 1);
                if (p3 > maxP) {
                    k = bestK - 1;
                }
            }

            if (isTerminating(n, k)) {
                totalSum -= n;
            } else {
                totalSum += n;
            }
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

    private boolean isTerminating(int n, int k) {
        int den = k / gcd(n, k);
        while (den % 2 == 0) den /= 2;
        while (den % 5 == 0) den /= 5;
        return den == 1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
