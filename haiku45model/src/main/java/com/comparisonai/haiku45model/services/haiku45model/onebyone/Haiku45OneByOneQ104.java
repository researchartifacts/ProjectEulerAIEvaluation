package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ104 {

    public ResponseDto Question104() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Pandigital Fibonacci
        long f1 = 1, f2 = 1;
        long result_pos = 0;
        for (int k = 3; k < 100000; k++) {
            long f3 = f1 + f2;
            String s = String.valueOf(f3);
            if (s.length() >= 9) {
                String first9 = s.substring(0, 9);
                String last9 = s.length() > 9 ? s.substring(s.length()-9) : s;
                if (isPandigital(first9) && isPandigital(last9)) {
                    result = k;
                    return responseDto;
                }
            }
            f1 = f2;
            f2 = f3;
        }
        result = result_pos;

        responseDto.setAnswer(result);
        return responseDto;
    }
    private boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            if (c < '1' || c > '9') return false;
            if (seen[c - '0']) return false;
            seen[c - '0'] = true;
        }
        return true;
    }
}

