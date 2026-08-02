package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ77 extends GPT54MiniOneByOneBase {

    public ResponseDto Question77() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 1000; i++) if (isPrime(i)) primes.add(i);
        for (int target = 2; ; target++) {
            int[] ways = new int[target + 1];
            ways[0] = 1;
            for (int p : primes) {
                for (int i = p; i <= target; i++) ways[i] += ways[i - p];
            }
            if (ways[target] > 5000) {
                responseDto.setAnswer(String.valueOf(target));
                return responseDto;
            }
        }
    }

}
