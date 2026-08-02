package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ462 {

    public ResponseDto Question462() {
        ResponseDto responseDto = new ResponseDto();
        long result = 1;

        for (int i = 2; i <= 50; i++) {
            if (isSmooth(i, 3)) {
                result *= i;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isSmooth(int n, int b) {
        while (n > 1) {
            boolean found = false;
            for (int p = 2; p <= b; p++) {
                if (n % p == 0) {
                    n /= p;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
