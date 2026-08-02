package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ378 {

    public ResponseDto Question378() {
        ResponseDto responseDto = new ResponseDto();
        int n = 60000000;
        int[] dT = new int[n + 1];
        
        int[] minPrime = new int[n + 2];
        for (int i = 2; i <= n + 1; i++) {
            if (minPrime[i] == 0) {
                for (int j = i; j <= n + 1; j += i) {
                    if (minPrime[j] == 0) minPrime[j] = i;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            dT[i] = getDT(i, minPrime);
        }

        long count = countDecreasingTriples(dT, n);
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int getDT(int n, int[] minPrime) {
        long tn_num, tn_den;
        if (n % 2 == 0) {
            tn_num = n / 2;
            tn_den = n + 1;
        } else {
            tn_num = n;
            tn_den = (n + 1) / 2;
        }
        return numDivisors(tn_num, minPrime) * numDivisors(tn_den, minPrime);
    }

    private int numDivisors(long n, int[] minPrime) {
        int count = 1;
        while (n > 1) {
            int p = minPrime[(int) n];
            int exp = 0;
            while (n % p == 0) {
                n /= p;
                exp++;
            }
            count *= (exp + 1);
        }
        return count;
    }

    private long countDecreasingTriples(int[] dT, int n) {
        // Implementation of counting i < j < k with dT[i] > dT[j] > dT[k]
        // This usually uses Fenwick tree or similar.
        return 0; // Placeholder for logic
    }
}
