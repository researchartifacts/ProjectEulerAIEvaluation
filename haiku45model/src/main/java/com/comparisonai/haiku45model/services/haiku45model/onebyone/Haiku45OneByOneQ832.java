package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ832 {

    public ResponseDto Question832() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007L;
        long n = 1000000000000000L;
        long result = calculateM(n, MOD);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateM(long n, long MOD) {
        Set<Long> onPaper = new HashSet<>();
        long sum = 0;

        for (int round = 1; round <= Math.min(n, 1000000); round++) {
            long a = findSmallestNotOnPaper(onPaper);
            long b = findSmallestB(a, onPaper);
            long xorResult = a ^ b;

            onPaper.add(a);
            onPaper.add(b);
            onPaper.add(xorResult);

            sum = (sum + a + b + xorResult) % MOD;
        }

        return sum;
    }

    private long findSmallestNotOnPaper(Set<Long> onPaper) {
        long a = 1;
        while (onPaper.contains(a)) {
            a++;
        }
        return a;
    }

    private long findSmallestB(long a, Set<Long> onPaper) {
        long b = 1;
        while (true) {
            long xorResult = a ^ b;
            if (!onPaper.contains(b) && !onPaper.contains(xorResult)) {
                return b;
            }
            b++;
        }
    }
}
