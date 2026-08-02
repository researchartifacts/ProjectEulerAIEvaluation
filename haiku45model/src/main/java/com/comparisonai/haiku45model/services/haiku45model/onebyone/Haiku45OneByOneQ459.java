package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ459 {

    public ResponseDto Question459() {
        ResponseDto responseDto = new ResponseDto();
        long winningMoves = 0;
        int maxSize = 100;

        for (int width = 1; width <= maxSize; width++) {
            for (int height = 1; height <= maxSize; height++) {
                if (isWinningPosition(width, height)) {
                    winningMoves++;
                }
            }
        }

        responseDto.setAnswer(winningMoves);
        return responseDto;
    }

    private boolean isWinningPosition(int w, int h) {
        return w % 2 == 1 && h % 2 == 1;
    }
}
