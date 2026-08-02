package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ187 {

    public ResponseDto Question187() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 100000000;
        boolean[] isPrime = new boolean[limit / 2 + 1];
        for (int i = 2; i < isPrime.length; i++) isPrime[i] = true;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if ((long) i * i < isPrime.length) {
                    for (int j = i * i; j < isPrime.length; j += i) isPrime[j] = false;
                }
            }
        }

        long count = 0;
        for (int i = 0; i < primes.size(); i++) {
            int p = primes.get(i);
            if ((long) p * p >= limit) break;
            for (int j = i; j < primes.size(); j++) {
                if ((long) p * primes.get(j) < limit) {
                    count++;
                } else {
                    break;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
