package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ225 {

    public ResponseDto Question225() {
        ResponseDto responseDto = new ResponseDto();
        int target = 124;
        int found = 0;
        int m = 27;
        
        while (found < target) {
            if (!dividesTribonacci(m)) {
                found++;
                if (found == target) break;
            }
            m += 2;
        }
        
        responseDto.setAnswer(m);
        return responseDto;
    }

    private boolean dividesTribonacci(int m) {
        int t1 = 1, t2 = 1, t3 = 1;
        Set<String> seen = new HashSet<>();
        while (true) {
            int t4 = (t1 + t2 + t3) % m;
            if (t4 == 0) return true;
            String state = t2 + "," + t3 + "," + t4;
            if (seen.contains(state)) return false;
            seen.add(state);
            t1 = t2; t2 = t3; t3 = t4;
        }
    }
}
