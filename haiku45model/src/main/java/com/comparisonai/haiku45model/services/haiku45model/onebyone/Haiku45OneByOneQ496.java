package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ496 {

    public ResponseDto Question496() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int a = 1; a <= 100; a++) {
            for (int c = 1; c <= 100; c++) {
                int b = (a * c) / gcd(a, c);
                if (b <= 1000) {
                    result += b;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
