package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ42 {

    public ResponseDto Question42() {
        ResponseDto responseDto = new ResponseDto();
        // words.txt is not provided, so using an empty list as placeholder
        String[] words = {}; 
        Set<Integer> triangleNumbers = new HashSet<>();
        for (int n = 1; n < 100; n++) {
            triangleNumbers.add(n * (n + 1) / 2);
        }
        int count = 0;
        for (String word : words) {
            int val = 0;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) val += Character.toUpperCase(c) - 'A' + 1;
            }
            if (triangleNumbers.contains(val)) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
