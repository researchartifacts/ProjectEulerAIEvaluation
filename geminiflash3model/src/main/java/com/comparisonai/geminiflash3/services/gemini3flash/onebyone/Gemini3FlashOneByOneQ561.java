package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ561 {

    public ResponseDto Question561() {
        ResponseDto responseDto = new ResponseDto();
        long N = 1000000000000L;
        long M = 904961;
        
        long count4_N_plus_1 = (N + 1) / 4;
        long count4_N = N / 4;
        
        long sumV2_N_plus_1 = sumV2(count4_N_plus_1);
        long sumV2_N = sumV2(count4_N);
        
        long result = M * (count4_N_plus_1 + sumV2_N_plus_1) + (count4_N + sumV2_N);
        
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }
    
    private long sumV2(long X) {
        long sum = 0;
        while (X > 0) {
            X /= 2;
            sum += X;
        }
        return sum;
    }
}
