package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ64 {

    public ResponseDto Question64() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i <= 10000; i++) {
            if (getSquareRootPeriod(i) % 2 == 1) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int getSquareRootPeriod(int n) {
        if (isSquare(n)) return 0;
        int m = 0, d = 1, a = (int) Math.sqrt(n);
        int a0 = a;
        int periodLength = 0;
        while (a != 2 * a0) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            periodLength++;
        }
        return periodLength;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
