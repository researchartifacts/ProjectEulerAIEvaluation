package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ66 {

    public ResponseDto Question66() {
        ResponseDto responseDto = new ResponseDto();
        long maxX = 0;
        int maxD = 0;
        for (int d = 2; d <= 1000; d++) {
            if (isSquare(d)) continue;
            long x = findPellSolution(d);
            if (x > maxX) {
                maxX = x;
                maxD = d;
            }
        }
        responseDto.setAnswer(maxD);
        return responseDto;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private long findPellSolution(int d) {
        long m = 0, d_var = 1, a = (long) Math.sqrt(d);
        long a0 = a;
        long num_prev = 1, num_curr = a0;
        long den_prev = 0, den_curr = 1;
        while (true) {
            m = d_var * a - m;
            d_var = (d - m * m) / d_var;
            a = (a0 + m) / d_var;
            long num_next = a * num_curr + num_prev;
            long den_next = a * den_curr + den_prev;
            if (num_next * num_next - d * den_next * den_next == 1) {
                return num_next;
            }
            num_prev = num_curr;
            num_curr = num_next;
            den_prev = den_curr;
            den_curr = den_next;
        }
    }
}
