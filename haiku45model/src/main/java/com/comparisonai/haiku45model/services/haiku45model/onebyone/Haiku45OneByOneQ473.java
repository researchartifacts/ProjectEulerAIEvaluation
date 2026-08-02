package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ473 {

    public ResponseDto Question473() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long n = 1; n <= 1000000; n++) {
            if (isPhigitalPalindrome(n)) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPhigitalPalindrome(long n) {
        String s = String.valueOf(n);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
