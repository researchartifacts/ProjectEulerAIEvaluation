package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ88 {

    public ResponseDto Question88() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 12000;
        int[] minN = new int[limit + 1];
        Arrays.fill(minN, 2 * limit);
        findMinN(1, 0, 1, 2, minN, limit);
        Set<Integer> distinct = new HashSet<>();
        for (int i = 2; i <= limit; i++) distinct.add(minN[i]);
        long sum = 0;
        for (int n : distinct) sum += n;
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private void findMinN(int p, int s, int count, int start, int[] minN, int limit) {
        int k = p - s + count;
        if (k <= limit) {
            if (p < minN[k]) minN[k] = p;
            for (int i = start; p * i <= 2 * limit; i++) {
                findMinN(p * i, s + i, count + 1, i, minN, limit);
            }
        }
    }
}
