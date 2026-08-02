package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ105 {

    public ResponseDto Question105() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Special subset sum property
        long specialSum = 0;
        for (int n = 2; n <= 100; n++) {
            boolean special = true;
            int pow = 1 << n;
            if (pow > 100000) pow = 100000;
            for (int mask = 0; mask < pow; mask++) {
                int sum1 = 0;
                for (int i = 0; i < n && i < 20; i++) {
                    if ((mask & (1 << i)) != 0) sum1 += (i + 1);
                }
                if (sum1 > 0 && sum1 < n) special = false;
            }
            if (special && n < 20) specialSum += n;
        }
        result = specialSum;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

