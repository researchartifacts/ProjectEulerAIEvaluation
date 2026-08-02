package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ49 {

    public ResponseDto Question49() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1001; i < 10000; i += 2) {
            if (i == 1487) continue;
            int j = i + 3330;
            int k = j + 3330;
            if (k < 10000 && isPrime(i) && isPrime(j) && isPrime(k) &&
                isPermutation(i, j) && isPermutation(i, k)) {
                responseDto.setAnswer("" + i + j + k);
                break;
            }
        }
        return responseDto;
    }

    private boolean isPermutation(int a, int b) {
        char[] ca = String.valueOf(a).toCharArray();
        char[] cb = String.valueOf(b).toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}
