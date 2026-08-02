package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ230 {

    public ResponseDto Question230() {
        ResponseDto responseDto = new ResponseDto();
        
        String A = "1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
        String B = "8214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196";
        
        long totalSum = 0;
        for (int n = 0; n <= 17; n++) {
            BigInteger target = BigInteger.valueOf(127).add(BigInteger.valueOf(19).multiply(BigInteger.valueOf(n)))
                    .multiply(BigInteger.valueOf(7).pow(n));
            totalSum += BigInteger.valueOf(10).pow(n).longValue() * getDigit(A, B, target);
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int getDigit(String A, String B, BigInteger n) {
        BigInteger[] lens = new BigInteger[100];
        lens[0] = BigInteger.valueOf(A.length());
        lens[1] = BigInteger.valueOf(B.length());
        int k = 2;
        while (true) {
            lens[k] = lens[k - 1].add(lens[k - 2]);
            if (lens[k].compareTo(n) >= 0) break;
            k++;
        }
        
        while (k >= 2) {
            if (n.compareTo(lens[k - 2]) <= 0) {
                k -= 2;
            } else {
                n = n.subtract(lens[k - 2]);
                k -= 1;
            }
        }
        
        if (k == 0) return A.charAt(n.intValue() - 1) - '0';
        else return B.charAt(n.intValue() - 1) - '0';
    }
}
