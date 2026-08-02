package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ220 {

    public ResponseDto Question220() {
        ResponseDto responseDto = new ResponseDto();
        long steps = 1_000_000_000_000L;
        
        // Displacement and rotation after steps
        long x = 0, y = 0;
        int dir = 0; // 0: N, 1: E, 2: S, 3: W
        
        // Heighway Dragon recursive step
        long[] pos = getPos(50, steps);
        
        responseDto.setAnswer(pos[0] + "," + pos[1]);
        return responseDto;
    }

    private long[] getPos(int n, long k) {
        if (n == 0) return k == 0 ? new long[]{0, 0} : new long[]{0, 1};
        
        long mid = 1L << (n - 1);
        if (k <= mid) {
            return getPos(n - 1, k);
        } else {
            long[] p1 = getPos(n - 1, mid);
            long[] p2 = getPos(n - 1, k - mid);
            // Rotated and translated
            // Second half is p1 + rotate(p2, some angle)
            return new long[]{p1[0] + p2[1], p1[1] - p2[0]}; // Example rotation
        }
    }
}
