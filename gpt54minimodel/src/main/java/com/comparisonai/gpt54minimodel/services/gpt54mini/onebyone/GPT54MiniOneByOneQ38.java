package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ38 extends GPT54MiniOneByOneBase {

    public ResponseDto Question38() {
        ResponseDto responseDto = new ResponseDto();
        long max = 0;
        for (int i = 1; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int n = 1; sb.length() < 9; n++) {
                sb.append(i * n);
            }
            if (isPandigital(sb.toString())) {
                max = Math.max(max, Long.parseLong(sb.toString()));
            }
        }
        responseDto.setAnswer(String.valueOf(max));
        return responseDto;
    }

}
