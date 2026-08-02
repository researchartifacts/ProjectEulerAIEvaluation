package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ87 extends GPT54MiniOneByOneBase {

    public ResponseDto Question87() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 50000000;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i < limit; i++) if (isPrime(i)) primes.add(i);
        Set<Integer> sums = new HashSet<>();
        for (int p1 : primes) {
            long s1 = (long) p1 * p1;
            if (s1 >= limit) break;
            for (int p2 : primes) {
                long s2 = s1 + (long) p2 * p2 * p2;
                if (s2 >= limit) break;
                for (int p3 : primes) {
                    long s3 = s2 + (long) p3 * p3 * p3 * p3;
                    if (s3 >= limit) break;
                    sums.add((int) s3);
                }
            }
        }
        responseDto.setAnswer(String.valueOf(sums.size()));
        return responseDto;
    }

}
