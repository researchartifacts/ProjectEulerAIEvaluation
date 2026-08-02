package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ95 {

    public ResponseDto Question95() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] sumDiv = new int[limit + 1];
        for (int i = 1; i <= limit; i++) {
            for (int j = 2 * i; j <= limit; j += i) sumDiv[j] += i;
        }
        int maxLen = 0;
        int minMember = limit;
        boolean[] visited = new boolean[limit + 1];
        for (int i = 1; i <= limit; i++) {
            List<Integer> chain = new ArrayList<>();
            int curr = i;
            while (curr <= limit && !visited[curr]) {
                visited[curr] = true;
                chain.add(curr);
                curr = sumDiv[curr];
            }
            if (curr <= limit) {
                int index = chain.indexOf(curr);
                if (index != -1) {
                    int len = chain.size() - index;
                    if (len > maxLen) {
                        maxLen = len;
                        int min = limit;
                        for (int k = index; k < chain.size(); k++) min = Math.min(min, chain.get(k));
                        minMember = min;
                    }
                }
            }
        }
        responseDto.setAnswer(minMember);
        return responseDto;
    }
}
