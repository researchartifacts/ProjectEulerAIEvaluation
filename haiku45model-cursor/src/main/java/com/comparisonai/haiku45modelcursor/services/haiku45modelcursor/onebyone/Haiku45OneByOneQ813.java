package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 813: XOR-product Power
 * x ⊗ y = XOR-product (like long multiplication with XOR instead of addition)
 * P(n) = 11^⊗n = 11⊗11⊗...⊗11 (n times)
 * P(2) = 69
 * Find P(8^12 * 12^8) mod 10^9+7
 */
@Service
public class Haiku45OneByOneQ813 {

    public ResponseDto Question813() {
        ResponseDto responseDto = new ResponseDto();

        final long MOD = 1000000007L;
        
        // Calculate exponent: 8^12 * 12^8
        long exp = modPower(8, 12, MOD) * modPower(12, 8, MOD) % MOD;
        
        // Calculate P(exp) = 11^⊗exp
        long result = xorPower(11, exp, MOD);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long xorPower(long base, long exponent, long mod) {
        // Calculate base^⊗exponent using binary exponentiation with XOR product
        long result = base;
        exponent--;
        
        // Use binary exponentiation
        long accumulator = base;
        
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = xorProduct(result, accumulator);
            }
            accumulator = xorProduct(accumulator, accumulator);
            exponent >>= 1;
        }
        
        return result % mod;
    }
    
    private long xorProduct(long x, long y) {
        // Calculate x ⊗ y
        long result = 0;
        int shift = 0;
        
        while (y > 0) {
            if ((y & 1) == 1) {
                result ^= (x << shift);
            }
            y >>= 1;
            shift++;
        }
        return result;
    }
    
    private long modPower(long base, long exp, long mod) {
        long result = 1;
        base = base % mod;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            exp >>= 1;
            base = (base * base) % mod;
        }
        return result;
    }
}
