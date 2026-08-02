package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ30 extends GPT54MiniOneByOneBase {

    public ResponseDto Question30() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int i = 2; i < 1000000; i++) {
            if (i == sumOfFifthPowers(i)) {
                totalSum += i;
            }
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

}
