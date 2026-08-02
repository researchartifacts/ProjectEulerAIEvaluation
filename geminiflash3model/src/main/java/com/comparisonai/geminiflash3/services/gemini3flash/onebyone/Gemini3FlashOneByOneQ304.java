package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ304 {

    public ResponseDto Question304() {
        ResponseDto responseDto = new ResponseDto();
        
        long mod = 1234567891011L;
        long start = 100000000000000L;
        int count = 100000;
        
        long totalSum = 0;
        long current = start;
        
        for (int i = 0; i < count; i++) {
            current = nextPrime(current);
            totalSum = (totalSum + fibonacciMod(current, mod)) % mod;
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long nextPrime(long n) {
        BigInteger b = BigInteger.valueOf(n);
        return b.nextProbablePrime().longValue();
    }

    private long fibonacciMod(long n, long mod) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        long[][] matrix = {{1, 1}, {1, 0}};
        matrix = power(matrix, n - 1, mod);
        return matrix[0][0];
    }

    private long[][] power(long[][] a, long n, long mod) {
        long[][] res = {{1, 0}, {0, 1}};
        while (n > 0) {
            if (n % 2 == 1) res = multiply(res, a, mod);
            a = multiply(a, a, mod);
            n /= 2;
        }
        return res;
    }

    private long[][] multiply(long[][] a, long[][] b, long mod) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    c[i][j] = (c[i][j] + multiplyLong(a[i][k], b[k][j], mod)) % mod;
                }
            }
        }
        return c;
    }
    
    private long multiplyLong(long a, long b, long mod) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).remainder(BigInteger.valueOf(mod)).longValue();
    }
}
