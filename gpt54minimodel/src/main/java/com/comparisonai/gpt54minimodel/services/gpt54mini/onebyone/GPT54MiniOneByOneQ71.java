package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ71 extends GPT54MiniOneByOneBase {

    public ResponseDto Question71() {
        ResponseDto responseDto = new ResponseDto();
        long a = 3, b = 7;
        long bestN = 0, bestD = 1;
        for (long d = 1000000; d >= 2; d--) {
            long n = (a * d - 1) / b;
            if (n * bestD > bestN * d) {
                bestN = n;
                bestD = d;
            }
        }
        responseDto.setAnswer(String.valueOf(bestN));
        return responseDto;
    }

}
