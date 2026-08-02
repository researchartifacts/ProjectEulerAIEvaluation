package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ821 {

    public ResponseDto Question821() {
        ResponseDto responseDto = new ResponseDto();

        long n = 10000000000000000L;
        long result = calculate123Separable(n);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculate123Separable(long n) {
        Set<Long> used = new HashSet<>();
        long count = 0;

        for (long i = 1; i * 3 <= n; i++) {
            if (!used.contains(i) && !used.contains(2 * i) && !used.contains(3 * i)) {
                used.add(i);
                used.add(2 * i);
                used.add(3 * i);
                count += 3;
            }
        }

        return Math.min(count, n);
    }
}
