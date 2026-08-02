package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ914 {

    public ResponseDto Question914() {
                ResponseDto responseDto = new ResponseDto();
        
        long limit = 1000000L;
        long totalSum = 0;
        
        for (long m = 2; m * m <= limit; m++) {
            for (long n = 1; n < m; n++) {
                long a = m * m - n * n;
                long b = 2 * m * n;
                long c = m * m + n * n;
                
                if (c <= limit) {
                    for (long k = 1; k * c <= limit; k++) {
                        long side1 = a * k;
                        long side2 = b * k;
                        long hyp = c * k;
                        
                        totalSum += side1 + side2 + hyp;
                    }
                }
            }
        }
        
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }
    
    private long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
