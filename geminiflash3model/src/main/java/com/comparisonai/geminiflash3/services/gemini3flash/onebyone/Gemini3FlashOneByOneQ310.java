package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ310 {

    public ResponseDto Question310() {
        ResponseDto responseDto = new ResponseDto();
        
        int limit = 100000;
        int[] grundy = new int[limit + 1];
        
        for (int i = 1; i <= limit; i++) {
            Set<Integer> reachable = new HashSet<>();
            for (int k = 1; k * k <= i; k++) {
                reachable.add(grundy[i - k * k]);
            }
            int mex = 0;
            while (reachable.contains(mex)) {
                mex++;
            }
            grundy[i] = mex;
        }
        
        long losingPositions = 0;
        int maxGrundy = 0;
        for (int g : grundy) if (g > maxGrundy) maxGrundy = g;
        
        long[] counts = new long[maxGrundy + 1];
        for (int g : grundy) counts[g]++;
        
        // Count (a, b, c) such that g(a) ^ g(b) ^ g(c) == 0 and 0 <= a <= b <= c <= limit
        for (int i = 0; i <= maxGrundy; i++) {
            for (int j = i; j <= maxGrundy; j++) {
                int k = i ^ j;
                if (k >= j && k <= maxGrundy) {
                    if (i == j && j == k) {
                        losingPositions += counts[i] * (counts[i] + 1) * (counts[i] + 2) / 6;
                    } else if (i == j) {
                        losingPositions += counts[i] * (counts[i] + 1) / 2 * counts[k];
                    } else if (j == k) {
                        losingPositions += counts[i] * counts[j] * (counts[j] + 1) / 2;
                    } else {
                        losingPositions += counts[i] * counts[j] * counts[k];
                    }
                }
            }
        }
        
        responseDto.setAnswer(losingPositions);
        return responseDto;
    }
}
