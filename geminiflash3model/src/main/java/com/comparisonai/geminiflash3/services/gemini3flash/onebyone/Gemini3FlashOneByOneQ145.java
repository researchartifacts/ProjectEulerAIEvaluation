package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ145 {

    public ResponseDto Question145() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0;
        for (int digits = 2; digits <= 9; digits++) {
            count += countReversible(digits);
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private long countReversible(int k) {
        if (k % 4 == 1) return 0;
        if (k % 2 == 0) {
            // k = 2j. 20 * 30^(j-1)
            return 20 * (long) Math.pow(30, k / 2 - 1);
        }
        if (k % 4 == 3) {
            // k = 4j + 3. 100 * 500^j
            return 100 * (long) Math.pow(500, k / 4);
        }
        return 0;
    }
}
