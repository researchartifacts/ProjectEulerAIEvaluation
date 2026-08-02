package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ25 {

    public ResponseDto Question25() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int count = 2;
        while (b.toString().length() < 1000) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
            count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
