package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ74 {

    public ResponseDto Question74() {
        ResponseDto responseDto = new ResponseDto();
        long[] factorials = new long[10];
        factorials[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            Set<Long> seen = new HashSet<>();
            long n = i;
            while (!seen.contains(n)) {
                seen.add(n);
                long sum = 0;
                while (n > 0) {
                    sum += factorials[(int) (n % 10)];
                    n /= 10;
                }
                n = sum;
            }
            if (seen.size() == 60) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
