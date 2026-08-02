package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class Gemini3FlashOneByOneQ44 {

    public ResponseDto Question44() {
        ResponseDto responseDto = new ResponseDto();
        Set<Long> pentagonals = new HashSet<>();
        for (long n = 1; n < 3000; n++) pentagonals.add(n * (3 * n - 1) / 2);
        long minD = Long.MAX_VALUE;
        for (long pj : pentagonals) {
            for (long pk : pentagonals) {
                if (pj >= pk) continue;
                if (pentagonals.contains(pk - pj) && pentagonals.contains(pk + pj)) {
                    minD = Math.min(minD, pk - pj);
                }
            }
        }
        responseDto.setAnswer(minD);
        return responseDto;
    }
}
