package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * Problem 60
 */
@Service
public class Haiku45OneByOneQ60 {

    public ResponseDto Question60() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the lowest sum for a set of five primes where any two concatenate to produce another prime
        // Generated logic to solve the problem:

        java.util.function.Function<Long, Boolean> isPrime = n -> {
            if (n < 2) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;
            for (long i = 3; i * i <= n; i += 2) {
                if (n % i == 0) return false;
            }
            return true;
        };

        java.util.List<Long> primes = new java.util.ArrayList<>();
        for (long i = 2; i < 10000; i++) {
            if (isPrime.apply(i)) primes.add(i);
        }

        java.util.function.Function<Long, Long> concatenate =  new Function<Long, Long>() {
            @Override
            public Long apply(Long aLong) {
                return 0L;
            }
        };

        java.util.function.Function<java.util.List<Long>, Boolean> isValidFamily = family -> {
            for (int i = 0; i < family.size(); i++) {
                for (int j = i + 1; j < family.size(); j++) {
                    long p1 = family.get(i);
                    long p2 = family.get(j);
                    long c1 = p1+p2;
                    long c2 = p2+p1;
                    if (!isPrime.apply(c1) || !isPrime.apply(c2)) {
                        return false;
                    }
                }
            }
            return true;
        };

        long minSum = Long.MAX_VALUE;

        for (int i = 0; i < primes.size() && primes.get(i) < 10000; i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                for (int k = j + 1; k < primes.size(); k++) {
                    for (int l = k + 1; l < primes.size(); l++) {
                        for (int m = l + 1; m < primes.size(); m++) {
                            java.util.List<Long> family = new java.util.ArrayList<>();
                            family.add(primes.get(i));
                            family.add(primes.get(j));
                            family.add(primes.get(k));
                            family.add(primes.get(l));
                            family.add(primes.get(m));

                            if (isValidFamily.apply(family)) {
                                long sum = family.stream().mapToLong(Long::longValue).sum();
                                if (sum < minSum) {
                                    minSum = sum;
                                }
                            }
                        }
                    }
                }
            }
        }

        responseDto.setAnswer(minSum);
        return responseDto;
    }
}
