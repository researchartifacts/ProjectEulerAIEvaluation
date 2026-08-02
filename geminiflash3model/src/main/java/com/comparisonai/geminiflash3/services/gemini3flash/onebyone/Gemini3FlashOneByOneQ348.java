package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ348 {

    public ResponseDto Question348() {
        ResponseDto responseDto = new ResponseDto();
        
        // Sum of square and cube.
        // We can precompute values and store in a map.
        Map<Long, Integer> counts = new HashMap<>();
        
        long limit = 1_000_000_000; // Educated guess for limit
        for (long c = 2; c * c * c < limit; c++) {
            long c3 = c * c * c;
            for (long s = 2; s * s + c3 < limit; s++) {
                long n = s * s + c3;
                if (isPalindrome(n)) {
                    counts.put(n, counts.getOrDefault(n, 0) + 1);
                }
            }
        }
        
        List<Long> results = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 4) {
                results.add(entry.getKey());
            }
        }
        Collections.sort(results);
        
        long sum = 0;
        for (int i = 0; i < 5 && i < results.size(); i++) {
            sum += results.get(i);
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }
    
    private boolean isPalindrome(long n) {
        String s = Long.toString(n);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
