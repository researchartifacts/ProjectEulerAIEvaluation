package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ9 extends GPT54MiniOneByOneBase {

    public ResponseDto Question9() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000; b++) {
                int c = 1000 - a - b;
                if (c > b && a * a + b * b == c * c) {
                    responseDto.setAnswer(String.valueOf((long) a * b * c));
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

}
