package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ482 {

    public ResponseDto Question482() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = a; b <= 100; b++) {
                for (int c = b; c <= 100; c++) {
                    if (a + b > c) {
                        int perimeter = a + b + c;
                        result += perimeter;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
