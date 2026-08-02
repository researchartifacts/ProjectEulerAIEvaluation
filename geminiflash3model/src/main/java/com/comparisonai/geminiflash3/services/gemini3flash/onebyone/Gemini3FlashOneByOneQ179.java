package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ179 {

    public ResponseDto Question179() {
        ResponseDto responseDto = new ResponseDto();
        // Number of integers 1 < n < 10^7 for which n and n+1 have the same number of divisors.
        int limit = 10000000;
        int[] divisors = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            for (int j = i; j <= limit; j += i) {
                divisors[j]++;
            }
        }
        
        int count = 0;
        for (int n = 2; n < limit; n++) {
            if (divisors[n] == divisors[n + 1]) {
                count++;
            }
        }
        
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
