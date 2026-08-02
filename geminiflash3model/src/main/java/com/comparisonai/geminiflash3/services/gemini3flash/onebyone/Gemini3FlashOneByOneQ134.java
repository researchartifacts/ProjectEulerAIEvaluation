package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ134 {

    public ResponseDto Question134() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        boolean[] isPrime = new boolean[limit + 100];
        for (int i = 2; i < isPrime.length; i++) isPrime[i] = true;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = 2 * i; j < isPrime.length; j += i) isPrime[j] = false;
            }
        }

        long totalSum = 0;
        for (int i = 0; i < primes.size() - 1; i++) {
            int p1 = primes.get(i);
            if (p1 < 5) continue;
            if (p1 > limit) break;
            int p2 = primes.get(i + 1);

            long m10 = 10;
            while (m10 <= p1) m10 *= 10;

            // m * p2 = p1 (mod m10)
            // m = p1 * inv(p2, m10) (mod m10)
            BigInteger bp2 = BigInteger.valueOf(p2);
            BigInteger bm10 = BigInteger.valueOf(m10);
            BigInteger invP2 = bp2.modInverse(bm10);
            BigInteger m = BigInteger.valueOf(p1).multiply(invP2).mod(bm10);
            totalSum += m.longValue() * p2;
        }

        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }
}
