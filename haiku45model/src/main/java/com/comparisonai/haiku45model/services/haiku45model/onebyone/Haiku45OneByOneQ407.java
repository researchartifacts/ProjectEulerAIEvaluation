package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ407 {

    public ResponseDto Question407() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 10000;

        for (int n = 2; n <= limit; n++) {
            for (int m = 1; m < n; m++) {
                if ((m * m) % n == m % n) {
                    result += m;
                    break;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
