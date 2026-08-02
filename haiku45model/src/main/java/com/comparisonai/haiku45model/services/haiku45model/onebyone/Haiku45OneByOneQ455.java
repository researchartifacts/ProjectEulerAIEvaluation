package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ455 {

    public ResponseDto Question455() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 2; n <= 1000; n++) {
            int power = findLargestPowerMatch(n);
            result += power;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int findLargestPowerMatch(int n) {
        int maxPower = 0;
        for (int p = 2; p <= 100; p++) {
            long powered = (long) Math.pow(n, p);
            String nStr = String.valueOf(n);
            String powStr = String.valueOf(powered);
            if (powStr.endsWith(nStr)) {
                maxPower = p;
            }
        }
        return maxPower;
    }
}
