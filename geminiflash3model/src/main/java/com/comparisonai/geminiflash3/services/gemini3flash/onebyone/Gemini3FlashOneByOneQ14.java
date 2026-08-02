package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ14 {

    public ResponseDto Question14() {
        ResponseDto responseDto = new ResponseDto();
        long maxLen = 0;
        int result = 0;
        Map<Long, Long> cache = new HashMap<>();
        cache.put(1L, 1L);
        for (int i = 1; i < 1000000; i++) {
            long len = getLen(i, cache);
            if (len > maxLen) {
                maxLen = len;
                result = i;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long getLen(long n, Map<Long, Long> cache) {
        if (cache.containsKey(n)) return cache.get(n);
        long len;
        if (n % 2 == 0) len = 1 + getLen(n / 2, cache);
        else len = 1 + getLen(3 * n + 1, cache);
        cache.put(n, len);
        return len;
    }
}
