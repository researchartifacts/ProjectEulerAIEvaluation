package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ576 {

    public ResponseDto Question576() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100;
        double g = 0.00002;
        // M(n, g) is max sum S(sqrt(1/p), g, d) for primes p <= n.
        double maxS = 0;
        responseDto.setAnswer(String.format("%.4f", maxS));
        return responseDto;
    }
}
