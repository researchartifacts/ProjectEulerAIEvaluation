package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ313 {

    public ResponseDto Question313() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Sliding puzzle minimal number of moves
        for (int n = 1; n <= 100; n++) {
            for (int m = 1; m <= 100; m++) {
                result += (long)n * m;
            }
        }
        result = result / 100;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
