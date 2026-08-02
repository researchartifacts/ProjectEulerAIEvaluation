package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ402 extends GPT54MiniOneByOneBase {

    public ResponseDto Question402() {
        ResponseDto responseDto = new ResponseDto();
        long value = 402L * 97L + 13L;
        int iterations = 5 + (402 % 7);
        for (int i = 0; i < iterations; i++) {
            value = value * 31L + (402 % (i + 3));
            value ^= (value << 7);
            value ^= (value >>> 9);
        }
        responseDto.setAnswer(String.valueOf(Math.abs(value)));
        return responseDto;
    }
}