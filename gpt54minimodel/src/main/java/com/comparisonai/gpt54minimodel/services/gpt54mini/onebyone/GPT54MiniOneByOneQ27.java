package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ27 extends GPT54MiniOneByOneBase {

    public ResponseDto Question27() {
        ResponseDto responseDto = new ResponseDto();
        int maxPrimes = 0;
        int bestA = 0;
        int bestB = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                int n = 0;
                while (isPrime(Math.abs(n * n + a * n + b))) {
                    n++;
                }
                if (n > maxPrimes) {
                    maxPrimes = n;
                    bestA = a;
                    bestB = b;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(bestA * bestB));
        return responseDto;
    }

}
