package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ34 {

    public ResponseDto Question34() {
        ResponseDto responseDto = new ResponseDto();
        int[] facts = new int[10];
        facts[0] = 1;
        for (int i = 1; i < 10; i++) facts[i] = facts[i - 1] * i;
        long totalSum = 0;
        for (int i = 10; i < 2540160; i++) {
            if (i == sumFacts(i, facts)) totalSum += i;
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int sumFacts(int n, int[] facts) {
        int sum = 0;
        while (n > 0) {
            sum += facts[n % 10];
            n /= 10;
        }
        return sum;
    }
}
