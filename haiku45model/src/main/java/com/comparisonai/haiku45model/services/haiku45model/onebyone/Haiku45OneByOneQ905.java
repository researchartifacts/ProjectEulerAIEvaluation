package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ905 {

    public ResponseDto Question905() {
                ResponseDto responseDto = new ResponseDto();
        
        long totalTurns = 0;
        
        for (int a = 1; a <= 7; a++) {
            for (int b = 1; b <= 19; b++) {
                long aHat = 1;
                long bHat = 1;
                
                for (int i = 0; i < b; i++) aHat *= a;
                for (int i = 0; i < a; i++) bHat *= b;
                
                long cHat = aHat + bHat;
                
                int turns = 0;
                boolean[] known = {false, false, false};
                
                while (!known[0] && !known[1] && !known[2]) {
                    if (!known[0] && bHat + cHat == aHat) known[0] = true;
                    else if (!known[0]) turns++;
                    
                    if (!known[1] && aHat + cHat == bHat) known[1] = true;
                    else if (!known[1]) turns++;
                    
                    if (!known[2] && aHat + bHat == cHat) known[2] = true;
                    else if (!known[2]) turns++;
                    
                    if (turns > 100) break;
                }
                
                totalTurns += turns;
            }
        }
        
        responseDto.setAnswer(String.valueOf(totalTurns));
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
