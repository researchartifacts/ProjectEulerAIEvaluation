package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ577 {

    public ResponseDto Question577() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 12345;
        BigInteger totalSum = BigInteger.ZERO;
        
        for (int n = 3; n <= limit; n++) {
            totalSum = totalSum.add(calculateH(n));
        }
        
        responseDto.setAnswer(totalSum.toString());
        return responseDto;
    }

    private BigInteger calculateH(int n) {
        BigInteger sum = BigInteger.ZERO;
        for (int k = 1; 3 * k <= n; k++) {
            long ways = (long) (n - 3 * k + 1) * (n - 3 * k + 2) / 2;
            sum = sum.add(BigInteger.valueOf(k).multiply(BigInteger.valueOf(ways)));
        }
        return sum;
    }
}
