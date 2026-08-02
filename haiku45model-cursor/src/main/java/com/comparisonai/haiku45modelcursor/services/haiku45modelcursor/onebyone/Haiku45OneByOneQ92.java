package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 92
 */
@Service
public class Haiku45OneByOneQ92 {

    public ResponseDto Question92() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many starting numbers below 10 million will arrive at 89?
        // Generated logic to solve the problem:
        int count = 0;
        for (int i = 1; i < 10_000_000; i++) {
            if (endsAt89(i)) {
                count++;
            }
        }
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean endsAt89(int n) {
        while (n != 1 && n != 89) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 89;
    }
}
