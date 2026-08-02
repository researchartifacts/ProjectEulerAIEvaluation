package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ58 extends GPT54MiniOneByOneBase {

    public ResponseDto Question58() {
        ResponseDto responseDto = new ResponseDto();
        int primes = 0;
        int total = 1;
        for (int i = 3; ; i += 2) {
            for (int j = 0; j < 4; j++) {
                if (isPrime(i * i - j * (i - 1))) primes++;
            }
            total += 4;
            if ((double) primes / total < 0.1) {
                responseDto.setAnswer(String.valueOf(i));
                return responseDto;
            }
        }
    }

}
