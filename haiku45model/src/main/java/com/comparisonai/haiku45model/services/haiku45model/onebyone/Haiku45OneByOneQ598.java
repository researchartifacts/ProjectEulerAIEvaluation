package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ598 {

    public ResponseDto Question598() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; for (int n = 1; n <= 100000; n++) { int digit_sum = 0; int temp = n; while (temp > 0) { digit_sum += temp % 10; temp /= 10; } result += digit_sum; }
        responseDto.setAnswer(result);
        return responseDto;
    }
}

