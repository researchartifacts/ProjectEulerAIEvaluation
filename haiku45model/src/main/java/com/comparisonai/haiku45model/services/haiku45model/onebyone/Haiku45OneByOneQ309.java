package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ309 {

    public ResponseDto Question309() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int limit = 100;
        for (int n = 1; n <= limit; n++) {
            for (int k = 1; k < n; k++) {
                result += 1;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
