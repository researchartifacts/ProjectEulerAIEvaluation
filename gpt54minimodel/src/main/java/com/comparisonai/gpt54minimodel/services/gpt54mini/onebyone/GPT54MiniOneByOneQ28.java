package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ28 extends GPT54MiniOneByOneBase {

    public ResponseDto Question28() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 1;
        int n = 1001;
        for (int i = 3; i <= n; i += 2) {
            sum += 4L * i * i - 6L * (i - 1);
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
