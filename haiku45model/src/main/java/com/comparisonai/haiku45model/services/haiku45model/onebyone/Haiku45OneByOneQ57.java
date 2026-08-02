package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ57 {

    public ResponseDto Question57() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        BigInteger numerator = BigInteger.valueOf(3);
        BigInteger denominator = BigInteger.valueOf(2);
        for (int i = 1; i < 1000; i++) {
            if (numerator.toString().length() > denominator.toString().length()) {
                count++;
            }
            BigInteger nextNumerator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
            BigInteger nextDenominator = numerator.add(denominator);
            numerator = nextNumerator;
            denominator = nextDenominator;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
