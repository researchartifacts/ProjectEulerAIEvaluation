package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ122 {

    public ResponseDto Question122() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 200;
        int[] m = new int[limit + 1];
        Arrays.fill(m, -1);
        m[1] = 0;

        List<int[]> currentChains = new ArrayList<>();
        currentChains.add(new int[]{1});

        int solved = 1;
        int depth = 0;

        while (solved < limit) {
            depth++;
            List<int[]> nextChains = new ArrayList<>();
            for (int[] chain : currentChains) {
                int last = chain[chain.length - 1];
                for (int i = chain.length - 1; i >= 0; i--) {
                    int nextVal = last + chain[i];
                    if (nextVal <= limit) {
                        if (m[nextVal] == -1) {
                            m[nextVal] = depth;
                            solved++;
                        }
                        if (nextVal > last) {
                            int[] nextChain = Arrays.copyOf(chain, chain.length + 1);
                            nextChain[nextChain.length - 1] = nextVal;
                            // Heuristic: prune if nextVal doesn't help reach unsolved values within depth limit
                            // But for 200, BFS might be too slow without pruning.
                            // Let's use a simpler approach since limit is small.
                            nextChains.add(nextChain);
                        }
                    }
                }
            }
            currentChains = nextChains;
        }

        long sum = 0;
        for (int i = 1; i <= limit; i++) {
            sum += m[i];
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }
}
