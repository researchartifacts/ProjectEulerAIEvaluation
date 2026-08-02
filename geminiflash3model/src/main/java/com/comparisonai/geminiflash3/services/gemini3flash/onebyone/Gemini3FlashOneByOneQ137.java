package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ137 {

    public ResponseDto Question137() {
        ResponseDto responseDto = new ResponseDto();
        int target = 15;
        // n = F(2k) * F(2k+1)
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        for (int k = 1; k < target; k++) {
            // Next two Fibonacci numbers
            BigInteger f3 = f1.add(f2);
            BigInteger f4 = f2.add(f3);
            f1 = f3;
            f2 = f4;
        }
        // We need 15th, so we need k=15.
        // Let's just generate F until we have 30th.
        BigInteger[] f = new BigInteger[32];
        f[1] = BigInteger.ONE;
        f[2] = BigInteger.ONE;
        for (int i = 3; i <= 31; i++) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        
        BigInteger res = f[2 * target].multiply(f[2 * target + 1]);
        responseDto.setAnswer(res.toString());
        return responseDto;
    }
}
