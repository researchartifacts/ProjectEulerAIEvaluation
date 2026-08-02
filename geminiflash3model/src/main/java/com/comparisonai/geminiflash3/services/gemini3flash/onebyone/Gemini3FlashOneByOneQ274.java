package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ274 {

    public ResponseDto Question274() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 10_000_000;
        long totalSum = 0;
        boolean[] isPrime = new boolean[limit];
        Arrays.fill(isPrime, true);
        for (int p = 2; p < limit; p++) {
            if (isPrime[p]) {
                if (p % 2 != 0 && p % 5 != 0) {
                    // m = 10^-1 mod p
                    totalSum += modInverse(10, p);
                }
                for (int i = p * 2; i < limit; i += p) isPrime[i] = false;
            }
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long modInverse(long a, long m) {
        return BigInteger.valueOf(a).modInverse(BigInteger.valueOf(m)).longValue();
    }
}
