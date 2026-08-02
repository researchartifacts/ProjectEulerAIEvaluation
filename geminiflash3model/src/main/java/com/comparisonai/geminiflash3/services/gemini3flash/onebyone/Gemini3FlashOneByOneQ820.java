package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ820 {

    public ResponseDto Question820() {
        ResponseDto responseDto = new ResponseDto();
        int n = 10000000;
        long sum = 0;
        
        for (int k = 1; k <= n; k++) {
            sum += nthDigitOfOneOverK(n, k);
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private int nthDigitOfOneOverK(int n, int k) {
        if (k == 1) return 0;
        // n-th digit of 1/k is floor(10^n / k) % 10
        // Which is (10^(n-1) % k * 10) / k
        long rem = power(10, n - 1, k);
        return (int) ((rem * 10) / k);
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
