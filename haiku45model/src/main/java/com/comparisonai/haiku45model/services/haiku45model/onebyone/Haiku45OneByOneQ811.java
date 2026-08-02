package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ811 {

    public ResponseDto Question811() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000062031L;
        long t = 100000000000000L + 31;
        long r = 62;

        long result = computeH(t, r, MOD);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeH(long t, long r, long MOD) {
        long result = 1;
        for (long i = 0; i < r; i++) {
            result = computeA(result, MOD);
        }
        return result;
    }

    private long computeA(long n, long MOD) {
        if (n == 0) return 1;
        if (n % 2 == 0) {
            long halfN = n / 2;
            long b = largestPowerOf2(halfN);
            return (3 * computeA(halfN, MOD) + 5 * computeA(n - b, MOD)) % MOD;
        } else {
            return computeA((n - 1) / 2, MOD);
        }
    }

    private long largestPowerOf2(long n) {
        if (n == 0) return 0;
        long result = 1;
        while ((result & n) == 0) {
            result <<= 1;
        }
        return result / 2;
    }
}
