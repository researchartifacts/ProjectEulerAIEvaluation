package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ890 {

    public ResponseDto Question890() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            result += i;
        }

        responseDto.setAnswer(result * result);
        return responseDto;
    }
}
