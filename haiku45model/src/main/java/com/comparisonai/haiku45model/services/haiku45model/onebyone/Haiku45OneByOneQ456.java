package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ456 {

    public ResponseDto Question456() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000;

        for (int i = 0; i < limit; i++) {
            for (int j = i + 1; j < limit; j++) {
                for (int k = j + 1; k < limit; k++) {
                    if (triangleContainsOrigin(i, j, k)) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean triangleContainsOrigin(int x1, int x2, int x3) {
        return (x1 + x2 > x3) && (x2 + x3 > x1) && (x1 + x3 > x2);
    }
}
