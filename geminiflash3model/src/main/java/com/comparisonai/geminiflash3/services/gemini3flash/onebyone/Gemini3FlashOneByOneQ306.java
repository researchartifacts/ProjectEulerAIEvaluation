package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ306 {

    public ResponseDto Question306() {
        ResponseDto responseDto = new ResponseDto();
        
        int limit = 1000000;
        int[] grundy = new int[limit + 1];
        
        // The Grundy values for this game (Dawson's Kayles) are known to be periodic.
        // But we can compute them directly for a logic-based solution.
        int winCount = 0;
        
        // For larger n, we can use the periodicity to speed up.
        // But here's the direct Grundy calculation logic.
        for (int i = 1; i <= limit; i++) {
            grundy[i] = calculateMex(i, grundy);
            if (grundy[i] > 0) {
                winCount++;
            }
        }
        
        responseDto.setAnswer(winCount);
        return responseDto;
    }

    private int calculateMex(int n, int[] grundy) {
        Set<Integer> reachable = new HashSet<>();
        for (int i = 0; i <= n - 2; i++) {
            reachable.add(grundy[i] ^ grundy[n - i - 2]);
        }
        int mex = 0;
        while (reachable.contains(mex)) {
            mex++;
        }
        return mex;
    }
}
