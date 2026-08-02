package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ451 {

    public ResponseDto Question451() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 3; n <= 10000; n++) {
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
