package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ43 extends GPT54MiniOneByOneBase {

    public ResponseDto Question43() {
        ResponseDto responseDto = new ResponseDto();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        long sum = 0;
        int[] primes = {2, 3, 5, 7, 11, 13, 17};
        do {
            boolean property = true;
            for (int i = 0; i < 7; i++) {
                int num = digits[i + 1] * 100 + digits[i + 2] * 10 + digits[i + 3];
                if (num % primes[i] != 0) {
                    property = false;
                    break;
                }
            }
            if (property) {
                long n = 0;
                for (int d : digits) n = n * 10 + d;
                sum += n;
            }
        } while (nextPermutationWithBool(digits));
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
