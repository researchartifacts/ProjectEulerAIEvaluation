package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ66 extends GPT54MiniOneByOneBase {

    public ResponseDto Question66() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger maxIdx = BigInteger.ZERO;
        int result = 0;
        for (int D = 2; D <= 1000; D++) {
            int r = (int) Math.sqrt(D);
            if (r * r == D) continue;
            BigInteger m = BigInteger.ZERO;
            BigInteger d = BigInteger.ONE;
            BigInteger a = BigInteger.valueOf(r);
            BigInteger num1 = BigInteger.ONE;
            BigInteger num = a;
            BigInteger den1 = BigInteger.ZERO;
            BigInteger den = BigInteger.ONE;
            while (!num.multiply(num).subtract(BigInteger.valueOf(D).multiply(den).multiply(den)).equals(BigInteger.ONE)) {
                m = d.multiply(a).subtract(m);
                d = BigInteger.valueOf(D).subtract(m.multiply(m)).divide(d);
                a = BigInteger.valueOf(r).add(m).divide(d);
                BigInteger nextNum = a.multiply(num).add(num1);
                num1 = num;
                num = nextNum;
                BigInteger nextDen = a.multiply(den).add(den1);
                den1 = den;
                den = nextDen;
            }
            if (num.compareTo(maxIdx) > 0) {
                maxIdx = num;
                result = D;
            }
        }
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
