package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ259 {

    public ResponseDto Question259() {
        ResponseDto responseDto = new ResponseDto();
        
        // All reachable positive integers using 1..9
        Set<Double> reachable = getReachable(1, 9);
        long sum = 0;
        for (double d : reachable) {
            if (d > 0 && Math.abs(d - Math.round(d)) < 1e-9) {
                sum += (long) Math.round(d);
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private Map<String, Set<Double>> memo = new HashMap<>();

    private Set<Double> getReachable(int start, int end) {
        String key = start + "," + end;
        if (memo.containsKey(key)) return memo.get(key);
        
        Set<Double> res = new HashSet<>();
        // Concatenation
        long val = 0;
        for (int i = start; i <= end; i++) val = val * 10 + i;
        res.add((double) val);
        
        for (int i = start; i < end; i++) {
            Set<Double> left = getReachable(start, i);
            Set<Double> right = getReachable(i + 1, end);
            for (double l : left) {
                for (double r : right) {
                    res.add(l + r);
                    res.add(l - r);
                    res.add(l * r);
                    if (r != 0) res.add(l / r);
                }
            }
        }
        memo.put(key, res);
        return res;
    }
}
