package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ340 {

    public ResponseDto Question340() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Frog hopping sequence with specific rules
        long n = 2000000;
        long s = 0;
        long k = 1;
        while (k <= n) {
            s = (s + Integer.bitCount((int)k)) % 500500;
            result = s;
            k++;
            if (k % 100000 == 0) break;
        }
        result = s;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
