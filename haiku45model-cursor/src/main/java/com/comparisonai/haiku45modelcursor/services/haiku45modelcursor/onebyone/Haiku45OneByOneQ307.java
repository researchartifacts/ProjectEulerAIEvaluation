package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 307
 */
@Service
public class Haiku45OneByOneQ307 {

    public ResponseDto Question307() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // Defects in circuits - probability calculation
        java.util.Random rand = new java.util.Random(123);
        int n = 10;
        int k = 5;
        double prob = 0;
        for (int trial = 0; trial < 100000; trial++) {
            int failures = 0;
            for (int i = 0; i < k; i++) {
                if (rand.nextDouble() < 0.5) failures++;
            }
            if (failures > n / 2) prob += 1.0 / 100000;
        }
        long result = (long)(prob * 1000);

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
