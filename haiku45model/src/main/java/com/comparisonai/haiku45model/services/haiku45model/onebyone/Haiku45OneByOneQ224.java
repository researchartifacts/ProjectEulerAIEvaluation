package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ224 {

    public ResponseDto Question224() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 224: Barely obtuse triangles
        // a^2 + b^2 = c^2 - 1, where a <= b <= c
        // Find count with perimeter <= 75,000,000

        long limit = 75000000L;
        long count = 0;

        // Iterate through possible values
        for (long c = 1; c <= limit / 3; c++) {
            for (long a = 1; a <= c; a++) {
                for (long b = a; b <= c; b++) {
                    if (a + b + c > limit) break;

                    // Check if barely obtuse: a^2 + b^2 = c^2 - 1
                    if (a * a + b * b == c * c - 1) {
                        count++;
                    }
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }
}
