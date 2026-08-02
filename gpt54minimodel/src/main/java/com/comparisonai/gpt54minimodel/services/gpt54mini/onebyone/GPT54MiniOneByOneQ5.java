package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ5 extends GPT54MiniOneByOneBase {

    public ResponseDto Question5() {
        ResponseDto responseDto = new ResponseDto();
        long result = 1;
        for (long i = 1; i <= 20; i++) {
            result = (result * i) / gcd(result, i);
        }
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
