package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ73 {

    public ResponseDto Question73() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int d = 1; d <= 12000; d++) {
            for (int n = d / 3; n <= d / 2; n++) {
                if (gcd(n, d) == 1 && (double) n / d > (double) 1 / 3 && (double) n / d < (double) 1 / 2) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
