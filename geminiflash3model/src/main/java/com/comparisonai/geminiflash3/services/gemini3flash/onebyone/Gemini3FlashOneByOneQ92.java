package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ92 {

    public ResponseDto Question92() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 10000000;
        int count = 0;
        int[] cache = new int[limit];
        for (int i = 1; i < limit; i++) {
            if (arrivesAt89(i, cache)) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean arrivesAt89(int n, int[] cache) {
        int original = n;
        while (n != 1 && n != 89) {
            if (n < cache.length && cache[n] != 0) {
                n = cache[n];
                break;
            }
            int next = 0;
            int temp = n;
            while (temp > 0) {
                int d = temp % 10;
                next += d * d;
                temp /= 10;
            }
            n = next;
        }
        if (original < cache.length) cache[original] = n;
        return n == 89;
    }
}
