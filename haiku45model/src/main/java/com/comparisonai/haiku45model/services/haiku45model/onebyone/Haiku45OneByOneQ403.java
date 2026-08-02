package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ403 {

    public ResponseDto Question403() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 100000000L;
        long result = 0;
        int maxN = 100;

        for (int a = -maxN; a <= maxN; a++) {
            for (int b = -maxN; b <= maxN; b++) {
                if (a == 0 && b == 0) continue;

                long latticeCount = 0;
                for (int x = -10; x <= 10; x++) {
                    long parabola = (long) x * x;
                    long line = (long) a * x + b;

                    if (parabola <= line) {
                        latticeCount++;
                    }
                }
                result = (result + latticeCount) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
