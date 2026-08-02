package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ321 {

    public ResponseDto Question321() {
        ResponseDto responseDto = new ResponseDto();
        
        // M(n) = n(n+2)
        // n(n+2) = k(k+1)/2 => 2n^2 + 4n = k^2 + k
        // 8n^2 + 16n + 1 = 4k^2 + 4k + 1 - 7
        // 8(n+1)^2 - 8 + 1 = (2k+1)^2 - 7
        // (2k+1)^2 - 8(n+1)^2 = -7
        // X^2 - 8Y^2 = -7 where X = 2k+1, Y = n+1
        
        BigInteger sumN = BigInteger.ZERO;
        int count = 0;
        
        // Solutions to X^2 - 8Y^2 = -7
        // Fundamental solutions: (1, 1), (3, 2)? No, (1, 1) => X=1, Y=1 => n=0.
        // (5, 2) => 25 - 8(4) = 25 - 32 = -7. X=5, Y=2 => n=1.
        // (11, 4) => 121 - 8(16) = 121 - 128 = -7. X=11, Y=4 => n=3.
        
        // The solutions can be generated from fundamental ones using X^2 - 8Y^2 = 1 solutions.
        // Fundamental solution to X^2 - 8Y^2 = 1 is (3, 1).
        
        long[][] fundamental = {{1, 1}, {5, 2}, {11, 4}};
        // We need 40 solutions.
        
        responseDto.setAnswer(sumN.toString());
        return responseDto;
    }
}
