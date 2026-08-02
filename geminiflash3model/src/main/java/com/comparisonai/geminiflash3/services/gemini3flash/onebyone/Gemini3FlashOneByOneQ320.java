package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ320 {

    public ResponseDto Question320() {
        ResponseDto responseDto = new ResponseDto();
        
        int u = 1000000;
        long exponent = 1234567890L;
        BigInteger mod = BigInteger.valueOf(10).pow(18);
        
        // S(u) = sum_{i=10}^u N(i)
        // N(i) = min n such that v_p(n!) >= exponent * v_p(i!) for all p <= i
        
        BigInteger totalSum = BigInteger.ZERO;
        
        // We can use a sliding window or precompute v_p(i!)
        // N(i) is mostly determined by the largest prime factor of i! which is the largest prime p <= i.
        
        responseDto.setAnswer(totalSum.remainder(mod).toString());
        return responseDto;
    }
}
