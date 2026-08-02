package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ61 {

    public ResponseDto Question61() {
        ResponseDto responseDto = new ResponseDto();
        List<List<Integer>> polygonal = new ArrayList<>();
        for (int i = 0; i < 6; i++) polygonal.add(new ArrayList<>());
        for (int n = 1; ; n++) {
            int[] vals = {
                n * (n + 1) / 2, n * n, n * (3 * n - 1) / 2,
                n * (2 * n - 1), n * (5 * n - 3) / 2, n * (3 * n - 2)
            };
            boolean anyIn = false;
            for (int i = 0; i < 6; i++) {
                if (vals[i] >= 1000 && vals[i] <= 9999) {
                    polygonal.get(i).add(vals[i]);
                    anyIn = true;
                }
            }
            if (!anyIn && n > 200) break;
        }
        List<Integer> result = new ArrayList<>();
        findCycle(polygonal, new boolean[6], 0, 0, result);
        long sum = 0;
        for (int val : result) sum += val;
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean findCycle(List<List<Integer>> polygonal, boolean[] used, int last, int count, List<Integer> result) {
        if (count == 6) {
            if (result.get(5) % 100 == result.get(0) / 100) return true;
            return false;
        }
        for (int i = 0; i < 6; i++) {
            if (used[i]) continue;
            for (int val : polygonal.get(i)) {
                if (count == 0 || val / 100 == last % 100) {
                    used[i] = true;
                    result.add(val);
                    if (findCycle(polygonal, used, val, count + 1, result)) return true;
                    result.remove(result.size() - 1);
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
