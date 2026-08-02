package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ40 {

    public ResponseDto Question40() {
        ResponseDto responseDto = new ResponseDto();
        StringBuilder champernowne = new StringBuilder();
        for (int i = 1; champernowne.length() < 1000000; i++) {
            champernowne.append(i);
        }
        long product = 1;
        int[] positions = {1, 10, 100, 1000, 10000, 100000, 1000000};
        for (int pos : positions) {
            product *= Character.getNumericValue(champernowne.charAt(pos - 1));
        }
        responseDto.setAnswer(product);
        return responseDto;
    }
}
