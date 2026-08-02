package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ401 {

    public ResponseDto Question401() {
        ResponseDto responseDto = new ResponseDto();
        long n = 1000000000000000L; // 10^15
        long mod = 1000000000L; // 10^9

        long totalSum = 0;
        long inv6 = BigInteger.valueOf(6).modInverse(BigInteger.valueOf(mod)).longValue();

        for (long i = 1, j; i <= n; i = j + 1) {
            long q = n / i;
            j = n / q;

            // Sum of squares from i to j: S(j) - S(i-1)
            // S(x) = x(x+1)(2x+1)/6
            long s_j = sumSquares(j, mod, inv6);
            long s_i_minus_1 = sumSquares(i - 1, mod, inv6);

            long sumInRange = (s_j - s_i_minus_1 + mod) % mod;
            long term = (sumInRange * (q % mod)) % mod;
            totalSum = (totalSum + term) % mod;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long sumSquares(long x, long mod, long inv6) {
        if (x == 0) return 0;
        BigInteger bx = BigInteger.valueOf(x);
        BigInteger bx1 = BigInteger.valueOf(x + 1);
        BigInteger bx2 = BigInteger.valueOf(2 * x + 1);
        BigInteger res = bx.multiply(bx1).multiply(bx2).multiply(BigInteger.valueOf(inv6)).remainder(BigInteger.valueOf(mod));
        return res.longValue();
    }
}
