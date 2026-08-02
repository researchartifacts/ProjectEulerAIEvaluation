package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ491 {

    public ResponseDto Question491() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long n = 1; n <= 10000000; n++) {
            String s = String.valueOf(n);
            if (s.length() == 10) {
                boolean[] digits = new boolean[10];
                boolean valid = true;

                for (char c : s.toCharArray()) {
                    int d = c - '0';
                    if (digits[d]) {
                        valid = false;
                        break;
                    }
                    digits[d] = true;
                }

                if (valid && n % 11 == 0) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
