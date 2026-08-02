package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ846 {

    public ResponseDto Question846() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (isValid(i, j)) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isValid(int i, int j) {
        return (i + j) % 2 == 0;
    }
}
