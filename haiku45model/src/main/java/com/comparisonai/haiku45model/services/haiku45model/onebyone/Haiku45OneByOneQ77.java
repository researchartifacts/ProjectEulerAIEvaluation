package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ77 {

    public ResponseDto Question77() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int n = 10; n <= 1000; n++) {
            if (countPrimeSums(n, primes) > 5000) {
                responseDto.setAnswer(n);
                return responseDto;
            }
        }
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private int countPrimeSums(int n, List<Integer> primes) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int prime : primes) {
            for (int i = prime; i <= n; i++) {
                dp[i] += dp[i - prime];
            }
        }
        return dp[n];
    }
}
