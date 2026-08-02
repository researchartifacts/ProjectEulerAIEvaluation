package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 78
 */
@Service
public class Haiku45OneByOneQ78 {

    public ResponseDto Question78() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find least n where partition function p(n) is divisible by 1,000,000
        // Generated logic to solve the problem:
        
        final int LIMIT = 1000000;
        java.util.Map<Integer, Long> partitions = new java.util.HashMap<>();
        partitions.put(0, 1L);
        
        // Calculate partition function using pentagonal numbers
        for (int n = 1; n < 100000; n++) {
            long pn = 0;
            int k = 1;
            
            while (true) {
                // Pentagonal numbers: k(3k-1)/2 and k(3k+1)/2
                int pent1 = k * (3 * k - 1) / 2;
                int pent2 = k * (3 * k + 1) / 2;
                
                if (pent1 > n) break;
                
                int sign = (k % 2 == 1) ? 1 : -1;
                
                pn += sign * partitions.getOrDefault(n - pent1, 0L);
                
                if (pent2 <= n) {
                    pn += sign * partitions.getOrDefault(n - pent2, 0L);
                }
                
                k++;
            }
            
            partitions.put(n, pn);
            
            if (pn % LIMIT == 0) {
                Object result = n;
                responseDto.setAnswer(result);
                return responseDto;
            }
        }
        
        Object result = null;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
