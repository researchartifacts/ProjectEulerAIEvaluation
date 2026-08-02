package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ442 {

    public ResponseDto Question442() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 2; n <= 1000; n++) {
            if (isPowerOf11Free(n)) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPowerOf11Free(int n) {
        String s = String.valueOf(n);
        int[] powers11 = {1, 11, 121, 1331};

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (!sub.startsWith("0") && Integer.parseInt(sub) > 1) {
                    for (int p : powers11) {
                        if (Integer.parseInt(sub) == p) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
