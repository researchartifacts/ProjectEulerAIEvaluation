package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ755 {

    public ResponseDto Question755() {
        ResponseDto responseDto = new ResponseDto();
        long n = 10000000000000L;
        
        List<Long> fibs = new ArrayList<>();
        long a = 1, b = 2;
        while (a <= n) {
            fibs.add(a);
            long temp = a + b;
            a = b;
            b = temp;
        }
        
        // S(n) = Sum_{k=0}^n f(k)
        // This can be solved using digit DP style on Fibonacci representation
        long result = countSum(n, fibs, fibs.size() - 1);
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countSum(long n, List<Long> fibs, int index) {
        if (n < 0) return 0;
        if (index < 0) return 1;
        long f = fibs.get(index);
        if (n >= f) {
            // Either use fibs.get(index) or not
            return countSum(n - f, fibs, index - 1) + countSum(f - 1, fibs, index - 1);
        } else {
            return countSum(n, fibs, index - 1);
        }
    }
}
