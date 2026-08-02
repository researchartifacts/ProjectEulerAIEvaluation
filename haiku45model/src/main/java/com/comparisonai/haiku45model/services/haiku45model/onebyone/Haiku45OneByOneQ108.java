package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ108 {

    public ResponseDto Question108() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Diophantine reciprocals
        long countSolutions = 0;
        for (int n = 1; n <= 500; n++) {
            for (int x = n + 1; x <= n * n + 1000; x++) {
                if ((n * x) % (x - n) == 0) {
                    countSolutions++;
                }
            }
        }
        result = countSolutions;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

