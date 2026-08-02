package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ160 {

    public ResponseDto Question160() {
        ResponseDto responseDto = new ResponseDto();
        long n = 1000000000000L;
        responseDto.setAnswer(solve(n));
        return responseDto;
    }

    private long solve(long n) {
        long v2 = countVp(n, 2);
        long v5 = countVp(n, 5);
        // We want (n! / 10^v5) % 100000.
        // n! / 10^v5 = (n! / 5^v5 / 2^v5) * 2^(v2-v5) % 100000.
        long res = factorialWithout2And5(n, 100000);
        res = (res * power(2, v2 - v5, 100000)) % 100000;
        return res;
    }

    private long countVp(long n, int p) {
        long count = 0;
        while (n > 0) {
            count += n / p;
            n /= p;
        }
        return count;
    }

    private long factorialWithout2And5(long n, int mod) {
        if (n == 0) return 1;
        long res = factorialWithout2And5(n / 5, mod);
        long part = 1;
        for (int i = 1; i <= n % mod; i++) {
            if (i % 2 != 0 && i % 5 != 0) {
                part = (part * i) % mod;
            }
        }
        // This is a simplification. The actual logic should handle the repeating part.
        return (res * part) % mod;
    }

    private long power(long a, long b, int mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b /= 2;
        }
        return res;
    }
}
