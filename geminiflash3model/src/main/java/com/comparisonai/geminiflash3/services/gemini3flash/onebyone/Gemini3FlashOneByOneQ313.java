package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ313 {

    public ResponseDto Question313() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1000000;
        boolean[] isPrime = new boolean[(int) limit];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < limit; i++) {
            if (!isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j < limit; j += i) isPrime[j] = true;
            }
        }
        
        long count = 0;
        for (int p : primes) {
            long p2 = (long) p * p;
            // S(m, n) = 6*max(m,n) + 2*min(m,n) - 13 = p2
            // Let m = min, n = max. 6n + 2m - 13 = p2
            // 2m = p2 + 13 - 6n
            // Since 2 <= m <= n, we have:
            // 4 <= 2m <= 2n  => 4 <= p2 + 13 - 6n <= 2n
            // p2 + 13 - 6n >= 4 => 6n <= p2 + 9 => n <= (p2 + 9) / 6
            // p2 + 13 - 6n <= 2n => 8n >= p2 + 13 => n >= (p2 + 13) / 8
            
            long minN = (p2 + 13 + 7) / 8; // ceil((p2+13)/8)
            long maxN = (p2 + 9) / 6;
            
            if (maxN >= minN) {
                // For each n in [minN, maxN], check if 2m = p2 + 13 - 6n gives an integer m
                // p2 + 13 - 6n must be even, which it is since p is odd (p2 is odd) and 13 is odd.
                // p=2 is a special case.
                if (p == 2) {
                    // S(m, n) = 4, but p2 = 4. 6n + 2m = 17. No integer solution.
                } else {
                    count += (maxN - minN + 1);
                }
            }
        }
        
        // The problem asks for m, n grid. m, n are interchangeable in S(m, n) 
        // but the question implies distinct grids (m, n).
        // Usually (m, n) and (n, m) are considered the same grid unless specified.
        // Example says 5482 grids for p < 100.
        // My count counts pairs (m, n) with m <= n.
        
        responseDto.setAnswer(count * 2); // m != n cases are counted twice
        return responseDto;
    }
}
