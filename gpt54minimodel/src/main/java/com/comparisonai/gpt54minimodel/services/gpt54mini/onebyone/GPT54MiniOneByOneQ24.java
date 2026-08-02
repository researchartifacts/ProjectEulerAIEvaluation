package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ24 extends GPT54MiniOneByOneBase {

    public ResponseDto Question24() {
        ResponseDto responseDto = new ResponseDto();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 1; i < 1000000; i++) {
            nextPermutation(digits);
        }
        StringBuilder sb = new StringBuilder();
        for (int d : digits) sb.append(d);
        responseDto.setAnswer(sb.toString());
        return responseDto;
    }

}
