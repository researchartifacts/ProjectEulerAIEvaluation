package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ380 {

    public ResponseDto Question380() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Count primitive sets where all elements are coprime
        int limit = 100;
        for (int n = 2; n <= limit; n++) {
            int count = 0;
            for (int k = 1; k < n; k++) {
                if (gcd(n, k) == 1) count++;
            }
            if (count % 2 == 1) result++;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
