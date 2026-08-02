package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ2 extends GPT54MiniOneByOneBase {

    public ResponseDto Question2() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long a = 1;
        long b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            long next = a + b;
            a = b;
            b = next;
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
