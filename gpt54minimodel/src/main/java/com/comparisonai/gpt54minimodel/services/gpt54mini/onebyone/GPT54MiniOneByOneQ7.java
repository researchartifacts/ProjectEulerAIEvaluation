package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ7 extends GPT54MiniOneByOneBase {

    public ResponseDto Question7() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        int n = 1;
        while (count < 10001) {
            n++;
            if (isPrime(n)) {
                count++;
            }
        }
        responseDto.setAnswer(String.valueOf(n));
        return responseDto;
    }

}
