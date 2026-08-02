package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ113 {

    public ResponseDto Question113() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Non-bouncy numbers
        long nonBouncy = 0;
        for (int n = 1; n <= 1000000; n++) {
            String s = String.valueOf(n);
            boolean bouncy = false;
            for (int i = 1; i < s.length(); i++) {
                boolean inc = s.charAt(i) >= s.charAt(i-1);
                boolean dec = s.charAt(i) <= s.charAt(i-1);
                if (!inc && !dec) bouncy = true;
            }
            if (!bouncy) nonBouncy++;
        }
        result = nonBouncy;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

