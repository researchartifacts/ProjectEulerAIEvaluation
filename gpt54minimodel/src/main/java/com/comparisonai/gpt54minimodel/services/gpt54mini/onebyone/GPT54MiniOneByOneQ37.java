package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ37 extends GPT54MiniOneByOneBase {

    public ResponseDto Question37() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int count = 0;
        for (int i = 11; count < 11; i++) {
            if (isTruncatablePrime(i)) {
                sum += i;
                count++;
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
