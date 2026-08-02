package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 304
 */
@Service
public class Haiku45OneByOneQ304 {

    public ResponseDto Question304() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // House of cards calculation
        java.util.Map<String, Long> memo = new java.util.HashMap<>();
        java.util.function.Function<String, Long> calc = n -> {
            long cards = 0;
            int levels = Integer.parseInt(n);
            for (int i = 1; i <= levels; i++) {
                cards += (3 * i * i - i) / 2;
            }
            return cards;
        };
        long result = 0;
        for (int i = 1; i <= 100; i++) {
            long cards = (long)i * (i + 1) * (2 * i + 1) / 6;
            result += cards;
        }

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
