package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.*;
import java.util.stream.*;

/**
 * Problem 355
 */
@Service
public class Haiku45OneByOneQ355 {

    public ResponseDto Question355() {
        ResponseDto responseDto = new ResponseDto();
        long startTime = System.currentTimeMillis();

        long result = 0;
        long limit = 1000000;
        for (long i = 1; i <= limit; i++) {
            result += i;
        }

        responseDto.setAnswer(result);
        responseDto.setTime(System.currentTimeMillis() - startTime);
        return responseDto;
    }
}
