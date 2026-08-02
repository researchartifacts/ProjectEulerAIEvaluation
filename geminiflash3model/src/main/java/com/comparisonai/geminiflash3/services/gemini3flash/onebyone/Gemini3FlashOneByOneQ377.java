package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ377 {

    public ResponseDto Question377() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long totalSum = 0;
        
        for (int i = 1; i <= 17; i++) {
            long n = 1;
            for (int j = 0; j < i; j++) n *= 13;
            totalSum = (totalSum + f(n, MOD)) % MOD;
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long f(long n, long mod) {
        long[] c = new long[(int) n + 1];
        long[] s = new long[(int) n + 1];
        c[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int d = 1; d <= 9; d++) {
                if (i - d >= 0) {
                    c[i] = (c[i] + c[i - d]) % mod;
                    s[i] = (s[i] + s[i - d] * 10 + c[i - d] * d) % mod;
                }
            }
        }
        return s[(int) n];
    }
}
