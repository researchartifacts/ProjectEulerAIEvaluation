package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ243 {

    public ResponseDto Question243() {
        ResponseDto responseDto = new ResponseDto();
        double target = 15499.0 / 94744.0;
        
        long d = 1;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        double phi_d_ratio = 1.0;
        
        for (int p : primes) {
            d *= p;
            phi_d_ratio *= (1.0 - 1.0 / p);
            for (int k = 1; k < p; k++) {
                long currentD = d / p * k;
                if (currentD > 1 && (double) getPhi(currentD) / (currentD - 1) < target) {
                    responseDto.setAnswer(currentD);
                    return responseDto;
                }
            }
            if ((double) (d * phi_d_ratio) / (d - 1) < target) {
                // Find smallest multiple
                for (int m = 1; m < 100; m++) {
                    long res = d * m;
                    if ((double) getPhi(res) / (res - 1) < target) {
                        responseDto.setAnswer(res);
                        return responseDto;
                    }
                }
            }
        }
        
        return responseDto;
    }

    private long getPhi(long n) {
        long res = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                res = res / i * (i - 1);
            }
        }
        if (n > 1) res = res / n * (n - 1);
        return res;
    }
}
