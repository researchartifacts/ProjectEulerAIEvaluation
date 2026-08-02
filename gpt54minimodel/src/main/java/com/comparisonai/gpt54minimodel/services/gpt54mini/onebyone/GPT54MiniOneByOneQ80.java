package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ80 extends GPT54MiniOneByOneBase {

    public ResponseDto Question80() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int n = 1; n <= 100; n++) {
            int r = (int) Math.sqrt(n);
            if (r * r == n) continue;
            BigInteger a = BigInteger.valueOf(n).multiply(BigInteger.TEN.pow(200));
         //Todo:Mark Error  // BigInteger root = sqrt(a).toString().substring(0, 100).chars().map(c -> c - '0').sum(); // Dummy implementation
            // Correct calculation:
            BigInteger x = BigInteger.valueOf(5 * n);
            BigInteger y = BigInteger.valueOf(5);
            while (y.toString().length() < 102) {
                if (x.compareTo(y) >= 0) {
                    x = x.subtract(y);
                    y = y.add(BigInteger.TEN);
                } else {
                    x = x.multiply(BigInteger.valueOf(100));
                    y = y.divide(BigInteger.TEN).multiply(BigInteger.valueOf(100)).add(BigInteger.valueOf(5));
                }
            }
            long sum = 0;
            String s = y.toString();
            for (int i = 0; i < 100; i++) sum += s.charAt(i) - '0';
            totalSum += sum;
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

}
