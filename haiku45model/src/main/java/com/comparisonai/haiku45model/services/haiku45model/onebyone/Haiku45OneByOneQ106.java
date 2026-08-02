package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ106 {

    public ResponseDto Question106() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Subset sum equality
        long validCount = 0;
        for (int n = 3; n <= 50; n++) {
            for (int mask1 = 1; mask1 < (1 << n); mask1++) {
                for (int mask2 = mask1 + 1; mask2 < (1 << n); mask2++) {
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < n; i++) {
                        if ((mask1 & (1 << i)) != 0) sum1 += i;
                        if ((mask2 & (1 << i)) != 0) sum2 += i;
                    }
                    if (sum1 == sum2) validCount++;
                }
            }
        }
        result = Math.min(validCount, 1000000L);

        responseDto.setAnswer(result);
        return responseDto;
    }
}

