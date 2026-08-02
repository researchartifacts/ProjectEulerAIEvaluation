package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ675 {

    public ResponseDto Question675() {
        ResponseDto responseDto = new ResponseDto();

        int N = 10000000;
        long mod = 1000000087;

        long[] v = new long[N + 1];
        long currentS = 1;
        long totalF = 0;

        int[] minPrime = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (minPrime[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    if (minPrime[j] == 0) minPrime[j] = i;
                }
            }
        }

        long[] pCount = new long[N + 1];

        for (int i = 2; i <= N; i++) {
            int temp = i;
            while (temp > 1) {
                int p = minPrime[temp];
                currentS = (currentS * modInverse(2 * pCount[p] + 1, mod)) % mod;
                pCount[p]++;
                currentS = (currentS * (2 * pCount[p] + 1)) % mod;
                temp /= p;
            }
            totalF = (totalF + currentS) % mod;
        }

        responseDto.setAnswer(totalF);
        return responseDto;
    }

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
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
