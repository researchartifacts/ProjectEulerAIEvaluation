package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ151 {

    private Map<List<Integer>, Double> memo = new HashMap<>();

    public ResponseDto Question151() {
        ResponseDto responseDto = new ResponseDto();
        // Initial state: one A1 sheet. Supervisor cuts it to get A2, A3, A4, A5.
        // So after the first batch, we have {A2, A3, A4, A5}.
        List<Integer> initial = Arrays.asList(1, 1, 1, 1); // [n2, n3, n4, n5]
        double expected = solve(initial, 14); // 16 batches total, exclude first and last
        
        responseDto.setAnswer(String.format("%.6f", expected));
        return responseDto;
    }

    private double solve(List<Integer> sheets, int remainingBatches) {
        if (remainingBatches == 0) return 0;
        if (memo.containsKey(sheets)) return memo.get(sheets);
        
        int totalSheets = 0;
        for (int s : sheets) totalSheets += s;
        
        double expected = (totalSheets == 1) ? 1.0 : 0.0;
        double currentExpected = 0;
        
        for (int i = 0; i < 4; i++) {
            if (sheets.get(i) > 0) {
                List<Integer> nextSheets = new ArrayList<>(sheets);
                nextSheets.set(i, nextSheets.get(i) - 1);
                for (int j = i + 1; j < 4; j++) {
                    nextSheets.set(j, nextSheets.get(j) + 1);
                }
                currentExpected += (double) sheets.get(i) / totalSheets * solve(nextSheets, remainingBatches - 1);
            }
        }
        
        double result = expected + currentExpected;
        memo.put(sheets, result);
        return result;
    }
}
