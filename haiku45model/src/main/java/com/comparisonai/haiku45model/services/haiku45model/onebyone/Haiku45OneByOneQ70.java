package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ70 {

    public ResponseDto Question70() {
        ResponseDto responseDto = new ResponseDto();
        long minRatio = Long.MAX_VALUE;
        long result = 0;
        for (long n = 2; n < 10000000; n++) {
            long phi = eulerTotient(n);
            if (arePermutations(n, phi)) {
                long ratio = n / phi;
                if (ratio < minRatio) {
                    minRatio = ratio;
                    result = n;
                }
            }
        }
        responseDto.setAnswer(result);
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

    private boolean arePermutations(long a, long b) {
        char[] aChars = String.valueOf(a).toCharArray();
        char[] bChars = String.valueOf(b).toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return Arrays.equals(aChars, bChars);
    }
}
