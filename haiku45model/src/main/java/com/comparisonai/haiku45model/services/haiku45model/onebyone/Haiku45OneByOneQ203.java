package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ203 {

    public ResponseDto Question203() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 203: Squarefree numbers in Pascal's triangle
        // A number is squarefree if no square of a prime divides it
        // Find the sum of distinct squarefree numbers in the first 51 rows

        Set<Long> distinctNumbers = new HashSet<>();
        Set<Long> squarefreeNumbers = new HashSet<>();

        // Generate first 51 rows of Pascal's triangle
        // Row n has elements C(n,k) for k=0 to n

        for (int n = 0; n < 51; n++) {
            for (int k = 0; k <= n; k++) {
                long binomial = calculateBinomial(n, k);
                distinctNumbers.add(binomial);
            }
        }

        // Check each distinct number for squarefreeness
        for (long num : distinctNumbers) {
            if (isSquarefree(num)) {
                squarefreeNumbers.add(num);
            }
        }

        // Sum all squarefree numbers
        long result = 0;
        for (long num : squarefreeNumbers) {
            result += num;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateBinomial(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n - k) k = n - k;

        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }

    private boolean isSquarefree(long n) {
        // A number is squarefree if it's not divisible by any perfect square > 1

        if (n <= 1) return n == 1;

        // Check for divisibility by squares of primes
        for (long i = 2; i * i <= n; i++) {
            if (n % (i * i) == 0) {
                return false;
            }
        }

        return true;
    }
}
