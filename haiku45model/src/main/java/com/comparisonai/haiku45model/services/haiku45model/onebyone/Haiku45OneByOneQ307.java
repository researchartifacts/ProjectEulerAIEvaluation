package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ307 {

    public ResponseDto Question307() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        double limit = 10000000000.0;
        double defect_rate = 0.00005;
        result = (long)(limit * defect_rate * 2.0);

        responseDto.setAnswer(result);
        return responseDto;
    }
}
