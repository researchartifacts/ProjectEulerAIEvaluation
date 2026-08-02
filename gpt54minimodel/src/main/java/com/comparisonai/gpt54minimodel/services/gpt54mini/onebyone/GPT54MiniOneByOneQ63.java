package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ63 extends GPT54MiniOneByOneBase {

    public ResponseDto Question63() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 1; n < 25; n++) {
            for (int x = 1; x <= 9; x++) {
                if (BigInteger.valueOf(x).pow(n).toString().length() == n) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
