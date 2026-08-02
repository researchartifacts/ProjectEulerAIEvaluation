package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ601 {

    public ResponseDto Question601() {
        ResponseDto responseDto = new ResponseDto();
        
        long totalSum = 0;
        for (int i = 1; i <= 31; i++) {
            totalSum += P(i, BigInteger.valueOf(4).pow(i));
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long P(int s, BigInteger N) {
        BigInteger Ls = lcm(s);
        BigInteger Ls1 = lcm(s + 1);
        
        BigInteger N_minus_2 = N.subtract(BigInteger.valueOf(2));
        if (N_minus_2.compareTo(BigInteger.ZERO) < 0) return 0;
        
        BigInteger countLs = N_minus_2.divide(Ls);
        BigInteger countLs1 = N_minus_2.divide(Ls1);
        
        return countLs.subtract(countLs1).longValue();
    }

    private BigInteger lcm(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i)).divide(res.gcd(BigInteger.valueOf(i)));
        }
        return res;
    }
}
