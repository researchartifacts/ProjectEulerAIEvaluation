package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ25 extends GPT54MiniOneByOneBase {

    public ResponseDto Question25() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 2;
        while (b.toString().length() < 1000) {
            BigInteger next = a.add(b);
            a = b;
            b = next;
            index++;
        }
        responseDto.setAnswer(String.valueOf(index));
        return responseDto;
    }

}
