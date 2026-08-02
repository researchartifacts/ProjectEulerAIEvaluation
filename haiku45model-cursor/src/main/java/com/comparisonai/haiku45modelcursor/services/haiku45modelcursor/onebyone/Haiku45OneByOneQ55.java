package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 55
 */
@Service
public class Haiku45OneByOneQ55 {

    public ResponseDto Question55() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many Lychrel numbers are there below ten-thousand?
        // A Lychrel number doesn't produce a palindrome through reverse and add process after 50 iterations
        // Generated logic to solve the problem:
        
        java.util.function.Function<Long, Long> reverseNumber = n -> {
            long result = 0;
            while (n > 0) {
                result = result * 10 + n % 10;
                n /= 10;
            }
            return result;
        };
        
        java.util.function.Function<Long, Boolean> isPalindrome = n -> {
            String s = String.valueOf(n);
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - 1 - i)) return false;
            }
            return true;
        };
        
        java.util.function.Function<Long, Boolean> isLychrel = n -> {
            long current = n;
            for (int iter = 0; iter < 50; iter++) {
                current = current + reverseNumber.apply(current);
                if (isPalindrome.apply(current)) return false;
            }
            return true;
        };
        
        long result = 0;
        for (long i = 1; i < 10000; i++) {
            if (isLychrel.apply(i)) {
                result++;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
