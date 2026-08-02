package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ125 {

    public ResponseDto Question125() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 100000000L;
        Set<Long> palindromes = new HashSet<>();

        for (long i = 1; i * i < limit; i++) {
            long sum = i * i;
            for (long j = i + 1; ; j++) {
                sum += j * j;
                if (sum >= limit) break;
                if (isPalindrome(sum)) {
                    palindromes.add(sum);
                }
            }
        }

        long totalSum = 0;
        for (long p : palindromes) {
            totalSum += p;
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

    private boolean isPalindrome(long n) {
        String s = String.valueOf(n);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
