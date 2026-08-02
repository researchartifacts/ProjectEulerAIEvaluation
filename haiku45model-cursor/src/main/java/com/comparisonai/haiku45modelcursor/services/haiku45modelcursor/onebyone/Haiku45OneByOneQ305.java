package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 305
 */
@Service
public class Haiku45OneByOneQ305 {

    public ResponseDto Question305() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        // String concatenation index
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (sb.length() < 1000000) {
            sb.append(count);
            count++;
        }
        long result = Character.getNumericValue(sb.charAt(999999));

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
