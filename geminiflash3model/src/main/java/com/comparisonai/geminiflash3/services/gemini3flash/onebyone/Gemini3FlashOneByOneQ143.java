package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ143 {

    public ResponseDto Question143() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 120000;
        Map<Integer, Set<Integer>> pairs = new HashMap<>();
        
        for (long u = 1; u < limit; u++) {
            for (long v = u + 1; u + v < limit; v++) {
                if (isSquare(u * u + v * v + u * v)) {
                    pairs.computeIfAbsent((int) u, k -> new HashSet<>()).add((int) v);
                }
            }
        }
        
        Set<Integer> sums = new HashSet<>();
        for (int p : pairs.keySet()) {
            for (int q : pairs.get(p)) {
                if (pairs.containsKey(q)) {
                    for (int r : pairs.get(q)) {
                        if (p + q + r <= limit && pairs.get(p).contains(r)) {
                            sums.add(p + q + r);
                        }
                    }
                }
            }
        }
        
        long totalSum = 0;
        for (int s : sums) totalSum += s;
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private boolean isSquare(long n) {
        long s = (long) Math.sqrt(n);
        return s * s == n;
    }
}
