package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ604 {

    public ResponseDto Question604() {
        ResponseDto responseDto = new ResponseDto();
        
        long N = 1_000_000_000_000_000_000L;
        
        responseDto.setAnswer(solve(N));
        return responseDto;
    }

    private long solve(long N) {
        long g = 1;
        long currentSum = 0;
        long count = 0;
        
        int limit = 3_000_000; // Estimated g for N=10^18
        int[] phi = new int[limit + 1];
        for (int i = 0; i <= limit; i++) phi[i] = i;
        for (int i = 2; i <= limit; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= limit; j += i) phi[j] -= phi[j] / i;
            }
        }
        
        for (g = 2; g <= limit; g++) {
            long phiG = phi[(int)g];
            long nextSum = currentSum + (g * phiG) / 2;
            if (nextSum > N) break;
            currentSum = nextSum;
            count += phiG;
        }
        
        if (g <= limit) {
            long remaining = N - currentSum;
            count += (2 * remaining) / g;
        }
        
        return count + 1;
    }
}
