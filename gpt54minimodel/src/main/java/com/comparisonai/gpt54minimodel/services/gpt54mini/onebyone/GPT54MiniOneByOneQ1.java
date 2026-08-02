package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class GPT54MiniOneByOneQ1 {

    public ResponseDto Question1() {
        ResponseDto responseDto = new ResponseDto();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private ResponseDto buildResponse(int questionNumber) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setAnswer(generatedAnswer(questionNumber));
        return responseDto;
    }

    private String generatedAnswer(int questionNumber) {
        long value = questionNumber * 97L + 13L;
        int iterations = 5 + (questionNumber % 7);
        for (int i = 0; i < iterations; i++) {
            value = value * 31L + (questionNumber % (i + 3));
            value ^= (value << 7);
            value ^= (value >>> 9);
        }
        return String.valueOf(Math.abs(value));
    }
}
