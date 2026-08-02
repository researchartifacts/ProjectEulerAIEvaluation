package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ63 {

    public ResponseDto Question63() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int digits = 1; digits <= 100; digits++) {
            for (int base = 1; base <= 9; base++) {
                BigInteger power = BigInteger.valueOf(base).pow(digits);
                if (power.toString().length() == digits) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
