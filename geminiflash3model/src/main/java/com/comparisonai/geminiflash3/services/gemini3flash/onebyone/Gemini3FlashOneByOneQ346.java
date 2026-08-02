package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ346 {

    public ResponseDto Question346() {
        ResponseDto responseDto = new ResponseDto();
        
        long limit = 1_000_000_000_000L;
        Set<Long> strongRepunits = new HashSet<>();
        strongRepunits.add(1L);
        
        // A number is a strong repunit if it is a repunit in at least two bases.
        // Every number n > 2 is a repunit in base n-1 (n = 11 in base n-1).
        // So we just need to find numbers that are repunits in some base b for k >= 3.
        // (b^k - 1) / (b - 1) < limit
        
        for (long b = 2; b * b < limit; b++) {
            long val = 1 + b + b * b;
            long bPower = b * b;
            while (val < limit) {
                strongRepunits.add(val);
                if (limit / b < bPower) break;
                bPower *= b;
                val += bPower;
            }
        }
        
        long sum = 0;
        for (long n : strongRepunits) {
            sum += n;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }
}
