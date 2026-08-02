package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ34 {

    public ResponseDto Question34() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long[] factorials = new long[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        for (int i = 145; i < 1000000; i++) {
            long temp = i;
            long digitFactorialSum = 0;
            while (temp > 0) {
                digitFactorialSum += factorials[(int) (temp % 10)];
                temp /= 10;
            }
            if (digitFactorialSum == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
