package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ3 extends GPT54MiniOneByOneBase {

    public ResponseDto Question3() {
        ResponseDto responseDto = new ResponseDto();
        long n = 600851475143L;
        long largestFactor = -1;
        while (n % 2 == 0) {
            largestFactor = 2;
            n /= 2;
        }
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largestFactor = i;
                n /= i;
            }
        }
        if (n > 2) {
            largestFactor = n;
        }
        responseDto.setAnswer(String.valueOf(largestFactor));
        return responseDto;
    }

}
