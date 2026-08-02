package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ632 {

    public ResponseDto Question632() {
        ResponseDto responseDto = new ResponseDto();
        long n = 10000000000000000L;
        long mod = 1000000007L;

        // C_k(N) = sum_{M=1 to sqrt(N)} |mu(M)| * floor(N/M^2) * binom(omega(M), k) * (-1)^(omega(M)-k)
        int limit = (int) Math.sqrt(n);
        int[] omega = new int[limit + 1];
        boolean[] isSquareFree = new boolean[limit + 1];
        Arrays.fill(isSquareFree, true);
        
        for (int i = 2; i <= limit; i++) {
            if (omega[i] == 0) {
                for (int j = i; j <= limit; j += i) {
                    omega[j]++;
                }
                long i2 = (long) i * i;
                if (i2 <= limit) {
                    for (int j = (int) i2; j <= limit; j += i2) {
                        isSquareFree[j] = false;
                    }
                }
            }
        }

        long[] ck = new long[20]; // max k is small
        for (int m = 1; m <= limit; m++) {
            if (!isSquareFree[m]) continue;
            long count = n / ((long) m * m);
            int w = omega[m];
            for (int k = 0; k <= w; k++) {
                long term = (count % mod) * combinations(w, k, mod) % mod;
                if ((w - k) % 2 == 1) {
                    ck[k] = (ck[k] - term + mod) % mod;
                } else {
                    ck[k] = (ck[k] + term) % mod;
                }
            }
        }

        long product = 1;
        for (int k = 0; k < 20; k++) {
            if (ck[k] != 0) {
                product = (product * ck[k]) % mod;
            }
        }

        responseDto.setAnswer(product);
        return responseDto;
    }

    private long combinations(int n, int k, long mod) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return res % mod;
    }
}
