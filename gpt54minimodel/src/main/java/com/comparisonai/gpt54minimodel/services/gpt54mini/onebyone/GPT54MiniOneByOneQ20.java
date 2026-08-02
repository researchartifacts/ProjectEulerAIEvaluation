package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ20 extends GPT54MiniOneByOneBase {

    public ResponseDto Question20() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        String s = fact.toString();
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
