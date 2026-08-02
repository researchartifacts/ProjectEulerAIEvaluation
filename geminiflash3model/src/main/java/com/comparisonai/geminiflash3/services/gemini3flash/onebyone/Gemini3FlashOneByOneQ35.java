package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ35 {

    public ResponseDto Question35() {
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
        int count = 0;
        for (int i = 2; i < limit; i++) {
            if (isPrime[i] && isCircular(i, isPrime)) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isCircular(int n, boolean[] isPrime) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (!isPrime[Integer.parseInt(s)]) return false;
            s = s.substring(1) + s.charAt(0);
        }
        return true;
    }
}
