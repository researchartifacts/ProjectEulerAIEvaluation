package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ110 {

    public ResponseDto Question110() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Diophantine reciprocals greater threshold
        long minN = Long.MAX_VALUE;
        for (int n = 1; n <= 1000; n++) {
            long solutions = 0;
            for (int x = n; x <= n * 100; x++) {
                if ((n * x) % (x - n) == 0) solutions++;
            }
            if (solutions > 800) {
                minN = n;
                break;
            }
        }
        result = minN;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

