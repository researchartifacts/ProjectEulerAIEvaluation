package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ204 {

    public ResponseDto Question204() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 204: Generalized Hamming numbers of type 100
        // Count numbers <= 10^9 with no prime factor larger than 100

        long limit = 1000000000L; // 10^9
        long count = 0;

        // Generate all primes up to 100
        List<Integer> primes = sievePrimes(100);

        // Use dynamic programming to generate all Hamming numbers
        Set<Long> hammingNumbers = new TreeSet<>();
        hammingNumbers.add(1L);

        Queue<Long> queue = new LinkedList<>();
        queue.add(1L);

        while (!queue.isEmpty()) {
            long current = queue.poll();

            for (int prime : primes) {
                long next = current * prime;
                if (next <= limit && !hammingNumbers.contains(next)) {
                    hammingNumbers.add(next);
                    queue.add(next);
                }
            }
        }

        count = hammingNumbers.size();

        responseDto.setAnswer(count);
        return responseDto;
    }

    private List<Integer> sievePrimes(int maxNum) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[maxNum + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= maxNum; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i * 2; j <= maxNum; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return primes;
    }
}
