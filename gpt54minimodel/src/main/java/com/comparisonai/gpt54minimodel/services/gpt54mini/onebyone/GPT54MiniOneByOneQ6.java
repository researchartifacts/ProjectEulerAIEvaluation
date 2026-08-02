package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ6 extends GPT54MiniOneByOneBase {

    public ResponseDto Question6() {
        ResponseDto responseDto = new ResponseDto();
        long sumOfSquares = 0;
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += (long) i * i;
            sum += i;
        }
        long squareOfSum = sum * sum;
        responseDto.setAnswer(String.valueOf(squareOfSum - sumOfSquares));
        return responseDto;
    }

}
