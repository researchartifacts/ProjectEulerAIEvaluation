package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ486 {

    public ResponseDto Question486() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long n = 1; n <= 1000; n++) {
            String binary = Long.toBinaryString(n);
            boolean isPalindrome = binary.equals(new StringBuilder(binary).reverse().toString());

            if (isPalindrome) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
