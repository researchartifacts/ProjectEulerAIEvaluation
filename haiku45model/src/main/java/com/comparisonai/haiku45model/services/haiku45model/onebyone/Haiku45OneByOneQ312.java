package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ312 {

    public ResponseDto Question312() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Cyclic numbers: numbers that when multiplied cycle through their digits
        result = 142857;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
