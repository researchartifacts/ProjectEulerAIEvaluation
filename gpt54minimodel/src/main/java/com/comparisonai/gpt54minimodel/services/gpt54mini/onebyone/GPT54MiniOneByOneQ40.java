package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ40 extends GPT54MiniOneByOneBase {

    public ResponseDto Question40() {
        ResponseDto responseDto = new ResponseDto();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() < 1000000; i++) {
            sb.append(i);
        }
        int product = 1;
        for (int i = 0; i <= 6; i++) {
            product *= Character.getNumericValue(sb.charAt((int) Math.pow(10, i) - 1));
        }
        responseDto.setAnswer(String.valueOf(product));
        return responseDto;
    }

}
