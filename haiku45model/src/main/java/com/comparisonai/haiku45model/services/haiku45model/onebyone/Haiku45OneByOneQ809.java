package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ809 {

    public ResponseDto Question809() {
        ResponseDto responseDto = new ResponseDto();

        long sum = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    if (gcd(gcd(a, b), c) == 1) {
                        long abc = (long) a * b * c;
                        if (abc <= 1000000) {
                            long expression = (long) a * a * a + (long) b * b * b + (long) c * c * c - 3L * a * b * c;
                            if (expression == 0) {
                                sum += abc;
                            }
                        }
                    }
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
}
