package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ209 {

    public ResponseDto Question209() {
        ResponseDto responseDto = new ResponseDto();
        int n = 64;
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int a = (i >> 5) & 1, b = (i >> 4) & 1, c = (i >> 3) & 1;
            int d = (i >> 2) & 1, e = (i >> 1) & 1, f = (i >> 0) & 1;
            int nf = a ^ (b & c);
            next[i] = ((b << 5) | (c << 4) | (d << 3) | (e << 2) | (f << 1) | nf);
        }
        
        long[] lucas = new long[65];
        lucas[0] = 2; lucas[1] = 1;
        for (int i = 2; i <= 64; i++) lucas[i] = lucas[i-1] + lucas[i-2];
        
        boolean[] visited = new boolean[n];
        long ans = 1;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int curr = i, len = 0;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = next[curr];
                    len++;
                }
                ans *= lucas[len];
            }
        }
        responseDto.setAnswer(ans);
        return responseDto;
    }
}
