package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ684 {

    private static final long MOD = 1000000007;

    public ResponseDto Question684() {
        ResponseDto responseDto = new ResponseDto();

        // s(n) = smallest number with digit sum n.
        // s(n) = (n%9 + 1) * 10^(n/9) - 1.
        // S(k) = sum_{n=1}^k s(n).
        // Find sum_{i=2}^90 S(f_i) mod 10^9+7.

        BigInteger totalSum = BigInteger.ZERO;
        long[] fib = new long[91];
        fib[0] = 0; fib[1] = 1;
        for (int i = 2; i <= 90; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            totalSum = totalSum.add(calculateS(fib[i]));
        }

        responseDto.setAnswer(totalSum.mod(BigInteger.valueOf(MOD)).toString());
        return responseDto;
    }

    private BigInteger calculateS(long k) {
        // S(k) = sum_{n=1}^k s(n)
        // s(n) = (n%9 + 1) * 10^(n/9) - 1.
        // S(k) = sum_{n=1}^k ((n%9 + 1) * 10^(n/9) - 1).
        // This can be calculated using geometric series sum.
        
        long q = k / 9;
        long r = k % 9;
        
        // Sum for n = 0 to 9q-1:
        // sum_{j=0}^{q-1} sum_{i=0}^8 ((i+1)*10^j - 1)
        // = sum_{j=0}^{q-1} (45*10^j - 9) = 45 * (10^q - 1)/9 - 9q = 5*(10^q - 1) - 9q.
        
        // Sum for n = 9q to 9q+r:
        // sum_{i=0}^r ((i+1)*10^q - 1) = (r+1)(r+2)/2 * 10^q - (r+1).
        
        // Note: n starts from 1, but s(0) is not defined. S(k) = sum_{n=1}^k s(n).
        // The above formula handles n=0 if we adjust.
        
        BigInteger bigK = BigInteger.valueOf(k);
        BigInteger bigQ = BigInteger.valueOf(q);
        BigInteger bigR = BigInteger.valueOf(r);
        BigInteger ten = BigInteger.TEN;
        
        BigInteger term1 = ten.pow((int)q).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(5)).subtract(bigQ.multiply(BigInteger.valueOf(9)));
        BigInteger term2 = BigInteger.valueOf((r + 1) * (r + 2) / 2).multiply(ten.pow((int)q)).subtract(BigInteger.valueOf(r + 1));
        
        // Subtract s(0) = (0+1)*10^0 - 1 = 0.
        return term1.add(term2);
    }
}
