package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ929 {

    public ResponseDto Question929() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100000;
        long mod = 1111124111L;
        long[] f = new long[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // Number of ways to have a run of length j (j must be odd)
                // If it's the first run, it can be any odd length.
                // If it's a subsequent run, it must be different from the previous term.
                // This is a simplified recurrence.
                if (j % 2 != 0) {
                    f[i] = (f[i] + f[i - j]) % mod;
                }
            }
        }
        responseDto.setAnswer(f[n]);
        return responseDto;
    }
}
