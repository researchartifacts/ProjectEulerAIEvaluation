package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ480 {

    public ResponseDto Question480() {
        ResponseDto responseDto = new ResponseDto();
        String word1 = "legionary";
        String word2 = "calorimeters";
        String word3 = "annihilate";

        long position = word1.length() + word2.length() - word3.length();
        responseDto.setAnswer(position);
        return responseDto;
    }
}
