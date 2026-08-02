package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ419 {

    public ResponseDto Question419() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1073741824L;
        long ones = 0, twos = 0, threes = 0;

        String sequence = "1";
        for (int i = 0; i < 15; i++) {
            sequence = lookAndSay(sequence);
        }

        for (char c : sequence.toCharArray()) {
            if (c == '1') ones++;
            else if (c == '2') twos++;
            else if (c == '3') threes++;
        }

        long result = (ones + twos * 2 + threes * 3) % MOD;
        responseDto.setAnswer(result);
        return responseDto;
    }

    private String lookAndSay(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == current) {
                count++;
                i++;
            }
            result.append(count).append(current);
            i++;
        }
        return result.toString();
    }
}
