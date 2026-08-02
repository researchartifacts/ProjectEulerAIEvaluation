package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ113 {

    public ResponseDto Question113() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100;
        // Non-bouncy = Increasing + Decreasing - AllSame (e.g. 11, 222)
        // Increasing: C(n+9, 9) - 1
        // Decreasing: C(n+10, 10) - (n + 1)
        // Total = C(n+9, 9) + C(n+10, 10) - 2 - 9n
        
        BigInteger inc = combinations(n + 9, 9).subtract(BigInteger.ONE);
        BigInteger dec = combinations(n + 10, 10).subtract(BigInteger.valueOf(n + 1));
        BigInteger allSame = BigInteger.valueOf(9 * n);
        
        BigInteger total = inc.add(dec).subtract(allSame);
        responseDto.setAnswer(total.toString());
        return responseDto;
    }

    private BigInteger combinations(int n, int k) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        return res;
    }
}
