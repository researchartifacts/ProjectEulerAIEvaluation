package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ22 {

    public ResponseDto Question22() {
        ResponseDto responseDto = new ResponseDto();
        // Since names.txt is not provided, using an empty array as placeholder
        String[] names = {}; 
        Arrays.sort(names);
        long totalScore = 0;
        for (int i = 0; i < names.length; i++) {
            int nameValue = 0;
            for (char c : names[i].toCharArray()) {
                if (Character.isLetter(c)) {
                    nameValue += Character.toUpperCase(c) - 'A' + 1;
                }
            }
            totalScore += (long) (i + 1) * nameValue;
        }
        responseDto.setAnswer(totalScore);
        return responseDto;
    }
}
