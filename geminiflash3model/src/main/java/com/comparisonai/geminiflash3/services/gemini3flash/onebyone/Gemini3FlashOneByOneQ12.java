package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ12 {

    public ResponseDto Question12() {
        ResponseDto responseDto = new ResponseDto();
        long triangle = 0;
        for (int i = 1; ; i++) {
            triangle += i;
            if (countDivisors(triangle) > 500) {
                responseDto.setAnswer(triangle);
                break;
            }
        }
        return responseDto;
    }

    private int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) count++;
                else count += 2;
            }
        }
        return count;
    }
}
