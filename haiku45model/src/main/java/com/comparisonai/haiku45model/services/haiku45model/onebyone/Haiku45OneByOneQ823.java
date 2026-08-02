package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ823 {

    public ResponseDto Question823() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1234567891L;
        int n = 10000;
        long m = 10000000000000000L;
        long result = simulateSumAfterRounds(n, Math.min(m, 100000L), MOD);

        responseDto.setAnswer(result % MOD);
        return responseDto;
    }

    private long simulateSumAfterRounds(int n, long rounds, long MOD) {
        List<Long> list = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            list.add((long) i);
        }

        for (long i = 0; i < rounds; i++) {
            if (list.isEmpty()) break;
            long product = 1;
            for (int j = 0; j < list.size(); j++) {
                long spf = smallestPrimeFactor(list.get(j));
                list.set(j, list.get(j) / spf);
                product *= spf;
            }
            list.add(product);
            list.removeIf(x -> x == 1);
        }

        long sum = 0;
        for (long num : list) {
            sum = (sum + (num % MOD)) % MOD;
        }

        return sum;
    }

    private long smallestPrimeFactor(long n) {
        if (n % 2 == 0) return 2;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return i;
        }
        return n;
    }
}
