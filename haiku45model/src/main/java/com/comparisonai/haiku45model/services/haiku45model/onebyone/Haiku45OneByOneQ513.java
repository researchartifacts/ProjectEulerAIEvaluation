package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ513 {

    public ResponseDto Question513() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0; for (int n = 1; n <= 100000; n++) { boolean[] seen = new boolean[10]; for (char c : String.valueOf(n).toCharArray()) { int digit = Character.getNumericValue(c); if (!seen[digit]) { seen[digit] = true; sum += digit; } } } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

