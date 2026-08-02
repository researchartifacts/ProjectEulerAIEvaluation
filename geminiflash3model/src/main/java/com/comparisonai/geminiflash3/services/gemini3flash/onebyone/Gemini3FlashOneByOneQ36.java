package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ36 {

    public ResponseDto Question36() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
