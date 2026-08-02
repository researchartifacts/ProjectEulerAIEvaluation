package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ101 {

    public ResponseDto Question101() {
        ResponseDto responseDto = new ResponseDto();
        long totalFIT = 0;
        for (int k = 1; k <= 10; k++) {
            totalFIT += getFIT(k);
        }
        responseDto.setAnswer(String.valueOf(totalFIT));
        return responseDto;
    }

    private long getFIT(int k) {
        long[] sequence = new long[k + 1];
        for (int n = 1; n <= k + 1; n++) {
            sequence[n - 1] = getTerm(n);
        }

        long[][] diffs = new long[k][k];
        for (int i = 0; i < k; i++) {
            diffs[0][i] = sequence[i];
        }

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < k - i; j++) {
                diffs[i][j] = diffs[i - 1][j + 1] - diffs[i - 1][j];
            }
        }

        long nextTerm = 0;
        for (int i = 0; i < k; i++) {
            nextTerm += diffs[i][0];
        }
        
        return getTerm(k + 1) == nextTerm ? 0 : nextTerm;
    }

    private long getTerm(int n) {
        long term = 0;
        long p = 1;
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                term += p;
            } else {
                term -= p;
            }
            p *= n;
        }
        return term;
    }
}
