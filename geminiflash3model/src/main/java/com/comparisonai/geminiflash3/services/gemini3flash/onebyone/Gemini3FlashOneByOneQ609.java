package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ609 {

    private static final int MOD = 1000000007;

    public ResponseDto Question609() {
        ResponseDto responseDto = new ResponseDto();
        
        int n = 100_000_000;
        int[] pi = new int[n + 1];
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                for (long j = (long) i * i; j <= n; j += i) isNotPrime[(int) j] = true;
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!isNotPrime[i]) count++;
            pi[i] = count;
        }
        
        long[] pk = new long[20]; // k will be small
        for (int i = 1; i <= n; i++) {
            int u = i;
            int k = isNotPrime[u] ? 1 : 0;
            while (true) {
                int nextU = pi[u];
                if (nextU < 1) break;
                if (isNotPrime[nextU]) k++;
                pk[k]++;
                u = nextU;
            }
        }
        
        long ans = 1;
        for (int k = 0; k < 20; k++) {
            if (pk[k] > 0) ans = (ans * (pk[k] % MOD)) % MOD;
        }
        
        responseDto.setAnswer(ans);
        return responseDto;
    }
}
