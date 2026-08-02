package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ831 {

    public ResponseDto Question831() {
        ResponseDto responseDto = new ResponseDto();

        long m = 142857;
        long result = calculateG(m);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateG(long m) {
        long sum = 0;
        for (long j = 0; j <= m; j++) {
            for (long i = 0; i <= j; i++) {
                long sign = ((j - i) % 2 == 0) ? 1 : -1;
                long binomial1 = binomialCoeff(m, j);
                long binomial2 = binomialCoeff(j, i);
                long binomial3 = binomialCoeff(j + 5 + 6 * i, j + 5);
                sum += sign * binomial1 * binomial2 * binomial3;
            }
        }
        return sum;
    }

    private long binomialCoeff(long n, long k) {
        if (k > n || k < 0) return 0;
        if (k == 0 || k == n) return 1;

        long result = 1;
        for (long i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
}
