package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ52 {

    public ResponseDto Question52() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; ; i++) {
            if (hasSameDigits(i, 2 * i) && hasSameDigits(i, 3 * i) &&
                hasSameDigits(i, 4 * i) && hasSameDigits(i, 5 * i) &&
                hasSameDigits(i, 6 * i)) {
                responseDto.setAnswer(i);
                break;
            }
        }
        return responseDto;
    }

    private boolean hasSameDigits(int a, int b) {
        char[] ca = String.valueOf(a).toCharArray();
        char[] cb = String.valueOf(b).toCharArray();
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca, cb);
    }
}
