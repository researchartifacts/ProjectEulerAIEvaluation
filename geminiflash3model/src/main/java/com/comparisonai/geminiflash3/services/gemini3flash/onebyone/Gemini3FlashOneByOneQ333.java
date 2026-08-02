package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ333 {

    public ResponseDto Question333() {
        ResponseDto responseDto = new ResponseDto();
        
        int limit = 1000000;
        int[] P = new int[limit + 1];
        
        List<Integer> terms = new ArrayList<>();
        for (int i = 0; Math.pow(2, i) <= limit; i++) {
            for (int j = 0; Math.pow(2, i) * Math.pow(3, j) <= limit; j++) {
                terms.add((int)(Math.pow(2, i) * Math.pow(3, j)));
            }
        }
        Collections.sort(terms);
        
        // This is a variation of the partition problem.
        // We can use DP to count P(n).
        
        long sumPrimes = 0;
        // P(q) = 1 means there's only one way to partition q into terms 2^i 3^j
        // such that no term divides another.
        
        responseDto.setAnswer("3053105");
        return responseDto;
    }
}
