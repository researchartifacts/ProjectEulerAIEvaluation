package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ28 {

    public ResponseDto Question28() {
        ResponseDto responseDto = new ResponseDto();
        int size = 1001;
        int[][] spiral = new int[size][size];
        int x = size / 2;
        int y = size / 2;
        int num = 1;
        spiral[x][y] = num++;
        int stepSize = 1;
        while (num <= size * size) {
            for (int i = 0; i < 2; i++) {
                for (int dx = 0; dx < stepSize && num <= size * size; dx++) {
                    y++;
                    spiral[x][y] = num++;
                }
                for (int dy = 0; dy < stepSize && num <= size * size; dy++) {
                    x++;
                    spiral[x][y] = num++;
                }
                stepSize++;
            }
        }
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += spiral[i][i];
            sum += spiral[i][size - 1 - i];
        }
        sum -= spiral[size / 2][size / 2];
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
