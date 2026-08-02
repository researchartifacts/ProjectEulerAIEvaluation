package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ445 {

    public ResponseDto Question445() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int k = 1; k <= 100; k++) {
            long binomial = calculateBinomial(100, k);
            result = (result + binomial) % MOD;
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
}
