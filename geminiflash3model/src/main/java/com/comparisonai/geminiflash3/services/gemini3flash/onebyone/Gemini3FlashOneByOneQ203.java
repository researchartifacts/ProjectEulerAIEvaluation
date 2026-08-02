package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ203 {

    public ResponseDto Question203() {
        ResponseDto responseDto = new ResponseDto();
        int maxRow = 50;
        Set<Long> distinct = new HashSet<>();
        long[][] tri = new long[maxRow + 1][maxRow + 1];
        
        for (int n = 0; n <= maxRow; n++) {
            tri[n][0] = 1;
            distinct.add(1L);
            for (int k = 1; k <= n; k++) {
                tri[n][k] = tri[n-1][k-1] + tri[n-1][k];
                distinct.add(tri[n][k]);
            }
        }
        
        long sum = 0;
        for (long val : distinct) {
            if (isSquareFree(val)) sum += val;
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isSquareFree(long n) {
        if (n % 4 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % (i * i) == 0) return false;
        }
        return true;
    }
}
