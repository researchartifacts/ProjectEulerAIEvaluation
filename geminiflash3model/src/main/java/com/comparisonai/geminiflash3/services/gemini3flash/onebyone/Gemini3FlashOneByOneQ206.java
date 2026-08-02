package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ206 {

    public ResponseDto Question206() {
        ResponseDto responseDto = new ResponseDto();
        // 1_2_3_4_5_6_7_8_9_0
        // Sqrt must end in 0. Let root = 10*x.
        // (10x)^2 = 100x^2 = 1_2_3_4_5_6_7_8_9_0
        // so x^2 ends in 9. x ends in 3 or 7.
        // x is around sqrt(10203040506070809) / 10 = sqrt(1.02*10^16)/10 = 10^7.
        
        long start = 101010103L;
        long end = 138902667L;
        
        for (long i = start; i <= end; i += 10) {
            if (check(i)) { responseDto.setAnswer(i * 10); break; }
            if (check(i + 4)) { responseDto.setAnswer((i + 4) * 10); break; }
        }
        return responseDto;
    }

    private boolean check(long n) {
        String s = String.valueOf(n * n);
        if (s.length() != 17) return false;
        for (int i = 0; i < 9; i++) {
            if (s.charAt(2 * i) != (char)('1' + i)) return false;
        }
        return true;
    }
}
