package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ892 {

    public ResponseDto Question892() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (isPythagorean(i, j)) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPythagorean(int a, int b) {
        long sum = (long) a * a + (long) b * b;
        long sqrt = (long) Math.sqrt(sum);
        return sqrt * sqrt == sum;
    }
}
