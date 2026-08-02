package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ50 {

    public ResponseDto Question50() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> primes = new ArrayList<>();
        for (long i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        Set<Long> primeSet = new HashSet<>(primes);
        long maxPrime = 0;
        int maxLength = 0;
        for (int i = 0; i < primes.size(); i++) {
            long sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum >= 1000000) break;
                if (primeSet.contains(sum) && j - i > maxLength) {
                    maxLength = j - i;
                    maxPrime = sum;
                }
            }
        }
        responseDto.setAnswer(maxPrime);
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
}
