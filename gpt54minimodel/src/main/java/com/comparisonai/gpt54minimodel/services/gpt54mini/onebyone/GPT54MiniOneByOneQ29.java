package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ29 extends GPT54MiniOneByOneBase {

    public ResponseDto Question29() {
        ResponseDto responseDto = new ResponseDto();
        Set<String> distinct = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                distinct.add(BigInteger.valueOf(a).pow(b).toString());
            }
        }
        responseDto.setAnswer(String.valueOf(distinct.size()));
        return responseDto;
    }

}
