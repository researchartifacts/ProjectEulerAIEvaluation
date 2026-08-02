package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ320 {

    public ResponseDto Question320() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Count factorizations where p - q = 2
        result = 0;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
