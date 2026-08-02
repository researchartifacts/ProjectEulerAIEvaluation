package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ70 extends GPT54MiniOneByOneBase {

    public ResponseDto Question70() {
        ResponseDto responseDto = new ResponseDto();
        double minRatio = Double.MAX_VALUE;
        int result = 0;
        int limit = 10000000;
        List<Integer> primes = new ArrayList<>();
        boolean[] isP = new boolean[5000];
        Arrays.fill(isP, true);
        for (int i = 2; i < 5000; i++) {
            if (isP[i]) {
                primes.add(i);
                for (int j = i * i; j < 5000; j += i) isP[j] = false;
            }
        }
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                long n = (long) primes.get(i) * primes.get(j);
                if (n > limit) break;
                long phi = (long) (primes.get(i) - 1) * (primes.get(j) - 1);
                if (isPermutation((int) n, (int) phi)) {
                    double ratio = (double) n / phi;
                    if (ratio < minRatio) {
                        minRatio = ratio;
                        result = (int) n;
                    }
                }
            }
        }
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
