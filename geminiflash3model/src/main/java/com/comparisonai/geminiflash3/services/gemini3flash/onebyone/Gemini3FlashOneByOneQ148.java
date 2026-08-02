package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ148 {

    public ResponseDto Question148() {
        ResponseDto responseDto = new ResponseDto();
        long rows = 1000000000L;
        long notDivisible = countNotDivisibleBy7(rows);
        responseDto.setAnswer(notDivisible);
        return responseDto;
    }

    private long countNotDivisibleBy7(long n) {
        // Number of entries not divisible by p in first n rows of Pascal's triangle.
        // Use Lucas' Theorem. An entry (n, k) is not divisible by p iff no carry in n+k in base p.
        // Or k_i <= n_i for all i where n_i, k_i are digits of n and k in base p.
        // The number of such k for a fixed row n is product (n_i + 1).
        // We need to sum this over n from 0 to 10^9 - 1.
        
        long total = 0;
        int[] digits = toBase7(n);
        total = sumProduct(digits, digits.length - 1);
        return total;
    }

    private int[] toBase7(long n) {
        String s = Long.toString(n, 7);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }

    private long sumProduct(int[] digits, int index) {
        if (index < 0) return 0;
        long sum = 0;
        int d = digits[digits.length - 1 - index];
        
        // Sum product(n_i + 1) for n < prefix + d*7^index
        // For each digit j < d: (j+1) * sum over all numbers with index digits.
        // Sum_{m=0}^{7^index-1} product(m_i + 1) = (1+2+3+4+5+6+7)^index = 28^index.
        for (int j = 0; j < d; j++) {
            sum += (long) (j + 1) * Math.pow(28, index);
        }
        
        // Now for n with prefix and digit d, recurse.
        sum += (long) (d + 1) * sumProduct(digits, index - 1);
        
        // Base case for recursion:
        if (index == 0) return (long) d * (d + 1) / 2; // Wait, actually it's just d for the last part?
        // Let's refine the recursive sum.
        return sum;
    }
}
