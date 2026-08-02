package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 306
 */
@Service
public class Haiku45OneByOneQ306 {

    public ResponseDto Question306() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // Nim-like combinatorial game
        int n = 100;
        boolean[] winning = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (!winning[i - j]) {
                    winning[i] = true;
                    break;
                }
            }
        }
        long result = 0;
        for (int i = 0; i <= n; i++) {
            if (winning[i]) result++;
        }

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
