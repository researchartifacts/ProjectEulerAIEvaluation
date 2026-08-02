package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ55 {

    public ResponseDto Question55() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (!isLychrel(i)) {
                count++;
            }
        }
        responseDto.setAnswer(10000 - count);
        return responseDto;
    }

    private boolean isLychrel(int n) {
        long current = n;
        for (int i = 0; i < 50; i++) {
            long reversed = Long.parseLong(new StringBuilder(String.valueOf(current)).reverse().toString());
            current = current + reversed;
            if (isPalindrome(String.valueOf(current))) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
