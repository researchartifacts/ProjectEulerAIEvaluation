package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ514 {

    public ResponseDto Question514() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0; int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9}; for (int mask = 1; mask < 512; mask++) { int weight_sum = 0; int num = 0; for (int i = 0; i < 9; i++) { if ((mask & (1 << i)) != 0) { weight_sum += weights[i]; num = num * 10 + (i + 1); } } if (weight_sum == num) { result += num; } } result = 0;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

