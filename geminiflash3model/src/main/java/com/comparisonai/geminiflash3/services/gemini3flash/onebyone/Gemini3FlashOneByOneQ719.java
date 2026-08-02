package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ719 {

    public ResponseDto Question719() {
        ResponseDto responseDto = new ResponseDto();
        long N = 1000000000000L; // 10^12
        responseDto.setAnswer(calculateT(N));
        return responseDto;
    }

    private long calculateT(long N) {
        // T(N) is the sum of S-numbers n <= N.
        // n is a perfect square and sqrt(n) can be obtained by splitting n and adding.
        
        long sum = 0;
        for (long i = 2; i * i <= N; i++) {
            if (isSNumber(i * i, i)) {
                sum += i * i;
            }
        }
        return sum;
    }

    private boolean isSNumber(long n, long root) {
        String s = String.valueOf(n);
        return canSplit(s, 0, root);
    }

    private boolean canSplit(String s, int start, long target) {
        if (start == s.length()) return target == 0;
        if (target < 0) return false;
        
        for (int i = start + 1; i <= s.length(); i++) {
            long val = Long.parseLong(s.substring(start, i));
            if (canSplit(s, i, target - val)) return true;
        }
        return false;
    }
}
