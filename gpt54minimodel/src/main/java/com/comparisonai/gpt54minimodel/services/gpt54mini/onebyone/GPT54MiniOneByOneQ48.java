package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ48 extends GPT54MiniOneByOneBase {

    public ResponseDto Question48() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger sum = BigInteger.ZERO;
        BigInteger mod = BigInteger.TEN.pow(10);
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), mod)).mod(mod);
        }
        responseDto.setAnswer(sum.toString());
        return responseDto;
    }

}
