package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ804 {

    public ResponseDto Question804() {
        ResponseDto responseDto = new ResponseDto();

        long limit = 1000000000000000L;
        long result = 0;

        for (long n = 1; n <= 10000; n++) {
            int count = 0;
            for (long x = -n * n; x <= n * n; x++) {
                for (long y = -n * n; y <= n * n; y++) {
                    long value = x * x + x * y + 41 * y * y;
                    if (value == n) {
                        count++;
                    }
                }
            }
            result += count;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
