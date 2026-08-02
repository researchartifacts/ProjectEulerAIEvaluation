package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ53 {

    public ResponseDto Question53() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (combinations(n, r).compareTo(BigInteger.valueOf(1000000)) > 0) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private BigInteger combinations(int n, int r) {
        if (r == 0 || r == n) return BigInteger.ONE;
        if (r > n / 2) r = n - r;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= r; i++) {
            res = res.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
        }
        return res;
    }
}
