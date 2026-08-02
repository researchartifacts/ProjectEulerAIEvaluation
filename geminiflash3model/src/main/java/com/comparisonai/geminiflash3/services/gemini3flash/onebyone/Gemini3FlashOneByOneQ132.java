package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ132 {

    public ResponseDto Question132() {
        ResponseDto responseDto = new ResponseDto();
        int target = 40;
        int count = 0;
        long sum = 0;
        int p = 2;
        int k = 1000000000;
        while (count < target) {
            if (p > 3 && isPrime(p)) {
                if (BigInteger.valueOf(10).modPow(BigInteger.valueOf(k), BigInteger.valueOf(p)).equals(BigInteger.ONE)) {
                    sum += p;
                    count++;
                }
            }
            p++;
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
