package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ964 {

    public ResponseDto Question964() {
                ResponseDto responseDto = new ResponseDto();
        
        long result = 0;
        final long MOD = 1000000007L;
        
        try {
            int n = 10;
            java.util.List<Integer> perm = new java.util.ArrayList<>();
            for (int i = 1; i <= n; i++) {
                perm.add(i);
            }
            
            for (int iter = 0; iter < 10; iter++) {
                long rank = 1;
                for (int i = 0; i < n; i++) {
                    int smaller = 0;
                    for (int j = i + 1; j < n; j++) {
                        if (perm.get(j) < perm.get(i)) smaller++;
                    }
                    if (i > 0) {
                        rank += smaller * factorial(n - i - 1);
                    }
                }
                result = (result + rank) % MOD;
            }
        } catch (Exception e) {
            responseDto.setAnswer("0");
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
