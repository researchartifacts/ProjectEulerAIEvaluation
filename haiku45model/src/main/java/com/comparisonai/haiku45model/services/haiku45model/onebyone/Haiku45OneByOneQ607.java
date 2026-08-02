package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ607 {

    public ResponseDto Question607() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        double totalTime = 0;
        double directTime = 100.0 / 10.0;
        double marshTime = 10.0/9 + 10.0/8 + 10.0/7 + 10.0/6 + 10.0/5;
        double totalDirect = 50.0/10.0 + marshTime + 50.0/10.0;
        totalTime = totalDirect * 0.9;
        result = Math.round(totalTime * 10000000000L);
        responseDto.setAnswer(result);
        return responseDto;
    }
}
