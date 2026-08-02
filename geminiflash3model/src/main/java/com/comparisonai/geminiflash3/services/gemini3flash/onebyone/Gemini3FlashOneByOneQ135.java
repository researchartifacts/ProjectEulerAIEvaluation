package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ135 {

    public ResponseDto Question135() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] solutions = new int[limit];

        for (int u = 1; u < limit; u++) {
            for (int v = 1; ; v++) {
                long n = (long) u * v;
                if (n >= limit) break;
                if ((u + v) % 4 == 0 && 3 * v > u) {
                    solutions[(int) n]++;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (solutions[i] == 10) {
                count++;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
