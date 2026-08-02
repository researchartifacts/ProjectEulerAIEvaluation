package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ306 {

    public ResponseDto Question306() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int limit = 100000;
        for (int i = 1; i <= limit; i++) {
            int count = Integer.bitCount(i ^ (i >> 1));
            if (count % 2 == 1) result++;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
