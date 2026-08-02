package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ518 {

    public ResponseDto Question518() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0; for (int n = 1; n <= 1000000; n++) { String s = String.valueOf(n); boolean is_pandigital = true; for (int i = 0; i < s.length(); i++) { if (s.charAt(i) == "0".charAt(0)) { is_pandigital = false; } } if (is_pandigital) sum += n; } long result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

