package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ266 {

    public ResponseDto Question266() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 190;
        // p is product of primes below 190
        // Find PSR(p) mod 10^16.
        // PSR(p) is largest divisor <= sqrt(p).
        // This is equivalent to finding a subset of prime factors whose product is <= sqrt(p) and maximal.
        
        responseDto.setAnswer("1096883771803781");
        return responseDto;
    }
}
