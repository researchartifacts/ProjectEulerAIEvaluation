package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ803 {

    public ResponseDto Question803() {
        ResponseDto responseDto = new ResponseDto();

        long a0 = generateSeedFromString("PuzzleOne");
        long index = 0;
        StringBuilder stringC = new StringBuilder();
        String target = "LuckyText";

        while (index < 100000000) {
            a0 = (25214903917L * a0 + 11) % (1L << 48);
            long bn = (a0 >> 16) % 52;
            char c;
            if (bn < 26) {
                c = (char) ('a' + bn);
            } else {
                c = (char) ('A' + (bn - 26));
            }
            stringC.append(c);

            if (stringC.length() >= target.length()) {
                if (stringC.substring(stringC.length() - target.length()).equals(target)) {
                    responseDto.setAnswer(index - target.length() + 1);
                    return responseDto;
                }
            }
            index++;
        }

        responseDto.setAnswer(-1);
        return responseDto;
    }

    private long generateSeedFromString(String s) {
        long seed = 0;
        for (char c : s.toCharArray()) {
            int val;
            if (c >= 'a' && c <= 'z') {
                val = c - 'a';
            } else {
                val = c - 'A' + 26;
            }
            seed = seed * 52 + val;
        }
        return seed % (1L << 48);
    }
}
