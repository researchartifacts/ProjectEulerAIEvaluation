package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ174 {

    public ResponseDto Question174() {
        ResponseDto responseDto = new ResponseDto();
        // t = s^2 - h^2 <= 1000000. Count N(n) for n=1..10.
        int limit = 1000000;
        int[] counts = new int[limit + 1];
        for (long s = 3; s <= (limit / 4) + 1; s++) {
            for (long h = s - 2; h >= 1; h -= 2) {
                long t = s * s - h * h;
                if (t <= limit) {
                    counts[(int) t]++;
                } else {
                    break;
                }
            }
        }
        
        long sumN = 0;
        int[] typeCounts = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            if (counts[i] > 0) {
                typeCounts[counts[i]]++;
            }
        }
        
        for (int n = 1; n <= 10; n++) {
            sumN += typeCounts[n];
        }
        
        responseDto.setAnswer(String.valueOf(sumN));
        return responseDto;
    }
}
