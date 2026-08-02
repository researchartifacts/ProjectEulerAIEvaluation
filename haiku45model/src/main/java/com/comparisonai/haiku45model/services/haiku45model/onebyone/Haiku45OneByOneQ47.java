package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ47 {

    public ResponseDto Question47() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; i < 1000000; i++) {
            if (countDistinctPrimeFactors(i) == 4 &&
                countDistinctPrimeFactors(i + 1) == 4 &&
                countDistinctPrimeFactors(i + 2) == 4 &&
                countDistinctPrimeFactors(i + 3) == 4) {
                responseDto.setAnswer(i);
                return responseDto;
            }
        }
        return responseDto;
    }

    private int countDistinctPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors.size();
    }
}
