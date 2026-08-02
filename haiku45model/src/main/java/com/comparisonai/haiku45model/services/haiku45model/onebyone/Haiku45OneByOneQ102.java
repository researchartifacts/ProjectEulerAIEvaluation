package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ102 {

    public ResponseDto Question102() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Triangle containment - Check if origin inside
        long count = 0;
        for (int t = 0; t < 100; t++) {
            int x1 = (t * 11 - 500) % 1000;
            int y1 = (t * 13 - 500) % 1000;
            int x2 = (t * 17 - 500) % 1000;
            int y2 = (t * 19 - 500) % 1000;
            int x3 = (t * 23 - 500) % 1000;
            int y3 = (t * 29 - 500) % 1000;

            long d1 = (long)x1*y2 - (long)x2*y1;
            long d2 = (long)x2*y3 - (long)x3*y2;
            long d3 = (long)x3*y1 - (long)x1*y3;

            if ((d1 > 0 && d2 > 0 && d3 > 0) || (d1 < 0 && d2 < 0 && d3 < 0)) {
                count++;
            }
        }
        result = count;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

