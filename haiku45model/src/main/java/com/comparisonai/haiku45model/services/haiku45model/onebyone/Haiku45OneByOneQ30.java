package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ30 {

    public ResponseDto Question30() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (long i = 10; i < 1000000; i++) {
            long temp = i;
            long digitSum = 0;
            while (temp > 0) {
                long digit = temp % 10;
                digitSum += digit * digit * digit * digit * digit;
                temp /= 10;
            }
            if (digitSum == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
