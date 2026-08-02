package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ808 {

    public ResponseDto Question808() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> reversiblePrimeSquares = new ArrayList<>();
        long n = 2;
        
        while (reversiblePrimeSquares.size() < 50) {
            if (isPrime(n)) {
                long square = n * n;
                if (!isPalindrome(square)) {
                    long reversed = reverse(square);
                    long root = (long) Math.sqrt(reversed);
                    if (root * root == reversed && isPrime(root)) {
                        reversiblePrimeSquares.add(square);
                    }
                }
            }
            n++;
        }
        
        long sum = 0;
        for (long val : reversiblePrimeSquares) {
            sum += val;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private long reverse(long n) {
        return Long.parseLong(new StringBuilder(String.valueOf(n)).reverse().toString());
    }
}
