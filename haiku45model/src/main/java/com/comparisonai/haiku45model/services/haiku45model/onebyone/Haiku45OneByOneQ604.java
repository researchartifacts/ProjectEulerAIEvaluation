package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ604 {

    public ResponseDto Question604() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long n = 1000;
        long count = 0;
        for (long x = 1; x <= n; x++) {
            for (long y = 1; y <= x && y <= n; y++) {
                count++;
            }
        }
        result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }
}
