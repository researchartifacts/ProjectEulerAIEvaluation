package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ188 {

    public ResponseDto Question188() {
        ResponseDto responseDto = new ResponseDto();
        long result = tetrationMod(1777, 1855, 100000000);
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    private long tetrationMod(long a, long b, long m) {
        if (m == 1) return 0;
        if (b == 1) return a % m;
        long phi = getPhi(m);
        long exp = tetrationMod(a, b - 1, phi);
        return power(a, exp + phi, m);
    }

    private long getPhi(long n) {
        long result = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }

    private long power(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if (b % 2 == 1) res = (BigInteger.valueOf(res).multiply(BigInteger.valueOf(a)).remainder(BigInteger.valueOf(m))).longValue();
            a = (BigInteger.valueOf(a).multiply(BigInteger.valueOf(a)).remainder(BigInteger.valueOf(m))).longValue();
            b /= 2;
        }
        return res;
    }
}
