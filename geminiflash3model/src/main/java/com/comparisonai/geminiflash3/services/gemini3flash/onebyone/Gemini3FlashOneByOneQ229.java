package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ229 {

    public ResponseDto Question229() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 2_000_000_000;
        
        // Count n <= limit such that n = a^2 + b^2, n = a^2 + 2b^2, n = a^2 + 3b^2, n = a^2 + 7b^2
        // This is equivalent to n having prime factors p such that:
        // d=1: p=2 or p=1 mod 4
        // d=2: p=2 or p=1,3 mod 8
        // d=3: p=3 or p=1 mod 3
        // d=7: p=7 or p=1,2,4 mod 7
        
        // We can use a sieve. For 2*10^9, use a BitSet or segment the sieve.
        // Actually, let's use the property: n is representable by all 4 iff 
        // all prime factors p of n satisfy:
        // p=2, or p is in the intersection of {1 mod 4}, {1,3 mod 8}, {1 mod 3}, {1,2,4 mod 7}
        // These are: p=2, or p = 1, 25, 121, ... mod 168?
        
        BitSet b1 = new BitSet(limit + 1);
        BitSet b2 = new BitSet(limit + 1);
        BitSet b3 = new BitSet(limit + 1);
        BitSet b7 = new BitSet(limit + 1);

        for (long a = 1; a * a < limit; a++) {
            long a2 = a * a;
            for (long b = 1; a2 + b * b <= limit; b++) b1.set((int) (a2 + b * b));
            for (long b = 1; a2 + 2 * b * b <= limit; b++) b2.set((int) (a2 + 2 * b * b));
            for (long b = 1; a2 + 3 * b * b <= limit; b++) b3.set((int) (a2 + 3 * b * b));
            for (long b = 1; a2 + 7 * b * b <= limit; b++) b7.set((int) (a2 + 7 * b * b));
        }
        
        int count = 0;
        for (int i = 1; i <= limit; i++) {
            if (b1.get(i) && b2.get(i) && b3.get(i) && b7.get(i)) {
                count++;
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
