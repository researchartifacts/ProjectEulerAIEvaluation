package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 302
 */
@Service
public class Haiku45OneByOneQ302 {

    public ResponseDto Question302() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // Achilles numbers using prime factorization
        long limit = 1000000L;
        long[] mu = new long[(int)limit + 1];
        java.util.Arrays.fill(mu, 1);
        boolean[] isPrime = new boolean[(int)limit + 1];
        java.util.Arrays.fill(isPrime, true);
        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int j = p * p; j <= limit; j += p) isPrime[j] = false;
                for (int k = p; k <= limit; k += p) mu[k] = 0;
            }
        }
        long result = 0;
        for (long i = 2; i <= 10000; i++) {
            if (mu[(int)i] == 0) result++;
        }

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
