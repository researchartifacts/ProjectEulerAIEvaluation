package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ72 {

    public ResponseDto Question72() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] phi = new int[limit + 1];
        for (int i = 0; i <= limit; i++) phi[i] = i;
        for (int i = 2; i <= limit; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= limit; j += i) {
                    phi[j] = phi[j] / i * (i - 1);
                }
            }
        }
        long sum = 0;
        for (int i = 2; i <= limit; i++) sum += phi[i];
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
