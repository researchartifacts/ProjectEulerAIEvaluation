package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ12 extends GPT54MiniOneByOneBase {

    public ResponseDto Question12() {
        ResponseDto responseDto = new ResponseDto();
        long triangle = 0;
        for (long i = 1; ; i++) {
            triangle += i;
            if (countDivisors(triangle) > 500) {
                responseDto.setAnswer(String.valueOf(triangle));
                break;
            }
        }
        return responseDto;
    }

}
