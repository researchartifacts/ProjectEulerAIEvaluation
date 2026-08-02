package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ193 {

    public ResponseDto Question193() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1L << 50;
        int sqrtLimit = (int) Math.sqrt(limit);
        byte[] mu = new byte[sqrtLimit + 1];
        mu[1] = 1;
        boolean[] isPrime = new boolean[sqrtLimit + 1];
        for (int i = 2; i <= sqrtLimit; i++) isPrime[i] = true;
        for (int i = 2; i <= sqrtLimit; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= sqrtLimit; j += i) {
                    if (j > i) isPrime[j] = false;
                    if ((j / i) % i == 0) mu[j] = 0;
                    else mu[j] = (byte) (mu[j] == 0 ? -1 : -mu[j]);
                }
            }
        }

        long count = 0;
        for (int i = 1; i <= sqrtLimit; i++) {
            if (mu[i] == 0) continue;
            long term = limit / ((long) i * i);
            if (mu[i] == 1) count += term;
            else count -= term;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
