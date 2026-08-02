package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ851 {

    public ResponseDto Question851() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            result += countPrimeFactors(i);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int countPrimeFactors(int n) {
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                count++;
                n /= i;
            }
        }
        if (n > 1) count++;
        return count;
    }
}
