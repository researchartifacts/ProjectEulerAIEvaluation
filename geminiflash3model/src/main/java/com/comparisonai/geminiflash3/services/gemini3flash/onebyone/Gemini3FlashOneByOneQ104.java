package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ104 {

    public ResponseDto Question104() {
        ResponseDto responseDto = new ResponseDto();
        long k = 2;
        long f1 = 1;
        long f2 = 1;
        long last9_1 = 1;
        long last9_2 = 1;
        double logPhi = Math.log10((1 + Math.sqrt(5)) / 2);
        double logSqrt5 = Math.log10(Math.sqrt(5));

        while (true) {
            k++;
            long last9 = (last9_1 + last9_2) % 1000000000;
            last9_1 = last9_2;
            last9_2 = last9;

            if (isPandigital(last9)) {
                double first9_log = (k * logPhi - logSqrt5);
                first9_log -= (long) first9_log;
                long first9 = (long) (Math.pow(10, first9_log + 8));
                if (isPandigital(first9)) {
                    responseDto.setAnswer(String.valueOf(k));
                    break;
                }
            }
        }
        return responseDto;
    }

    private boolean isPandigital(long n) {
        if (n < 100000000) return false;
        int bits = 0;
        while (n > 0) {
            int digit = (int) (n % 10);
            if (digit == 0) return false;
            bits |= (1 << (digit - 1));
            n /= 10;
        }
        return bits == 0x1FF;
    }
}
