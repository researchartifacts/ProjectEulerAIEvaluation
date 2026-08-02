package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 494: Collatz Prefix Families
 * Count distinct prefix families in Collatz sequences
 * Prefix: non-power-of-2 numbers in sequence before reaching power of 2
 */
@Service
public class Haiku45OneByOneQ494 {

    public ResponseDto Question494() {
        ResponseDto responseDto = new ResponseDto();

        long result = calculatePrefixFamilies(90);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculatePrefixFamilies(int m) {
        // Generate all sequence prefixes of length m
        Set<String> familySignatures = new HashSet<>();
        
        // Start from all possible starting values
        for (long start = 1; start <= 10_000_000; start++) {
            List<Long> prefix = getCollatzPrefix(start, m);
            
            if (prefix.size() == m) {
                String signature = getOrderSignature(prefix);
                familySignatures.add(signature);
            }
        }
        
        return familySignatures.size();
    }

    private List<Long> getCollatzPrefix(long n, int maxLength) {
        List<Long> prefix = new ArrayList<>();
        int count = 0;
        
        while (count < maxLength) {
            if (isPowerOf2(n)) {
                break;
            }
            prefix.add(n);
            count++;
            
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }
        
        return prefix;
    }

    private boolean isPowerOf2(long n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    private String getOrderSignature(List<Long> sequence) {
        // Create a signature based on ordering relationships
        StringBuilder sig = new StringBuilder();
        int n = sequence.size();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (sequence.get(i) < sequence.get(j)) {
                    sig.append("L");
                } else {
                    sig.append("G");
                }
            }
        }
        
        return sig.toString();
    }
}
