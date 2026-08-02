package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ494 {

    public ResponseDto Question494() {
        ResponseDto responseDto = new ResponseDto();
        long distinctFamilies = 0;

        for (int n = 1; n <= 90; n++) {
            long collatzLength = 0;
            long current = n;
            while (current != 1) {
                if (current % 2 == 0) {
                    current /= 2;
                } else {
                    current = 3 * current + 1;
                }
                collatzLength++;
            }
            distinctFamilies++;
        }

        responseDto.setAnswer(distinctFamilies);
        return responseDto;
    }
}
