package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ53 {

    public ResponseDto Question53() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (binomialCoefficient(n, r) > 1000000) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private long binomialCoefficient(int n, int r) {
        if (r > n) return 0;
        if (r == 0 || r == n) return 1;
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
}
