package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 14: Longest Collatz sequence
 */
@Service
public class Haiku45OneByOneQ14 {

    public ResponseDto Question14() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Which starting number under one million produces the longest Collatz chain?
        // Collatz sequence: n -> n/2 (if even), n -> 3n+1 (if odd)
        
        long maxLength = 0;
        long numberWithMaxLength = 0;
        Map<Long, Long> cache = new HashMap<>();
        
        for (long i = 1; i < 1000000; i++) {
            long length = getCollatzLength(i, cache);
            if (length > maxLength) {
                maxLength = length;
                numberWithMaxLength = i;
            }
        }
        
        Object result = numberWithMaxLength;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long getCollatzLength(long n, Map<Long, Long> cache) {
        if (n == 1) return 1;
        if (cache.containsKey(n)) return cache.get(n);
        
        long length;
        if (n % 2 == 0) {
            length = 1 + getCollatzLength(n / 2, cache);
        } else {
            length = 1 + getCollatzLength(3 * n + 1, cache);
        }
        
        cache.put(n, length);
        return length;
    }
}
