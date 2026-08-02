package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ21 {

    public ResponseDto Question21() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 10000; i++) {
            long d = sumOfDivisors(i);
            if (d < 10000 && d != i && sumOfDivisors((int) d) == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i && i != 1) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
