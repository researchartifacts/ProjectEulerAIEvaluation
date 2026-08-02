package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ410 {

    public ResponseDto Question410() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000;

        for (int x = 0; x <= limit; x++) {
            for (int y = 0; y <= limit; y++) {
                long radius = (long) Math.sqrt(x * x + y * y);
                if (radius > 0 && radius * radius == x * x + y * y) {
                    result += radius;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
