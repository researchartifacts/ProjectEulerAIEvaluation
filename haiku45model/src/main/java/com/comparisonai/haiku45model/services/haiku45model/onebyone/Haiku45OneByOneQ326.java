package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ326 {

    public ResponseDto Question326() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int count = 0;
        for (int m = 3; m <= 1000000; m++) {
            for (int e = 1; e < m; e++) {
                if ((e * e) % m == 1) count++;
            }
        }
        result = count;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
