package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ154 {

    public ResponseDto Question154() {
        ResponseDto responseDto = new ResponseDto();
        int n = 200000;
        int[] v2 = new int[n + 1];
        int[] v5 = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            v2[i] = v2[i - 1] + getVp(i, 2);
            v5[i] = v5[i - 1] + getVp(i, 5);
        }
        
        long count = 0;
        int nV2 = v2[n];
        int nV5 = v5[n];
        
        for (int a = 0; a <= n; a++) {
            for (int b = 0; a + b <= n; b++) {
                int c = n - a - b;
                if (nV2 - v2[a] - v2[b] - v2[c] >= 12 &&
                    nV5 - v5[a] - v5[b] - v5[c] >= 12) {
                    count++;
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int getVp(int n, int p) {
        int count = 0;
        while (n > 0 && n % p == 0) {
            count++;
            n /= p;
        }
        return count;
    }
}
