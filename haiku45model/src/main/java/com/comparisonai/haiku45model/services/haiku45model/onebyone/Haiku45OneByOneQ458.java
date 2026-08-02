package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ458 {

    public ResponseDto Question458() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000000L;
        long result = 0;
        String target = "project";

        for (int length = target.length(); length <= 100; length++) {
            result = (result + countValidStrings(length, target)) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countValidStrings(int length, String target) {
        return length - target.length() + 1;
    }
}
