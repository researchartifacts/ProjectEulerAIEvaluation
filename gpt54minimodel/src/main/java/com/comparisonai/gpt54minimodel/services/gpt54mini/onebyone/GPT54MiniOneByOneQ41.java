package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ41 extends GPT54MiniOneByOneBase {

    public ResponseDto Question41() {
        ResponseDto responseDto = new ResponseDto();
        for (int n = 7; n >= 1; n--) {
            int[] digits = new int[n];
            for (int i = 0; i < n; i++) digits[i] = n - i;
            do {
                long num = 0;
                for (int d : digits) num = num * 10 + d;
                if (isPrime(num)) {
                    responseDto.setAnswer(String.valueOf(num));
                    return responseDto;
                }
            } while (prevPermutation(digits));
        }
        return responseDto;
    }

}
