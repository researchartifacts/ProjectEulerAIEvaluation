package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ365 {

    public ResponseDto Question365() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Problem 365
        result = 365;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
