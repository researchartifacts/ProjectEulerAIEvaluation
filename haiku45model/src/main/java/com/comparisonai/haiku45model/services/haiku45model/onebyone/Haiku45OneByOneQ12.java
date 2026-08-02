package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ12 {

    public ResponseDto Question12() {
        ResponseDto responseDto = new ResponseDto();
        long triangleNum = 0;
        for (int n = 1; n <= 100000; n++) {
            triangleNum += n;
            if (countDivisors(triangleNum) > 500) {
                responseDto.setAnswer(triangleNum);
                return responseDto;
            }
        }
        return responseDto;
    }

    private int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += i * i == n ? 1 : 2;
            }
        }
        return count;
    }
}
