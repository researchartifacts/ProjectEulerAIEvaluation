package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ211 {

    public ResponseDto Question211() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 64_000_000;
        long[] sigma2 = new long[limit];
        for (int i = 1; i < limit; i++) {
            long i2 = (long) i * i;
            for (int j = i; j < limit; j += i) {
                sigma2[j] += i2;
            }
        }

        long sum = 0;
        for (int n = 1; n < limit; n++) {
            if (isPerfectSquare(sigma2[n])) {
                sum += n;
            }
        }

        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPerfectSquare(long n) {
        long root = (long) Math.sqrt(n);
        return root * root == n;
    }
}
