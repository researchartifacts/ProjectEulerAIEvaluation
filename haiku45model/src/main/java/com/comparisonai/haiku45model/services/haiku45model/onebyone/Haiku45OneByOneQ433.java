package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ433 {

    public ResponseDto Question433() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000;

        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                int steps = countGcdSteps(x, y);
                result += steps;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int countGcdSteps(int a, int b) {
        int steps = 0;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            steps++;
        }
        return steps;
    }
}
