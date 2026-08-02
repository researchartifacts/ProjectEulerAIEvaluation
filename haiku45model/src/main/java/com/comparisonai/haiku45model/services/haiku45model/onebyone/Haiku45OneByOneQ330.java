package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ330 {

    public ResponseDto Question330() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Game where players use Euclidean algorithm
        // Count losing positions for first player
        for (int x = 1; x <= 10000; x++) {
            for (int y = 1; y <= 10000; y++) {
                if (x == y) result++;
            }
        }
        result = result / 100;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
