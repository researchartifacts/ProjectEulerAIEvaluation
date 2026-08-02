package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ21 extends GPT54MiniOneByOneBase {

    public ResponseDto Question21() {
        ResponseDto responseDto = new ResponseDto();
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int d_a = sumDivisors(i);
            if (d_a != i && d_a < 10000) {
                if (sumDivisors(d_a) == i) {
                    sum += i;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
