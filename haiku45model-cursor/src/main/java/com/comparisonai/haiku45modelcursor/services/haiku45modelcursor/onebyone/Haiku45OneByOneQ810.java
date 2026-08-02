package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 810: XOR-product and XOR-primes
 * XOR-product: similar to long multiplication but XOR operations instead of addition
 * XOR-prime: n > 1 not expressible as XOR-product of two integers > 1
 * Examples: 2,3,7,11,13,... (10th XOR-prime is 41)
 * Find 5,000,000th XOR-prime
 */
@Service
public class Haiku45OneByOneQ810 {

    public ResponseDto Question810() {
        ResponseDto responseDto = new ResponseDto();

        long count = 0;
        long candidate = 2;
        long targetCount = 5000000;
        
        while (count < targetCount) {
            if (isXORPrime(candidate)) {
                count++;
                if (count == targetCount) {
                    responseDto.setAnswer(candidate);
                    return responseDto;
                }
            }
            candidate++;
        }
        
        responseDto.setAnswer(0L);
        return responseDto;
    }
    
    private boolean isXORPrime(long n) {
        // Check if n can be expressed as XOR-product of two integers > 1
        // Try all factorizations
        for (long a = 2; a * a <= n; a++) {
            if (xorProduct(a, n / a) == n) {
                return false;
            }
        }
        return true;
    }
    
    private long xorProduct(long x, long y) {
        // Calculate XOR-product: similar to long multiplication with XOR
        long result = 0;
        long shift = 0;
        
        while (y > 0) {
            if ((y & 1) == 1) {
                result ^= (x << shift);
            }
            y >>= 1;
            shift++;
        }
        return result;
    }
}
