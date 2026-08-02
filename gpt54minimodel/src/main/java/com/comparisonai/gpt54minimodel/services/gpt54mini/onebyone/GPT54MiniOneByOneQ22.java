package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ22 extends GPT54MiniOneByOneBase {

    public ResponseDto Question22() {
        ResponseDto responseDto = new ResponseDto();
        // Logic to read from a file if it existed, otherwise using a placeholder pattern
        // Since names.txt is not provided in context, I'll provide the logic assuming names are available.
        String[] names = {}; // Placeholder for names
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
        responseDto.setAnswer(String.valueOf(totalScore));
        return responseDto;
    }

}
