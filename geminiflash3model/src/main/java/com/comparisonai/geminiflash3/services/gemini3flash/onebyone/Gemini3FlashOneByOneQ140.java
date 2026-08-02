package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ140 {

    public ResponseDto Question140() {
        ResponseDto responseDto = new ResponseDto();
        int target = 30;
        List<BigInteger> nuggets = new ArrayList<>();
        
        // X^2 - 5Y^2 = 44
        // Base solutions (X, Y)
        long[][] bases = {{7, 1}, {8, 2}, {13, 5}, {17, 7}, {32, 14}, {43, 19}};
        
        // Fundamental solution of x^2 - 5y^2 = 1 is (9, 4)
        BigInteger fundX = BigInteger.valueOf(9);
        BigInteger fundY = BigInteger.valueOf(4);
        
        for (long[] base : bases) {
            BigInteger curX = BigInteger.valueOf(base[0]);
            BigInteger curY = BigInteger.valueOf(base[1]);
            for (int i = 0; i < 20; i++) { // Generate enough
                if (curX.subtract(BigInteger.valueOf(7)).remainder(BigInteger.valueOf(5)).equals(BigInteger.ZERO)) {
                    BigInteger n = curX.subtract(BigInteger.valueOf(7)).divide(BigInteger.valueOf(5));
                    if (n.compareTo(BigInteger.ZERO) > 0) {
                        nuggets.add(n);
                    }
                }
                
                // (X + Y*sqrt(5)) * (9 + 4*sqrt(5))
                BigInteger nextX = curX.multiply(fundX).add(curY.multiply(fundY).multiply(BigInteger.valueOf(5)));
                BigInteger nextY = curX.multiply(fundY).add(curY.multiply(fundX));
                curX = nextX;
                curY = nextY;
            }
        }
        
        Collections.sort(nuggets);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < target; i++) {
            sum = sum.add(nuggets.get(i));
        }
        
        responseDto.setAnswer(sum.toString());
        return responseDto;
    }
}
