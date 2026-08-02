package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ468 {

    public ResponseDto Question468() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000993L;
        long result = 0;

        for (int n = 2; n <= 100; n++) {
            for (int k = 1; k <= n - 1; k++) {
                long binomial = calculateBinomial(n, k);
                long largestSmoothDivisor = findLargestBSmooth(binomial, 100);
                result = (result + largestSmoothDivisor) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateBinomial(int n, int k) {
        if (k > n - k) k = n - k;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }

    private long findLargestBSmooth(long n, int b) {
        long smooth = 1;
        for (int p = 2; p <= b; p++) {
            while (n % p == 0) {
                smooth *= p;
                n /= p;
            }
        }
        return smooth;
    }
}
