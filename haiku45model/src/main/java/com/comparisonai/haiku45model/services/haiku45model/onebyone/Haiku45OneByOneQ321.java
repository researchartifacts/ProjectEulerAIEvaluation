package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ321 {

    public ResponseDto Question321() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 10;
        long count = 0;
        for (int i = 0; i < (1 << (2*n)); i++) {
            count++;
        }
        result = count;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
