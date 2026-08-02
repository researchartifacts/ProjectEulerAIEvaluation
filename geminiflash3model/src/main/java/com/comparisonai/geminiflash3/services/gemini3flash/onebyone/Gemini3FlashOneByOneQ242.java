package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ242 {

    public ResponseDto Question242() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1_000_000_000_000L;
        long mLimit = (limit - 1) / 2;
        
        // Sum 2^popcount(m) for m <= mLimit
        long count = countSubsets(mLimit);
        responseDto.setAnswer(count);
        return responseDto;
    }

    private long countSubsets(long n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        long highestBit = Long.highestOneBit(n);
        long power = Long.numberOfTrailingZeros(highestBit);
        // Numbers < highestBit: sum 2^popcount(i) = 3^power
        // Numbers >= highestBit: 2 * countSubsets(n - highestBit)
        return (long) Math.pow(3, power) + 2 * countSubsets(n - highestBit);
    }
}
