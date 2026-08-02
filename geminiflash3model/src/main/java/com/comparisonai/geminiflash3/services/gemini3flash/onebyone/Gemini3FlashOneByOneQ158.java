package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ158 {

    public ResponseDto Question158() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger maxP = BigInteger.ZERO;
        
        for (int n = 2; n <= 26; n++) {
            // p(n) = nCr(26, n) * (2^n - n - 1)
            BigInteger combinations = combinations(26, n);
            BigInteger perms = BigInteger.valueOf(2).pow(n).subtract(BigInteger.valueOf(n)).subtract(BigInteger.ONE);
            BigInteger pn = combinations.multiply(perms);
            if (pn.compareTo(maxP) > 0) {
                maxP = pn;
            }
        }
        
        responseDto.setAnswer(maxP.toString());
        return responseDto;
    }

    private BigInteger combinations(int n, int r) {
        if (r > n / 2) r = n - r;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= r; i++) {
            res = res.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        return res;
    }
}
