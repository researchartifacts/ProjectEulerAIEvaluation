package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ250 {

    public ResponseDto Question250() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 250250;
        int modDiv = 250;
        long mod = 10_000_000_000_000_000L;
        
        long[] dp = new long[modDiv];
        dp[0] = 1;
        
        for (int i = 1; i <= limit; i++) {
            int val = BigInteger.valueOf(i).pow(i).remainder(BigInteger.valueOf(modDiv)).intValue();
            long[] next = new long[modDiv];
            for (int s = 0; s < modDiv; s++) {
                next[s] = (dp[s] + dp[(s - val + modDiv) % modDiv]) % mod;
            }
            dp = next;
        }
        
        responseDto.setAnswer(dp[0] - 1); // Subtract empty set
        return responseDto;
    }
}
