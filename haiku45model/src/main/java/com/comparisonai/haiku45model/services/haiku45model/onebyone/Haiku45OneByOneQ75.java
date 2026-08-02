package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ75 {

    public ResponseDto Question75() {
        ResponseDto responseDto = new ResponseDto();
        int[] counts = new int[1500001];
        for (int a = 1; a <= 500; a++) {
            for (int b = a + 1; b <= 500; b++) {
                int c = (int) Math.sqrt(a * a + b * b);
                if (a * a + b * b == c * c) {
                    for (int k = 1; k * (a + b + c) <= 1500000; k++) {
                        counts[k * (a + b + c)]++;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= 1500000; i++) {
            if (counts[i] == 1) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
