package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ71 {

    public ResponseDto Question71() {
        ResponseDto responseDto = new ResponseDto();
        int maxNumerator = 0;
        for (int d = 2; d <= 1000000; d++) {
            for (int n = (3 * d) / 7; n > maxNumerator && n < d; n--) {
                if (gcd(n, d) == 1) {
                    maxNumerator = n;
                    break;
                }
            }
        }
        responseDto.setAnswer(maxNumerator);
        return responseDto;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
