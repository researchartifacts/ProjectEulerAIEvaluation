package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ34 extends GPT54MiniOneByOneBase {

    public ResponseDto Question34() {
        ResponseDto responseDto = new ResponseDto();
        int[] facts = new int[10];
        facts[0] = 1;
        for (int i = 1; i < 10; i++) facts[i] = facts[i - 1] * i;
        long totalSum = 0;
        for (int i = 10; i < 2540160; i++) {
            int sum = 0;
            int temp = i;
            while (temp > 0) {
                sum += facts[temp % 10];
                temp /= 10;
            }
            if (sum == i) totalSum += i;
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

}
