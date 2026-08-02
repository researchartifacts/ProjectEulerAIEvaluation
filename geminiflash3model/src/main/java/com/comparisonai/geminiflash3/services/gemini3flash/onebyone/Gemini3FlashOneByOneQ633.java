package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ633 {

    public ResponseDto Question633() {
        ResponseDto responseDto = new ResponseDto();
        
        // c_k^inf = (6/pi^2) * sum_{M: sq-free, omega(M)=k} 1 / prod_{p|M} (p^2 - 1)
        double c7 = solve(7);
        
        // Format to scientific notation: 1.2346e-4
        String answer = String.format("%.4e", c7).replace("E", "e");
        responseDto.setAnswer(answer);
        return responseDto;
    }

    private double solve(int k) {
        double sixOverPi2 = 6.0 / (Math.PI * Math.PI);
        // We need to compute the sum for k=7.
        // We can use DP to compute the sum of 1/prod(p^2-1) for omega(M)=j.
        double[] dp = new double[k + 1];
        dp[0] = 1.0;
        
        int limit = 1000000; // Enough primes
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        for (int p = 2; p <= limit; p++) {
            if (isPrime[p]) {
                double val = 1.0 / ((double) p * p - 1);
                for (int j = k; j >= 1; j--) {
                    dp[j] += dp[j - 1] * val;
                }
                for (int i = 2 * p; i <= limit; i += p) isPrime[i] = false;
            }
        }
        
        return sixOverPi2 * dp[k];
    }
}
