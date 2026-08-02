package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ836 {

    public ResponseDto Question836() {
        ResponseDto responseDto = new ResponseDto();

        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (gcd(i, j) == 1) {
                    sum += lcm(i, j);
                }
            }
        }

        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }
}
