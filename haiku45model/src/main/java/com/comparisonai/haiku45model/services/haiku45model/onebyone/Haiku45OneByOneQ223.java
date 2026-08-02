package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ223 {

    public ResponseDto Question223() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 223: Barely acute triangles
        // a^2 + b^2 = c^2 + 1, where a <= b <= c
        // Find count with perimeter <= 25,000,000

        long limit = 25000000L;
        long count = 0;

        // Iterate through possible values
        for (long c = 1; c <= limit / 3; c++) {
            for (long a = 1; a <= c; a++) {
                for (long b = a; b <= c; b++) {
                    if (a + b + c > limit) break;

                    // Check if barely acute: a^2 + b^2 = c^2 + 1
                    if (a * a + b * b == c * c + 1) {
                        count++;
                    }
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }
}
