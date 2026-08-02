package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ305 {

    public ResponseDto Question305() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 10;
        for (int i = 1; i <= n; i++) {
            result += i * i;
        }
        result = 10000 - result;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
