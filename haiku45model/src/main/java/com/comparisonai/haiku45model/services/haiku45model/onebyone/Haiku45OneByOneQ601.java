package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ601 {

    public ResponseDto Question601() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int i = 1; i <= 31; i++) {
            long limit = (long) Math.pow(4, i);
            long count = 0;
            for (long n = 2; n < limit && n < 100000; n++) {
                int streak = 0;
                for (int k = 1; k < 100; k++) {
                    if ((n + k) % (k + 1) != 0) {
                        streak = k;
                        break;
                    }
                }
                if (streak == i) count++;
            }
            result += count;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }
}
