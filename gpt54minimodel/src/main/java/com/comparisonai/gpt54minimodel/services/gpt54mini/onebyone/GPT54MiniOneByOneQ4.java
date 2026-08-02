package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ4 extends GPT54MiniOneByOneBase {

    public ResponseDto Question4() {
        ResponseDto responseDto = new ResponseDto();
        int maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) {
                int product = i * j;
                if (product <= maxPalindrome) break;
                String s = String.valueOf(product);
                if (s.equals(new StringBuilder(s).reverse().toString())) {
                    maxPalindrome = product;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(maxPalindrome));
        return responseDto;
    }

}
