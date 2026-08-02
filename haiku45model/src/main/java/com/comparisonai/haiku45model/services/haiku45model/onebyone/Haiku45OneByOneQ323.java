package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ323 {

    public ResponseDto Question323() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        long sum = 0;
        for (int i = 1; i <= 1000000; i++) {
            int val = i;
            int steps = 0;
            int target = (1 << 30) - 1;
            while (val != target) {
                val |= (val >> 1);
                steps++;
            }
            sum += steps;
        }
        result = sum / 1000000;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
