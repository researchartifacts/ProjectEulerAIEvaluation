package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ655 {

    public ResponseDto Question655() {
        ResponseDto responseDto = new ResponseDto();

        long M = 10000019;
        long limit = 32; // 10^32
        
        long totalCount = 0;
        // Palindromes of length L from 1 to 32
        for (int L = 1; L <= 32; L++) {
            totalCount += countPalindromes(L, M);
        }

        responseDto.setAnswer(totalCount);
        return responseDto;
    }

    private long countPalindromes(int L, long M) {
        int half = (L + 1) / 2;
        long[] coeffs = new long[half];
        for (int i = 0; i < half; i++) {
            int mirror = L - 1 - i;
            if (i == mirror) {
                coeffs[i] = power(10, i, M);
            } else {
                coeffs[i] = (power(10, i, M) + power(10, mirror, M)) % M;
            }
        }

        // Meet-in-the-middle for 'half' digits
        int h1 = half / 2;
        int h2 = half - h1;

        Map<Long, Long> map1 = new HashMap<>();
        generate(0, h1, 0, coeffs, M, map1, true);

        long count = 0;
        Map<Long, Long> map2 = new HashMap<>();
        generate(h1, half, 0, coeffs, M, map2, false);

        for (Map.Entry<Long, Long> entry : map2.entrySet()) {
            long remNeeded = (M - entry.getKey()) % M;
            if (map1.containsKey(remNeeded)) {
                count += entry.getValue() * map1.get(remNeeded);
            }
        }

        return count;
    }

    private void generate(int idx, int end, long currentRem, long[] coeffs, long M, Map<Long, Long> map, boolean isFirst) {
        if (idx == end) {
            map.put(currentRem, map.getOrDefault(currentRem, 0L) + 1);
            return;
        }
        int startDigit = (isFirst && idx == 0) ? 1 : 0;
        for (int d = startDigit; d <= 9; d++) {
            generate(idx + 1, end, (currentRem + d * coeffs[idx]) % M, coeffs, M, map, isFirst);
        }
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
