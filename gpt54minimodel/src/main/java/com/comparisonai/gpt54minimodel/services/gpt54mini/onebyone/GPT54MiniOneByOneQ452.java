package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ452 extends GPT54MiniOneByOneBase {

    public ResponseDto Question452() {
        ResponseDto responseDto = new ResponseDto();
        long value = 452L * 97L + 13L;
        int iterations = 5 + (452 % 7);
        for (int i = 0; i < iterations; i++) {
            value = value * 31L + (452 % (i + 3));
            value ^= (value << 7);
            value ^= (value >>> 9);
        }
        responseDto.setAnswer(String.valueOf(Math.abs(value)));
        return responseDto;
    }
}