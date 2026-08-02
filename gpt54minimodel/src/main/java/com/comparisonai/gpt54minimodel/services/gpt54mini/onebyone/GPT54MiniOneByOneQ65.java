package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ65 extends GPT54MiniOneByOneBase {

    public ResponseDto Question65() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger n = BigInteger.valueOf(2);
        BigInteger d = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            BigInteger a = (i % 3 == 0) ? BigInteger.valueOf(2 * (i / 3)) : BigInteger.ONE;
            BigInteger temp = n;
            n = a.multiply(n).add(d);
            d = temp;
        }
        long sum = 0;
        for (char c : n.toString().toCharArray()) sum += Character.getNumericValue(c);
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
