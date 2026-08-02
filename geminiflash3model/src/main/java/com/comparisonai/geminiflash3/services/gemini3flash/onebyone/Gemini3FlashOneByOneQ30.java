package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ30 {

    public ResponseDto Question30() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        for (int i = 2; i < 1000000; i++) {
            if (i == sumOfFifthPowers(i)) {
                totalSum += i;
            }
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int sumOfFifthPowers(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += Math.pow(digit, 5);
            n /= 10;
        }
        return sum;
    }
}
