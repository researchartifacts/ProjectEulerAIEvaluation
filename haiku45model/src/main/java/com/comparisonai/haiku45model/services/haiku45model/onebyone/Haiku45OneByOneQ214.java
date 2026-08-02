package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ214 {

    public ResponseDto Question214() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 214: Euler's totient chain length
        // Find sum of primes < 40,000,000 that generate chains of length 25
        // using Euler's totient function φ

        int limit = 40000000;
        long result = 0;

        // Precompute totient function
        Map<Long, Integer> chainLengths = new HashMap<>();

        // Find all primes and check chain length for each
        for (int p = 2; p < limit; p++) {
            if (isPrime(p)) {
                int chainLength = getChainLength(p);
                if (chainLength == 25) {
                    result += p;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int getChainLength(long n) {
        int length = 1;

        while (n > 1) {
            n = phi(n);
            length++;
        }

        return length;
    }

    private long phi(long n) {
        // Calculate Euler's totient function
        long result = n;

        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }

        if (n > 1) {
            result -= result / n;
        }

        return result;
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
}
