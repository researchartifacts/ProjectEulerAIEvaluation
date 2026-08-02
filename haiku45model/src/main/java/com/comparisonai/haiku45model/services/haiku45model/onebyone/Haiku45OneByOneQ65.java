package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ65 {

    public ResponseDto Question65() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger[] convergents = new BigInteger[100];
        convergents[0] = BigInteger.valueOf(2);
        convergents[1] = BigInteger.valueOf(2);
        for (int i = 2; i < 100; i++) {
            int a = 1 + (i - 1) / 3 * 2 + ((i - 1) % 3 == 1 ? 1 : 0) * 2;
            if ((i - 1) % 3 == 0) a = 1;
            if ((i - 1) % 3 == 1) a = 2 * ((i - 1) / 3 + 1);
            BigInteger num1 = convergents[i - 1].multiply(BigInteger.valueOf(a)).add((i >= 2 ? convergents[i - 2] : BigInteger.ONE));
            convergents[i] = num1;
        }
        BigInteger result = convergents[99];
        long digitSum = 0;
        for (char c : result.toString().toCharArray()) {
            digitSum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(digitSum);
        return responseDto;
    }
}
