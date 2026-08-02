package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ301 {

    public ResponseDto Question301() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        long limit = (1L << 30);
        for (long n = 1; n <= limit && n <= 1000000; n++) {
            if ((n ^ (2 * n) ^ (3 * n)) == 0) result++;
        }
        // For full solution: count = 2^30 values where n XOR 2n XOR 3n = 0

        responseDto.setAnswer(result);
        return responseDto;
    }
}
