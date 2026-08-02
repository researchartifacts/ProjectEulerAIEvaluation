package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ126 {

    public ResponseDto Question126() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 20000; // Guessing a limit
        int targetC = 1000;
        int[] count = new int[limit + 1];

        for (int a = 1; ; a++) {
            if (layerSize(a, a, a, 1) > limit) break;
            for (int b = a; ; b++) {
                if (layerSize(a, b, b, 1) > limit) break;
                for (int c = b; ; c++) {
                    if (layerSize(a, b, c, 1) > limit) break;
                    for (int k = 1; ; k++) {
                        int size = layerSize(a, b, c, k);
                        if (size > limit) break;
                        count[size]++;
                    }
                }
            }
        }

        for (int n = 1; n <= limit; n++) {
            if (count[n] == targetC) {
                responseDto.setAnswer(String.valueOf(n));
                return responseDto;
            }
        }
        
        responseDto.setAnswer("Not found in limit");
        return responseDto;
    }

    private int layerSize(int a, int b, int c, int k) {
        return 2 * (a * b + b * c + c * a) + 4 * (a + b + c + k - 2) * (k - 1);
    }
}
