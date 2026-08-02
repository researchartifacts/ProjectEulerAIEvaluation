package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ32 extends GPT54MiniOneByOneBase {

    public ResponseDto Question32() {
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> products = new HashSet<>();
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 10000; b++) {
                int p = a * b;
                if (isPandigital(a + "" + b + "" + p)) {
                    products.add(p);
                }
            }
        }
        long sum = 0;
        for (int p : products) sum += p;
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
