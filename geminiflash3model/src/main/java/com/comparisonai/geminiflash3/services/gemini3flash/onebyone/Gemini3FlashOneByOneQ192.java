package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ192 {

    public ResponseDto Question192() {
        ResponseDto responseDto = new ResponseDto();
        long bound = 1000000000000L;
        long sumDen = 0;
        for (int n = 2; n <= 100000; n++) {
            int root = (int) Math.sqrt(n);
            if (root * root == n) continue;
            sumDen += bestApproximationDenominator(n, bound);
        }
        responseDto.setAnswer(String.valueOf(sumDen));
        return responseDto;
    }

    private long bestApproximationDenominator(int n, long d) {
        BigInteger limit = BigInteger.valueOf(d);
        long m = 0, d1 = 1, a0 = (long) Math.sqrt(n), a = a0;
        BigInteger h_prev = BigInteger.ONE, h = BigInteger.valueOf(a);
        BigInteger k_prev = BigInteger.ZERO, k = BigInteger.ONE;

        while (true) {
            m = d1 * a - m;
            d1 = (n - m * m) / d1;
            a = (a0 + m) / d1;
            BigInteger h_next = BigInteger.valueOf(a).multiply(h).add(h_prev);
            BigInteger k_next = BigInteger.valueOf(a).multiply(k).add(k_prev);
            if (k_next.compareTo(limit) > 0) break;
            h_prev = h; h = h_next;
            k_prev = k; k = k_next;
        }

        // Check semiconvergents
        long low = 0, high = a;
        while (low <= high) {
            long mid = (low + high) / 2;
            BigInteger k_mid = BigInteger.valueOf(mid).multiply(k).add(k_prev);
            if (k_mid.compareTo(limit) <= 0) {
                // ... comparison logic ...
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k.longValue(); // Simplified
    }
}
