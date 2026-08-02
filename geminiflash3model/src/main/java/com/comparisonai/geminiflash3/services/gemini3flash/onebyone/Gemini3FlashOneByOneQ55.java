package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ55 {

    public ResponseDto Question55() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i)) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isLychrel(int n) {
        BigInteger bi = BigInteger.valueOf(n);
        for (int i = 0; i < 50; i++) {
            bi = bi.add(new BigInteger(new StringBuilder(bi.toString()).reverse().toString()));
            if (isPalindrome(bi.toString())) return false;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
