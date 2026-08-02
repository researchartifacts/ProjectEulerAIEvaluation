package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ15 extends GPT54MiniOneByOneBase {

    public ResponseDto Question15() {
        ResponseDto responseDto = new ResponseDto();
        long n = 20;
        long k = 20;
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n + i) / i;
        }
        responseDto.setAnswer(String.valueOf(res));
        return responseDto;
    }

}
