package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ316 {

    public ResponseDto Question316() {
        ResponseDto responseDto = new ResponseDto();
        
        BigInteger totalSum = BigInteger.ZERO;
        for (int n = 2; n <= 999999; n++) {
            totalSum = totalSum.add(g(BigInteger.valueOf(10).pow(16).divide(BigInteger.valueOf(n))));
        }
        
        responseDto.setAnswer(totalSum.toString());
        return responseDto;
    }

    private BigInteger g(BigInteger n) {
        String s = n.toString();
        int d = s.length();
        BigInteger res = BigInteger.ZERO;
        for (int k = 1; k <= d; k++) {
            if (s.substring(0, k).equals(s.substring(d - k))) {
                res = res.add(BigInteger.valueOf(10).pow(k));
            }
        }
        return res.subtract(BigInteger.valueOf(d - 1));
    }
}
