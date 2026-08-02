package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ10 extends GPT54MiniOneByOneBase {

    public ResponseDto Question10() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
