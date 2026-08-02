package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ42 {

    public ResponseDto Question42() {
        ResponseDto responseDto = new ResponseDto();
        String text = "The quick brown fox jumps over the lazy dog";
        int count = 0;
        Set<Integer> triangleNumbers = new HashSet<>();
        for (int i = 1; i * (i + 1) / 2 <= 300; i++) {
            triangleNumbers.add(i * (i + 1) / 2);
        }
        String[] words = text.split(" ");
        for (String word : words) {
            int wordValue = 0;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    wordValue += Character.toUpperCase(c) - 'A' + 1;
                }
            }
            if (triangleNumbers.contains(wordValue)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }
}
