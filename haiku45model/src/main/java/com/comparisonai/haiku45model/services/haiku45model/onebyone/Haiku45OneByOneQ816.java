package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ816 {

    public ResponseDto Question816() {
        ResponseDto responseDto = new ResponseDto();

        long s = 290797;
        long MOD = 50515093;
        double minDistance = Double.MAX_VALUE;

        for (int k = 0; k < 2000000; k++) {
            s = (s * s) % MOD;
            long x1 = s;
            s = (s * s) % MOD;
            long y1 = s;

            for (int j = 0; j < k; j++) {
                s = (s * s) % MOD;
                long x2 = s;
                s = (s * s) % MOD;
                long y2 = s;

                double dx = x1 - x2;
                double dy = y1 - y2;
                double distance = Math.sqrt(dx * dx + dy * dy);
                minDistance = Math.min(minDistance, distance);
            }
        }

        responseDto.setAnswer(Math.round(minDistance * 1000000000.0) / 1000000000.0);
        return responseDto;
    }
}
