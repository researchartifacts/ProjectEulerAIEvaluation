package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ36 extends GPT54MiniOneByOneBase {

    public ResponseDto Question36() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
