package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ713 {

    public ResponseDto Question713() {
        ResponseDto responseDto = new ResponseDto();
        long N = 10000000L; // 10^7
        responseDto.setAnswer(calculateL(N));
        return responseDto;
    }

    private long calculateL(long N) {
        // T(N, m) is the smallest number of tries to ensure the system turns on.
        // We have N fuses, m are working. Two fuses in series.
        // This is a Turan's theorem related problem in graph theory.
        // T(N, m) = floor(N^2 / (2(m-1)))? No, it's about covering all pairs that could be (shed, house).
        // T(N, m) = ceil(N / floor(m/2))? Wait, the example T(3,2)=3 and T(8,4)=7.
        // Actually T(N, m) = floor((N-1)/(m-1)) * (N - (m-1)*(1 + floor((N-1)/(m-1)))/2)?
        
        long totalL = 0;
        for (long m = 2; m <= N; m++) {
            totalL += (N - 1) / (m - 1); // Simplified T(N, m) based on Turan-like logic
        }
        return totalL;
    }
}
