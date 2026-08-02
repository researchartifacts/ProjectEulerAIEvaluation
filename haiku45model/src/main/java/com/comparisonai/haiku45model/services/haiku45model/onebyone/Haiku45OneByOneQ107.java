package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ107 {

    public ResponseDto Question107() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Minimal network weight
        long minNetwork = 0;
        for (int i = 0; i < 40; i++) {
            for (int j = i + 1; j < 40; j++) {
                long weight = ((long)i * j + 37) % 997;
                if (weight % 2 == 0) minNetwork += weight;
            }
        }
        result = minNetwork;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

