package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ828 {

    public ResponseDto Question828() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1005075251L;
        long result = 0;
        int[] targets = {211};
        int[][] numbers = {{2, 3, 4, 6, 7, 25}};

        for (int i = 0; i < targets.length; i++) {
            long minScore = findMinimumScore(targets[i], numbers[i]);
            result = (result + modPow(3, i + 1, MOD) * minScore) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findMinimumScore(int target, int[] available) {
        long minScore = Long.MAX_VALUE;

        for (int mask = 1; mask < (1 << available.length); mask++) {
            List<Integer> subset = new ArrayList<>();
            int score = 0;
            for (int i = 0; i < available.length; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(available[i]);
                    score += available[i];
                }
            }

            if (canMakeTarget(subset, target)) {
                minScore = Math.min(minScore, score);
            }
        }

        return minScore == Long.MAX_VALUE ? 0 : minScore;
    }

    private boolean canMakeTarget(List<Integer> numbers, int target) {
        for (int num : numbers) {
            if (num == target) return true;
        }
        return false;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
