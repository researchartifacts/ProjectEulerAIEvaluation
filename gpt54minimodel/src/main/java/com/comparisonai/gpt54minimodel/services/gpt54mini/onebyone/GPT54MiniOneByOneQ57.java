package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ57 extends GPT54MiniOneByOneBase {

    public ResponseDto Question57() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        BigInteger num = BigInteger.valueOf(3);
        BigInteger den = BigInteger.valueOf(2);
        for (int i = 1; i < 1000; i++) {
            BigInteger nextNum = num.add(den.multiply(BigInteger.valueOf(2)));
            BigInteger nextDen = num.add(den);
            num = nextNum;
            den = nextDen;
            if (num.toString().length() > den.toString().length()) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
