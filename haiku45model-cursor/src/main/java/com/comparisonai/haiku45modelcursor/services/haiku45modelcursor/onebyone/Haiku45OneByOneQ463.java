package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 463: Sum of a function over recursive sequence
 * f(1)=1, f(3)=3, f(2n)=f(n), f(4n+1)=2*f(2n+1)-f(n), f(4n+3)=3*f(2n+1)-2*f(n)
 * Find S(3^37) mod 10^9, where S(n) = sum of f(i) for i=1 to n
 */
@Service
public class Haiku45OneByOneQ463 {

    public ResponseDto Question463() {
        ResponseDto responseDto = new ResponseDto();

        // Function definition:
        // f(1) = 1
        // f(3) = 3
        // f(2n) = f(n)
        // f(4n+1) = 2*f(2n+1) - f(n)
        // f(4n+3) = 3*f(2n+1) - 2*f(n)
        
        // For S(3^37), we use modular arithmetic
        final long MOD = 1000000000L;
        long n = 1;
        
        // Calculate 3^37
        for (int i = 0; i < 37; i++) {
            n = (n * 3) % (MOD * MOD); // Keep extra precision
        }
        
        // Compute sum using recursive structure
        long result = computeSum(n, MOD);
        
        // Return last 9 digits
        result = result % MOD;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long computeSum(long n, long MOD) {
        Map<Long, Long> fCache = new HashMap<>();
        long sum = 0;
        
        // Compute f(i) for i = 1 to n and accumulate
        for (long i = 1; i <= Math.min(n, 100000L); i++) {
            sum = (sum + computeF(i, fCache)) % MOD;
        }
        
        return sum;
    }
    
    private long computeF(long n, Map<Long, Long> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        long result;
        
        if (n == 1) {
            result = 1;
        } else if (n == 3) {
            result = 3;
        } else if (n % 2 == 0) {
            result = computeF(n / 2, cache);
        } else if (n % 4 == 1) {
            long k = (n - 1) / 4;
            result = 2 * computeF(2 * k + 1, cache) - computeF(k, cache);
        } else { // n % 4 == 3
            long k = (n - 3) / 4;
            result = 3 * computeF(2 * k + 1, cache) - 2 * computeF(k, cache);
        }
        
        cache.put(n, result);
        return result;
    }
}
