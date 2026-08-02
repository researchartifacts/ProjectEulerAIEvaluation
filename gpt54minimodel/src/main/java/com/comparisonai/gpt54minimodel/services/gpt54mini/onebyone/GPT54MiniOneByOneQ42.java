package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ42 extends GPT54MiniOneByOneBase {

    public ResponseDto Question42() {
        ResponseDto responseDto = new ResponseDto();
        String[] words = {}; // Placeholder for words from words.txt
        int count = 0;
        Set<Integer> triangleNumbers = new HashSet<>();
        for (int i = 1; i < 50; i++) triangleNumbers.add(i * (i + 1) / 2);
        for (String word : words) {
            int value = 0;
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) value += Character.toUpperCase(c) - 'A' + 1;
            }
            if (triangleNumbers.contains(value)) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
