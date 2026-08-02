package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ51 {

    public ResponseDto Question51() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p < limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < limit; i += p) isPrime[i] = false;
            }
        }
        for (int i = 56003; i < limit; i++) {
            if (!isPrime[i]) continue;
            String s = String.valueOf(i);
            for (int digit = 0; digit <= 2; digit++) {
                String dStr = String.valueOf(digit);
                if (s.contains(dStr)) {
                    int count = 0;
                    for (int k = 0; k <= 9; k++) {
                        String nextS = s.replace(dStr, String.valueOf(k));
                        if (nextS.charAt(0) != '0' && isPrime[Integer.parseInt(nextS)]) {
                            count++;
                        }
                    }
                    if (count == 8) {
                        responseDto.setAnswer(i);
                        return responseDto;
                    }
                }
            }
        }
        return responseDto;
    }
}
