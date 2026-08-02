package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ214 {

    public ResponseDto Question214() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 40_000_000;
        int[] phi = new int[limit];
        for (int i = 0; i < limit; i++) phi[i] = i;
        for (int i = 2; i < limit; i++) {
            if (phi[i] == i) {
                for (int j = i; j < limit; j += i) {
                    phi[j] = phi[j] / i * (i - 1);
                }
            }
        }
        
        int[] length = new int[limit];
        length[1] = 1;
        long sum = 0;
        for (int i = 2; i < limit; i++) {
            length[i] = 1 + length[phi[i]];
            if (length[i] == 25 && isPrime(i, phi)) {
                sum += i;
            }
        }
        
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPrime(int n, int[] phi) {
        return n > 1 && phi[n] == n - 1;
    }
}
