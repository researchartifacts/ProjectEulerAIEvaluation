package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ430 {

    public ResponseDto Question430() {
        ResponseDto responseDto = new ResponseDto();
        double expected = 0.0;
        int gridSize = 100;
        int flips = 100;

        for (int flip = 0; flip < flips; flip++) {
            int whiteCount = 0;
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if ((i + j) % 2 == 0) {
                        whiteCount++;
                    }
                }
            }
            expected += (double) whiteCount / (gridSize * gridSize);
        }

        expected /= flips;
        responseDto.setAnswer((long) Math.round(expected * 100));
        return responseDto;
    }
}
