package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ893 {

    public ResponseDto Question893() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int i = 1; i <= 1000; i++) {
            int minSticks = findMinimumSticks(i);
            result += minSticks;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int findMinimumSticks(int n) {
        for (int sticks = 1; sticks <= n; sticks++) {
            if (canMake(n, sticks)) {
                return sticks;
            }
        }
        return n;
    }

    private boolean canMake(int target, int sticks) {
        return target >= sticks;
    }
}
