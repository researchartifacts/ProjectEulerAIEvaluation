package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ436 {

    public ResponseDto Question436() {
        ResponseDto responseDto = new ResponseDto();
        double player2Wins = 0;
        int trials = 100000;

        for (int i = 0; i < trials; i++) {
            double threshold1 = Math.random() * 10;
            double threshold2 = Math.random() * 10;
            double sum = Math.random() * 20;

            if (sum > threshold2 && sum <= threshold1) {
                player2Wins++;
            }
        }

        double probability = player2Wins / trials;
        responseDto.setAnswer((long) (probability * 10000000000L));
        return responseDto;
    }
}
