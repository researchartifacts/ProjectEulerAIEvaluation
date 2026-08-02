package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ970 {

    public ResponseDto Question970() {
                ResponseDto responseDto = new ResponseDto();
        
        final long MOD = 1000000007L;
        long result = 0;
        
        try {
            for (long i = 1; i <= 1000; i++) {
                long value = (i * (i + 1)) / 2;
                result = (result + value) % MOD;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
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
