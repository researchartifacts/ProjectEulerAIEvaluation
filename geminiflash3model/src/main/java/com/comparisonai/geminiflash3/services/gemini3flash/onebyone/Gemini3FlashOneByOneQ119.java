package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ119 {

    public ResponseDto Question119() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> sequence = new ArrayList<>();
        for (int sum = 2; sum < 200; sum++) {
            long p = sum;
            for (int e = 2; e < 15; e++) {
                if (Long.MAX_VALUE / sum < p) break;
                p *= sum;
                if (digitSum(p) == sum) {
                    sequence.add(p);
                }
            }
        }
        Collections.sort(sequence);
        responseDto.setAnswer(String.valueOf(sequence.get(29)));
        return responseDto;
    }

    private int digitSum(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
