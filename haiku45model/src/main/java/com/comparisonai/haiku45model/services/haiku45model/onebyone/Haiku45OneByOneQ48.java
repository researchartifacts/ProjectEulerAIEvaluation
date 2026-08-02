package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ48 {

    public ResponseDto Question48() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger base = BigInteger.valueOf(i);
            BigInteger power = base.pow(i);
            sum = sum.add(power);
        }
        String sumStr = sum.toString();
        String lastTenDigits = sumStr.substring(sumStr.length() - 10);
        responseDto.setAnswer(Long.parseLong(lastTenDigits));
        return responseDto;
    }
}
