package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ4 {

    public ResponseDto Question4() {
        ResponseDto responseDto = new ResponseDto();
        long maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                long product = (long) i * j;
                String productStr = String.valueOf(product);
                String reversed = new StringBuilder(productStr).reverse().toString();
                if (productStr.equals(reversed) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        responseDto.setAnswer(maxPalindrome);
        return responseDto;
    }
}
