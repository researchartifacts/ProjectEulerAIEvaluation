package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ310 {

    public ResponseDto Question310() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int limit = 10000;
        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                if ((x ^ y) != 0) result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
