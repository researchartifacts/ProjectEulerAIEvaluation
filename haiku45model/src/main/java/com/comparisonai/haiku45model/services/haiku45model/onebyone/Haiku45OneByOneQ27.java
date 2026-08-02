package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ27 {

    public ResponseDto Question27() {
        ResponseDto responseDto = new ResponseDto();
        long maxProduct = 0;
        long maxA = 0, maxB = 0;
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < 100000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int a = -999; a < 1000; a++) {
            for (int b = -999; b < 1000; b++) {
                int n = 0;
                while (true) {
                    long result = (long) n * n + a * n + b;
                    if (result <= 1 || !primes.contains((int) result)) break;
                    n++;
                }
                if (n > maxProduct) {
                    maxProduct = n;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        responseDto.setAnswer(maxA * maxB);
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
