package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ901 {

    public ResponseDto Question901() {
                ResponseDto responseDto = new ResponseDto();
        
        double minTime = Double.MAX_VALUE;
        for (double d = 0.1; d <= 10.0; d += 0.0001) {
            double pSuccess = 1.0 - Math.exp(-d);
            if (pSuccess > 0) {
                double expectedTime = d / pSuccess;
                if (expectedTime < minTime) {
                    minTime = expectedTime;
                }
            }
        }
        
        responseDto.setAnswer(String.format("%.9f", minTime));
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
