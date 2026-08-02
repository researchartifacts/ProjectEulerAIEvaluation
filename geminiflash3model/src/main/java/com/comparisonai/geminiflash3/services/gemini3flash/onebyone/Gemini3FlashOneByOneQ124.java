package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ124 {

    private static class Pair implements Comparable<Pair> {
        int n;
        int rad;

        Pair(int n, int rad) {
            this.n = n;
            this.rad = rad;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.rad != other.rad) {
                return Integer.compare(this.rad, other.rad);
            }
            return Integer.compare(this.n, other.n);
        }
    }

    public ResponseDto Question124() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000;
        int target = 10000;
        int[] rads = new int[limit + 1];
        for (int i = 1; i <= limit; i++) rads[i] = 1;

        for (int i = 2; i <= limit; i++) {
            if (rads[i] == 1) {
                for (int j = i; j <= limit; j += i) {
                    rads[j] *= i;
                }
            }
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            list.add(new Pair(i, rads[i]));
        }

        Collections.sort(list);
        responseDto.setAnswer(String.valueOf(list.get(target - 1).n));
        return responseDto;
    }
}
