package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ24 {

    public ResponseDto Question24() {
        ResponseDto responseDto = new ResponseDto();
        int n = 10;
        int target = 1000000;
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < n; i++) digits.add(i);
        StringBuilder sb = new StringBuilder();
        target--; // 0-indexed
        for (int i = n - 1; i >= 0; i--) {
            long f = factorial(i);
            int index = (int) (target / f);
            sb.append(digits.get(index));
            digits.remove(index);
            target %= f;
        }
        responseDto.setAnswer(sb.toString());
        return responseDto;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}
