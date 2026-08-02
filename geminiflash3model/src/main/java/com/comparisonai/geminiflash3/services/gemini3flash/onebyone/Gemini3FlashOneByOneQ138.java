package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ138 {

    public ResponseDto Question138() {
        ResponseDto responseDto = new ResponseDto();
        int target = 12;
        BigInteger sumL = BigInteger.ZERO;
        
        // Solutions to X^2 - 5Y^2 = -1 are related to Fibonacci numbers.
        // Specifically, Y (which is L) values follow a recurrence.
        // L1 = 17, L2 = 305.
        // Recurrence: L(n) = 18*L(n-1) - L(n-2)
        BigInteger l1 = BigInteger.valueOf(17);
        BigInteger l2 = BigInteger.valueOf(305);
        sumL = sumL.add(l1).add(l2);
        
        for (int i = 3; i <= target; i++) {
            BigInteger l3 = l2.multiply(BigInteger.valueOf(18)).subtract(l1);
            sumL = sumL.add(l3);
            l1 = l2;
            l2 = l3;
        }
        
        responseDto.setAnswer(sumL.toString());
        return responseDto;
    }
}
