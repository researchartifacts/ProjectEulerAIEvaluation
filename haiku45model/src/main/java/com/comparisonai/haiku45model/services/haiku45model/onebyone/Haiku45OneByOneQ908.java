package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ908 {

    public ResponseDto Question908() {
                ResponseDto responseDto = new ResponseDto();
        
        final long MOD = 1000000007L;
        long result = 0;
        
        long fib0 = 0, fib1 = 1;
        for (int i = 0; i < 1000000; i++) {
            long temp = (fib0 + fib1) % MOD;
            fib0 = fib1;
            fib1 = temp;
            result = (result + fib0) % MOD;
        }
        
        responseDto.setAnswer(String.valueOf(result));
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
