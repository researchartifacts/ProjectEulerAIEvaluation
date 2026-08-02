package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ837 {

    public ResponseDto Question837() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        int n = 100;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                long sum = (long) i + j;
                long diff = Math.abs((long) i - j);
                if (sum > 0 && diff > 0 && (sum * diff) % 2 == 0) {
                    result += sum * diff / 2;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
