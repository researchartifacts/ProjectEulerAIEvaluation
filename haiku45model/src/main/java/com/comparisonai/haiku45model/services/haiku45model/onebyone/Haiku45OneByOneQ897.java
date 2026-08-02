package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ897 {

    public ResponseDto Question897() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            if (isHarshad(i)) {
                result += i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isHarshad(int n) {
        int digitSum = 0;
        int temp = n;
        while (temp > 0) {
            digitSum += temp % 10;
            temp /= 10;
        }
        return n % digitSum == 0;
    }
}
