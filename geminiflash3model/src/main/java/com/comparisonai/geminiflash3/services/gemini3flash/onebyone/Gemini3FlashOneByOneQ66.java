package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ66 {

    public ResponseDto Question66() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger max_x = BigInteger.ZERO;
        int resultD = 0;
        for (int D = 2; D <= 1000; D++) {
            int r = (int) Math.sqrt(D);
            if (r * r == D) continue;
            BigInteger m = BigInteger.ZERO, d = BigInteger.ONE, a = BigInteger.valueOf(r);
            BigInteger num1 = BigInteger.ONE, num = a;
            BigInteger den1 = BigInteger.ZERO, den = BigInteger.ONE;
            while (!num.multiply(num).subtract(BigInteger.valueOf(D).multiply(den).multiply(den)).equals(BigInteger.ONE)) {
                m = d.multiply(a).subtract(m);
                d = BigInteger.valueOf(D).subtract(m.multiply(m)).divide(d);
                a = BigInteger.valueOf(r).add(m).divide(d);
                BigInteger nextNum = a.multiply(num).add(num1);
                num1 = num; num = nextNum;
                BigInteger nextDen = a.multiply(den).add(den1);
                den1 = den; den = nextDen;
            }
            if (num.compareTo(max_x) > 0) {
                max_x = num;
                resultD = D;
            }
        }
        responseDto.setAnswer(resultD);
        return responseDto;
    }
}
