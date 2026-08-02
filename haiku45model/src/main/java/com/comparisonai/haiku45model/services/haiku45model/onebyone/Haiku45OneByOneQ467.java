package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ467 {

    public ResponseDto Question467() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            String permutation = String.valueOf(n);
            int position = findSuper(permutation);
            result = (result + position) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int findSuper(String s) {
        return Integer.parseInt(s);
    }
}
