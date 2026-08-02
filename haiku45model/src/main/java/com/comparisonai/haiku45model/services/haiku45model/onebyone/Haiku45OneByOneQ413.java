package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ413 {

    public ResponseDto Question413() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int digits = 1; digits <= 19; digits++) {
            long start = (long) Math.pow(10, digits - 1);
            long end = Math.min((long) Math.pow(10, digits), start + 10000);

            for (long n = start; n < end; n++) {
                String numStr = String.valueOf(n);
                int divisibleCount = 0;

                for (int len = 1; len <= numStr.length(); len++) {
                    for (int i = 0; i <= numStr.length() - len; i++) {
                        String substring = numStr.substring(i, i + len);
                        if (!substring.startsWith("0") && Long.parseLong(substring) % len == 0) {
                            divisibleCount++;
                        }
                    }
                }

                if (divisibleCount == 1) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
