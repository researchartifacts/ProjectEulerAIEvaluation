package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ303 {

    public ResponseDto Question303() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        long n = 123456789L;
        long k = 1;
        while ((k * 6) % n != 0 && k < 2000000000L) {
            k++;
        }
        result = k;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
