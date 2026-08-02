package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ205 {

    public ResponseDto Question205() {
        ResponseDto responseDto = new ResponseDto();
        
        long[] peter = getFreqs(9, 4);
        long[] colin = getFreqs(6, 6);
        
        double pTotal = Math.pow(4, 9);
        double cTotal = Math.pow(6, 6);
        
        double winProb = 0;
        for (int p = 9; p <= 36; p++) {
            if (peter[p] == 0) continue;
            double pProb = peter[p] / pTotal;
            for (int c = 6; c < p && c <= 36; c++) {
                if (colin[c] == 0) continue;
                winProb += pProb * (colin[c] / cTotal);
            }
        }
        
        responseDto.setAnswer(String.format("%.7f", winProb));
        return responseDto;
    }

    private long[] getFreqs(int n, int s) {
        long[] f = new long[n * s + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            long[] next = new long[n * s + 1];
            for (int val = 0; val < f.length; val++) {
                if (f[val] > 0) {
                    for (int side = 1; side <= s; side++) {
                        if (val + side < next.length) next[val + side] += f[val];
                    }
                }
            }
            f = next;
        }
        return f;
    }
}
