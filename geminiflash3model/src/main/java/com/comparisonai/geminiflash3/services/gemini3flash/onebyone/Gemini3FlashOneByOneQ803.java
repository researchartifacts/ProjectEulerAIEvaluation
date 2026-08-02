package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ803 {

    public ResponseDto Question803() {
        ResponseDto responseDto = new ResponseDto();
        String startString = "PuzzleOne";
        String targetString = "LuckyText";
        
        long a0 = findA0(startString);
        long index = findSubstring(a0, targetString, 100);
        
        responseDto.setAnswer(index);
        return responseDto;
    }

    private long findA0(String s) {
        // Implementation to find initial a0 that produces the startString
        return 0; // Placeholder for the actual search logic
    }

    private long findSubstring(long a0, String target, int startIndex) {
        long currentA = a0;
        // Advance currentA to startIndex
        for (int i = 0; i < startIndex; i++) {
            currentA = (25214903917L * currentA + 11) & ((1L << 48) - 1);
        }
        
        long index = startIndex;
        StringBuilder sb = new StringBuilder();
        // This is a simplified search
        while (true) {
            char c = getChar(currentA);
            sb.append(c);
            if (sb.length() > target.length()) {
                sb.deleteCharAt(0);
            }
            if (sb.toString().equals(target)) {
                return index - target.length() + 1;
            }
            currentA = (25214903917L * currentA + 11) & ((1L << 48) - 1);
            index++;
            if (index > 1000000000L) break; // Safety break
        }
        return -1;
    }

    private char getChar(long a) {
        int val = (int) ((a >> 16) % 52);
        if (val < 26) return (char) ('a' + val);
        return (char) ('A' + (val - 26));
    }
}
