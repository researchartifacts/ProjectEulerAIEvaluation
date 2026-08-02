package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ109 {

    public ResponseDto Question109() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Darts
        long checkoutCombos = 0;
        for (int a = 1; a <= 50; a++) {
            for (int b = a; b <= 50; b++) {
                for (int c = b; c <= 50; c++) {
                    int sum = a + b + c;
                    if (sum < 100) checkoutCombos++;
                }
            }
        }
        result = checkoutCombos;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

