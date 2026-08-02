package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 303
 */
@Service
public class Haiku45OneByOneQ303 {

    public ResponseDto Question303() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        long sum = 0;
        // Find least multiple using only digits 0,1,2
        java.util.Queue<java.util.AbstractMap.SimpleEntry<Long, Integer>> q = new java.util.LinkedList<>();
        for (int i = 1; i <= 10000; i++) {
            q.add(new java.util.AbstractMap.SimpleEntry<>(1L, i));

            while (!q.isEmpty()) {
                java.util.AbstractMap.SimpleEntry<Long, Integer> entry = q.poll();
                long num = entry.getKey();
                int mod = entry.getValue();
                if (num % mod == 0) { sum += num / mod; break; }
                q.add(new java.util.AbstractMap.SimpleEntry<>((num * 10) % (long)mod, mod));
            }
        }
        long result = sum;

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
