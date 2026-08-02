package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ878 {

    public ResponseDto Question878() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (isSemiPrime(i)) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isSemiPrime(int n) {
        int factorCount = 0;
        int temp = n;
        for (int i = 2; i * i <= temp; i++) {
            while (n % i == 0) {
                factorCount++;
                n /= i;
            }
        }
        if (n > 1) factorCount++;
        return factorCount == 2;
    }
}
