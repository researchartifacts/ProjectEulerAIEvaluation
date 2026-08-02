package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ56 extends GPT54MiniOneByOneBase {

    public ResponseDto Question56() {
        ResponseDto responseDto = new ResponseDto();
        int max = 0;
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                BigInteger n = BigInteger.valueOf(a).pow(b);
                int sum = 0;
                for (char c : n.toString().toCharArray()) sum += Character.getNumericValue(c);
                max = Math.max(max, sum);
            }
        }
        responseDto.setAnswer(String.valueOf(max));
        return responseDto;
    }

}
