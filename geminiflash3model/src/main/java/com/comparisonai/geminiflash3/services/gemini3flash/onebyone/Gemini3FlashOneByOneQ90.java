package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ90 {

    public ResponseDto Question90() {
        ResponseDto responseDto = new ResponseDto();
        List<List<Integer>> combinations = new ArrayList<>();
        genComb(0, 0, new ArrayList<>(), combinations);
        int count = 0;
        for (int i = 0; i < combinations.size(); i++) {
            for (int j = i; j < combinations.size(); j++) {
                if (canDisplayAll(combinations.get(i), combinations.get(j))) count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private void genComb(int start, int count, List<Integer> current, List<List<Integer>> combinations) {
        if (count == 6) {
            combinations.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            genComb(i + 1, count + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

    private boolean canDisplayAll(List<Integer> c1, List<Integer> c2) {
        int[][] squares = {{0, 1}, {0, 4}, {0, 9}, {1, 6}, {2, 5}, {3, 6}, {4, 9}, {6, 4}, {8, 1}};
        for (int[] sq : squares) {
            if (!((has(c1, sq[0]) && has(c2, sq[1])) || (has(c1, sq[1]) && has(c2, sq[0])))) return false;
        }
        return true;
    }

    private boolean has(List<Integer> c, int d) {
        if (c.contains(d)) return true;
        if (d == 6 && c.contains(9)) return true;
        if (d == 9 && c.contains(6)) return true;
        return false;
    }
}
