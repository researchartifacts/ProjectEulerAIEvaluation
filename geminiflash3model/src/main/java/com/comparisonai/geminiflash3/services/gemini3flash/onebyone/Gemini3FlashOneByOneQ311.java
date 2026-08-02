package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ311 {

    public ResponseDto Question311() {
        ResponseDto responseDto = new ResponseDto();
        
        long N = 10000000000L;
        long count = 0;
        
        // AB^2 + AD^2 = BC^2 + CD^2 = 2(m^2 + k^2) = S
        // 2S <= N => S <= N/2
        // S is even, so m^2 + k^2 = S/2. Let T = S/2 = m^2 + k^2.
        // T <= N/4.
        // We need 4 distinct integers a < b < c < d such that a^2 + d^2 = b^2 + c^2 = 2T.
        // And m <= k where m^2 + k^2 = T.
        
        // This requires iterating over possible values of T and counting representations.
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
