package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ506 {

    public ResponseDto Question506() {
        ResponseDto responseDto = new ResponseDto();
        String pattern = "1234321"; long sum = 0; int position = 0; for (int n = 1; n <= 1000; n++) { int digitSum = 0; String current = ""; while (digitSum < n) { current += pattern.charAt(position % pattern.length()); digitSum = 0; for (char c : current.toCharArray()) { digitSum += Character.getNumericValue(c); } position++; } if (!current.isEmpty()) { sum += Long.parseLong(current); } } long result = sum % 123454321L;
        responseDto.setAnswer(result);
        return responseDto;
    }
}

