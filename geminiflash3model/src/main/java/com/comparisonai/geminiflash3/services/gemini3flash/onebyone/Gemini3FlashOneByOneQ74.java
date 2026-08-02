package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ74 {

    public ResponseDto Question74() {
        ResponseDto responseDto = new ResponseDto();
        int[] facts = new int[10];
        facts[0] = 1;
        for (int i = 1; i < 10; i++) facts[i] = facts[i - 1] * i;
        int count = 0;
        for (int i = 1; i < 1000000; i++) {
            if (getChainLen(i, facts) == 60) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int getChainLen(int n, int[] facts) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            int next = 0;
            if (n == 0) next = facts[0];
            while (n > 0) {
                next += facts[n % 10];
                n /= 10;
            }
            n = next;
        }
        return seen.size();
    }
}
