package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ35 extends GPT54MiniOneByOneBase {

    public ResponseDto Question35() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isCircularPrime(i)) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
