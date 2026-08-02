package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ351 {

    private Map<Long, Long> phiSumCache = new HashMap<>();

    public ResponseDto Question351() {
        ResponseDto responseDto = new ResponseDto();
        long n = 100000000L;
        
        long phiSum = getPhiSum(n);
        long result = 3 * n * n + 3 * n - 6 * phiSum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long getPhiSum(long n) {
        if (n <= 1000000) {
            // Simple sieve could be here, but for simplicity in one method:
            return getPhiSumRecursive(n);
        }
        if (phiSumCache.containsKey(n)) {
            return phiSumCache.get(n);
        }
        
        long res = n * (n + 1) / 2;
        for (long i = 2, next; i <= n; i = next + 1) {
            next = n / (n / i);
            res -= (next - i + 1) * getPhiSum(n / i);
        }
        
        phiSumCache.put(n, res);
        return res;
    }

    private long getPhiSumRecursive(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (phiSumCache.containsKey(n)) return phiSumCache.get(n);
        
        long res = n * (n + 1) / 2;
        for (long i = 2, next; i <= n; i = next + 1) {
            next = n / (n / i);
            res -= (next - i + 1) * getPhiSumRecursive(n / i);
        }
        phiSumCache.put(n, res);
        return res;
    }
}
