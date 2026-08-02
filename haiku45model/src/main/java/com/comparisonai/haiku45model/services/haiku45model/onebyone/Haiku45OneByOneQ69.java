package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ69 {

    public ResponseDto Question69() {
        ResponseDto responseDto = new ResponseDto();
        long maxN = 0;
        double maxRatio = 0;
        for (long n = 2; n <= 1000000; n++) {
            double ratio = (double) n / eulerTotient(n);
            if (ratio > maxRatio) {
                maxRatio = ratio;
                maxN = n;
            }
        }
        responseDto.setAnswer(maxN);
        return responseDto;
    }

    private long eulerTotient(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}
