package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ3 {

    public ResponseDto Question3() {
        ResponseDto responseDto = new ResponseDto();
        long n = 600851475143L;
        long largestPrimeFactor = -1;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }
        if (n > 1) {
            largestPrimeFactor = n;
        }
        responseDto.setAnswer(largestPrimeFactor);
        return responseDto;
    }
}
