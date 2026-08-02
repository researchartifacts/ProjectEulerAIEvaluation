package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ32 {

    public ResponseDto Question32() {
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> products = new HashSet<>();
        for (int a = 1; a < 100; a++) {
            for (int b = 100; b < 10000; b++) {
                int p = a * b;
                if (isPandigital("" + a + b + p)) {
                    products.add(p);
                }
            }
        }
        long sum = 0;
        for (int p : products) sum += p;
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        boolean[] used = new boolean[10];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0 || used[d]) return false;
            used[d] = true;
        }
        return true;
    }
}
