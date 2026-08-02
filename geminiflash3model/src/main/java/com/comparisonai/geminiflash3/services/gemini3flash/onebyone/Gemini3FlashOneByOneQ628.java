package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ628 {

    public ResponseDto Question628() {
        ResponseDto responseDto = new ResponseDto();
        long n = 100000000L;
        long mod = 1008691207L;

        // f(n) = n! - 2(n-1)! - (n-3)
        // Let's verify for n=3: 6 - 4 - 0 = 2. Correct.
        // Let's verify for n=5: 120 - 48 - 2 = 70. Correct.
        
        long factN = 1;
        long factNminus1 = 1;
        for (int i = 1; i <= n; i++) {
            if (i < n) {
                factNminus1 = (factNminus1 * i) % mod;
            }
            factN = (factN * i) % mod;
        }

        long result = (factN - 2 * factNminus1 - (n - 3)) % mod;
        if (result < 0) result += mod;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
