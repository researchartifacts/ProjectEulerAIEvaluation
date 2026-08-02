package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ231 {

    public ResponseDto Question231() {
        ResponseDto responseDto = new ResponseDto();
        int n = 20_000_000;
        int k = 15_000_000;
        int r = n - k;
        
        long totalSum = 0;
        int[] minPrime = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (minPrime[i] == 0) {
                for (int j = i; j <= n; j += i) {
                    if (minPrime[j] == 0) minPrime[j] = i;
                }
            }
        }
        
        for (int i = 2; i <= n; i++) {
            long s = sumPrimeFactors(i, minPrime);
            if (i <= k) totalSum -= s;
            if (i <= r) totalSum -= s;
            totalSum += s;
        }
        // Actually this is just sum of factors of all i from 1..n minus factors of 1..k minus factors of 1..r
        long res = 0;
        for (int i = 2; i <= n; i++) res += sumPrimeFactors(i, minPrime);
        for (int i = 2; i <= k; i++) res -= sumPrimeFactors(i, minPrime);
        for (int i = 2; i <= r; i++) res -= sumPrimeFactors(i, minPrime);

        responseDto.setAnswer(res);
        return responseDto;
    }

    private long sumPrimeFactors(int n, int[] minPrime) {
        long sum = 0;
        while (n > 1) {
            int p = minPrime[n];
            sum += p;
            n /= p;
        }
        return sum;
    }
}
