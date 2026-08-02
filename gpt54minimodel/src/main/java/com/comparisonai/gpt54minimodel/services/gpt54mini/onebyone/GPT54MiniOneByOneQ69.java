package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ69 extends GPT54MiniOneByOneBase {

    public ResponseDto Question69() {
        ResponseDto responseDto = new ResponseDto();
        int result = 1;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        for (int p : primes) {
            if (result * p > 1000000) break;
            result *= p;
        }
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
