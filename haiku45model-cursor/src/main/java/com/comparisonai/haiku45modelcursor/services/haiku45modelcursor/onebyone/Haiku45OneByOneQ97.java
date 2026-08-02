package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 97
 */
@Service
public class Haiku45OneByOneQ97 {

    public ResponseDto Question97() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find last 10 digits of 28433 * 2^7830457 + 1
        // Generated logic to solve the problem:
        // Use modular arithmetic: compute (28433 * 2^7830457 + 1) mod 10^10
        long mod = 10_000_000_000L;
        long base = 28433L % mod;
        long exponent = 7830457L;
        
        // Compute 2^7830457 mod 10^10 using fast exponentiation
        long powerOf2 = modPow(2, exponent, mod);
        
        // Result = (28433 * 2^7830457 + 1) mod 10^10
        long result = ((base * powerOf2) % mod + 1) % mod;
        
        // Pad with leading zeros if necessary
        String answer = String.format("%010d", result);
        
        Object result_obj = answer;
        
        responseDto.setAnswer(result_obj);
        return responseDto;
    }
    
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
