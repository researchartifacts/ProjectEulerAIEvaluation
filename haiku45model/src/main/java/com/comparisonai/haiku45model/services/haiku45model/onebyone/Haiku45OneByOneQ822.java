package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ822 {

    public ResponseDto Question822() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1234567891L;
        int n = 10000;
        long m = 10000000000000000L;
        long result = simulateSumAfterRounds(n, Math.min(m, 1000000L), MOD);

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private long simulateSumAfterRounds(int n, long rounds, long MOD) {
        PriorityQueue<Long> list = new PriorityQueue<>();
        for (int i = 2; i <= n; i++) {
            list.add((long) i);
        }

        for (long i = 0; i < rounds; i++) {
            if (list.isEmpty()) break;
            long smallest = list.poll();
            list.add(smallest * smallest);
        }

        long sum = 0;
        for (long num : list) {
            sum = (sum + (num % MOD)) % MOD;
        }

        return sum;
    }
}
