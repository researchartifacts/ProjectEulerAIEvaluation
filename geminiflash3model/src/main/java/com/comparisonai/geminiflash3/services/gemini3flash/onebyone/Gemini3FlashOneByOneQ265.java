package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ265 {

    public ResponseDto Question265() {
        ResponseDto responseDto = new ResponseDto();
        int n = 5;
        int size = 1 << n;
        long sum = 0;
        
        List<String> sequences = new ArrayList<>();
        findDeBruijn(0, 1, new boolean[size], new int[size], n, sequences);
        
        for (String seq : sequences) {
            sum += Long.parseLong(seq, 2);
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private void findDeBruijn(int current, int length, boolean[] used, int[] path, int n, List<String> res) {
        if (length == (1 << n)) {
            // Check last transitions
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) sb.append(path[i]);
            res.add(sb.toString());
            return;
        }
        
        int mask = (1 << (n - 1)) - 1;
        int nextBase = (current & mask) << 1;
        
        for (int bit = 0; bit < 2; bit++) {
            int nextVal = nextBase | bit;
            if (!used[nextVal]) {
                used[nextVal] = true;
                path[length] = bit;
                findDeBruijn(nextVal, length + 1, used, path, n, res);
                used[nextVal] = false;
            }
        }
    }
}
