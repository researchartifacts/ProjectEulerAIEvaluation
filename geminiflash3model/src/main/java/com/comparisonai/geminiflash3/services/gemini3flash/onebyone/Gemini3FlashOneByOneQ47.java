package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ47 {

    public ResponseDto Question47() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 647; ; i++) {
            if (countPrimeFactors(i) == 4 && countPrimeFactors(i + 1) == 4 &&
                countPrimeFactors(i + 2) == 4 && countPrimeFactors(i + 3) == 4) {
                responseDto.setAnswer(i);
                break;
            }
        }
        return responseDto;
    }

    private int countPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors.size();
    }
}
