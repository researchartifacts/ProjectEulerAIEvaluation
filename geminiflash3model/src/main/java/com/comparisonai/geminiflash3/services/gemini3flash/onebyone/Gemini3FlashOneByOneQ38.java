package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ38 {

    public ResponseDto Question38() {
        ResponseDto responseDto = new ResponseDto();
        long maxPandigital = 0;
        for (int i = 1; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            for (int n = 1; sb.length() < 9; n++) {
                sb.append(i * n);
            }
            if (sb.length() == 9 && isPandigital(sb.toString())) {
                maxPandigital = Math.max(maxPandigital, Long.parseLong(sb.toString()));
            }
        }
        responseDto.setAnswer(maxPandigital);
        return responseDto;
    }

    private boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        boolean[] used = new boolean[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0 || used[d]) return false;
            used[d] = true;
        }
        return true;
    }
}
