package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ895 {

    public ResponseDto Question895() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += longestDivisorChain(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long longestDivisorChain(int n) {
        long max = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                max = Math.max(max, 1 + longestDivisorChain(i));
            }
        }
        return max;
    }
}
