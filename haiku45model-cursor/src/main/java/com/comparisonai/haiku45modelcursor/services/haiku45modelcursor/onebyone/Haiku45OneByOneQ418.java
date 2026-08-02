package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigInteger;

/**
 * Problem 418: Factorisation Triple Minimization
 * Find f(43!) where f(n) = a+b+c for factorisation triple minimizing c/a
 * where a*b*c = n and 1 <= a <= b <= c
 */
@Service
public class Haiku45OneByOneQ418 {

    public ResponseDto Question418() {
        ResponseDto responseDto = new ResponseDto();

        long result = computeFactorialTriple(43);
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeFactorialTriple(int n) {
        // Compute n! prime factorization
        Map<Integer, Integer> primeFactors = getPrimeFactorization(n);

        // Find optimal factorization triple (a, b, c) where a*b*c = n!
        // that minimizes c/a
        
        long minCOverA = Long.MAX_VALUE;
        long bestSum = 0;

        // Generate all divisors of n! using prime factorization
        List<Long> divisors = generateDivisors(primeFactors);

        for (long a : divisors) {
            long factorial = computeFactorial(n);
            long bc = factorial / a;

            // For each valid b where a <= b <= c and b*c = bc
            for (long b : divisors) {
                if (b < a) continue;

                if (bc % b == 0) {
                    long c = bc / b;
                    if (b <= c) {
                        long cOverA = c / a;
                        if (cOverA < minCOverA) {
                            minCOverA = cOverA;
                            bestSum = a + b + c;
                        }
                    }
                }
            }

            // Early termination if ratio becomes large
            if (minCOverA != Long.MAX_VALUE && a * minCOverA > factorial) {
                break;
            }
        }

        return bestSum;
    }

    private Map<Integer, Integer> getPrimeFactorization(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        // For each prime p, count how many times it divides n!
        for (int p = 2; p <= n; p++) {
            if (isPrime(p)) {
                int count = 0;
                long pk = p;
                while (pk <= n) {
                    count += n / pk;
                    pk *= p;
                }
                if (count > 0) {
                    factors.put(p, count);
                }
            }
        }

        return factors;
    }

    private List<Long> generateDivisors(Map<Integer, Integer> primeFactors) {
        List<Long> divisors = new ArrayList<>();
        divisors.add(1L);

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int exponent = entry.getValue();

            List<Long> newDivisors = new ArrayList<>();
            for (long d : divisors) {
                long power = 1;
                for (int i = 0; i <= exponent; i++) {
                    newDivisors.add(d * power);
                    power *= prime;
                }
            }
            divisors = newDivisors;

            // Limit divisors for performance
            if (divisors.size() > 100000) {
                // Sample subset of divisors for large sets
                Collections.sort(divisors);
                divisors = divisors.subList(0, 100000);
            }
        }

        Collections.sort(divisors);
        return divisors;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long computeFactorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            // Safeguard against overflow
            if (result < 0) return Long.MAX_VALUE;
        }
        return result;
    }
}
