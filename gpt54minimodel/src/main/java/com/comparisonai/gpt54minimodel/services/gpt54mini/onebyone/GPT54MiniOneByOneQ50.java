package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ50 extends GPT54MiniOneByOneBase {

    public ResponseDto Question50() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < limit; i++) if (isPrime(i)) primes.add(i);
        int maxLen = 0;
        long maxPrime = 0;
        for (int i = 0; i < primes.size(); i++) {
            long sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum >= limit) break;
                if (j - i + 1 > maxLen && isPrime(sum)) {
                    maxLen = j - i + 1;
                    maxPrime = sum;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(maxPrime));
        return responseDto;
    }

}
