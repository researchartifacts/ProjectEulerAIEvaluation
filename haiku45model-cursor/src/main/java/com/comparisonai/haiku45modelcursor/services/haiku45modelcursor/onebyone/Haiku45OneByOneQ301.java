package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 301
 */
@Service
public class Haiku45OneByOneQ301 {

    public ResponseDto Question301() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // Nim game - XOR property of winning positions
        long count = 0;
        for (long n = 1; n <= (1L << 30); n++) {
            long x = n ^ (2 * n) ^ (3 * n);
            if (x == 0) count++;
        }
        long result = count;

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
