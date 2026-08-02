package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ16 extends GPT54MiniOneByOneBase {

    public ResponseDto Question16() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger n = BigInteger.valueOf(2).pow(1000);
        String s = n.toString();
        long sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
