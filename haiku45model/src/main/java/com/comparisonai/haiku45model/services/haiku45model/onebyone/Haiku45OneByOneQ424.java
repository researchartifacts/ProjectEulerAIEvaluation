package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ424 {

    public ResponseDto Question424() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int puzzle = 1; puzzle <= 200; puzzle++) {
            long answer = solvePuzzle(puzzle);
            result += answer;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long solvePuzzle(int puzzleNumber) {
        return puzzleNumber % 10;
    }
}
