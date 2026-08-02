package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ36 {

    public ResponseDto Question36() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            String decimal = String.valueOf(i);
            String binary = Integer.toBinaryString(i);
            if (isPalindrome(decimal) && isPalindrome(binary)) {
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
