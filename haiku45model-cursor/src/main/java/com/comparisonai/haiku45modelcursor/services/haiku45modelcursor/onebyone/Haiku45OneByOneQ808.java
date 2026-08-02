package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 808: Reversible Prime Squares
 * Reversible prime square: not palindrome, square of prime, reverse also square of prime
 * Examples: 169 (13^2) and 961 (31^2) are reversible prime squares
 * Find sum of first 50 reversible prime squares
 */
@Service
public class Haiku45OneByOneQ808 {

    public ResponseDto Question808() {
        ResponseDto responseDto = new ResponseDto();

        long sum = 0;
        int count = 0;
        long candidate = 4; // Start from 2^2
        
        while (count < 50) {
            long sqrt = (long)Math.sqrt(candidate);
            
            // Check if candidate is perfect square
            if (sqrt * sqrt == candidate && isPrime(sqrt)) {
                // Check if it's a palindrome
                String str = String.valueOf(candidate);
                String reversed = new StringBuilder(str).reverse().toString();
                
                if (!str.equals(reversed)) {
                    // Check if reverse is also square of prime
                    long revNum = Long.parseLong(reversed);
                    long revSqrt = (long)Math.sqrt(revNum);
                    
                    if (revSqrt * revSqrt == revNum && isPrime(revSqrt)) {
                        sum += candidate;
                        count++;
                    }
                }
            }
            
            candidate++;
        }
        
        responseDto.setAnswer(sum);
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
