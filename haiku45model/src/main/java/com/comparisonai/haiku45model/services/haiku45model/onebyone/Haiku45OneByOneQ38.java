package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ38 {

    public ResponseDto Question38() {
        ResponseDto responseDto = new ResponseDto();
        long maxPandigital = 0;
        for (int i = 1; i < 10000; i++) {
            StringBuilder pandigital = new StringBuilder();
            for (int j = 1; j <= 9; j++) {
                pandigital.append(i * j);
                if (pandigital.length() > 9) break;
            }
            if (pandigital.length() == 9 && isPandigital(pandigital.toString())) {
                long value = Long.parseLong(pandigital.toString());
                if (value > maxPandigital) {
                    maxPandigital = value;
                }
            }
        }
        responseDto.setAnswer(maxPandigital);
        return responseDto;
    }

    private boolean isPandigital(String s) {
        return s.length() == 9 && s.matches("[1-9]*") && s.chars().distinct().count() == 9;
    }
}
