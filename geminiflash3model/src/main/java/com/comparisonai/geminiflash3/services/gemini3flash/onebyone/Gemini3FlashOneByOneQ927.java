package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ927 {

    public ResponseDto Question927() {
        ResponseDto responseDto = new ResponseDto();
        long N = 10000000;
        boolean[] isPrime = new boolean[(int) N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int p = 2; p * p <= N; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= N; i += p)
                    isPrime[i] = false;
            }
        }

        long totalSum = 0;
        for (int m = 1; m <= N; m++) {
            boolean inS = true;
            int tempM = m;
            for (int p = 2; p * p <= tempM; p++) {
                if (tempM % p == 0) {
                    if (!checkP(p, m)) {
                        inS = false;
                        break;
                    }
                    while (tempM % p == 0) tempM /= p;
                }
            }
            if (inS && tempM > 1) {
                if (!checkP(tempM, m)) inS = false;
            }
            if (inS) totalSum += m;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private boolean checkP(int p, int m) {
        // Condition for m to be in Sp: m must divide tk(n) for some n
        // tk(n+1) = tk(n)^k + 1
        // This is a simplified check based on the problem's logic
        long val = 1;
        for (int i = 0; i < 100; i++) {
            if (val % m == 0) return true;
            long nextVal = 1;
            for (int j = 0; j < p; j++) nextVal = (nextVal * val) % m;
            val = (nextVal + 1) % m;
            if (val == 1 && i > 0) break;
        }
        return false;
    }
}
