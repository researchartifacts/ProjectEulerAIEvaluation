package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ72 extends GPT54MiniOneByOneBase {

    public ResponseDto Question72() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] phi = new int[limit + 1];
        for (int i = 0; i <= limit; i++) phi[i] = i;
        for (int i = 2; i <= limit; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= limit; j += i) {
                    phi[j] -= phi[j] / i;
                }
            }
        }
        long sum = 0;
        for (int i = 2; i <= limit; i++) sum += phi[i];
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
