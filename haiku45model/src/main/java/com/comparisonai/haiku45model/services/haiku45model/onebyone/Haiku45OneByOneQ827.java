package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ827 {

    public ResponseDto Question827() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 409120391L;
        long result = 0;

        for (int k = 1; k <= 18; k++) {
            long limit = (long) Math.pow(10, k);
            long q = findSmallestNumberInNTriples((int) limit);
            result = (result + q) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findSmallestNumberInNTriples(int n) {
        for (long num = 1; num <= Integer.MAX_VALUE; num++) {
            int count = countPythagoreanTriples(num);
            if (count == n) {
                return num;
            }
        }
        return -1;
    }

    private int countPythagoreanTriples(long num) {
        int count = 0;
        for (long a = 1; a * a < num * num; a++) {
            for (long b = a + 1; a * a + b * b < 1000000000; b++) {
                long c = (long) Math.sqrt(a * a + b * b);
                if (c * c == a * a + b * b && (a == num || b == num || c == num)) {
                    count++;
                }
            }
        }
        return count;
    }
}
