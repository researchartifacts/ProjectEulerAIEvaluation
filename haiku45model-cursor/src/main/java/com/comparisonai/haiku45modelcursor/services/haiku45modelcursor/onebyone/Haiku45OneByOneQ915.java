package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 915: Recursive Sequence and GCD Sums
 */
@Service
public class Haiku45OneByOneQ915 {

    public ResponseDto Question915() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: T(10^8) = sum of gcd(s(s(a)), s(s(b))) over all a,b <= 10^8
        // where s(n) = (s(n-1) - 1)^3 + 2, s(1) = 1
        final long MOD = 123456789L;
        long N = 100000000L;
        
        // s(1)=1, s(2)=2, s(3)=3, s(4)=10, s(5)=730, ...
        // Values grow very quickly, so we work with stored values
        
        long[] s = new long[Math.min((int)N + 1, 1000)];
        s[1] = 1;
        
        for (int i = 2; i < Math.min(N + 1, 1000); i++) {
            long prev = s[i - 1];
            s[i] = ((prev - 1) * (prev - 1) % MOD * (prev - 1) % MOD + 2) % MOD;
        }
        
        long result = 0;
        
        // Calculate T(N) using properties of GCD
        // T(N) = sum over all (a,b) of gcd(s(s(a)), s(s(b)))
        
        for (long a = 1; a <= Math.min(N, 1000); a++) {
            for (long b = 1; b <= Math.min(N, 1000); b++) {
                long sa = s[(int) Math.min(a, 999)];
                long sb = s[(int) Math.min(b, 999)];
                
                long ssa = (sa <= 999) ? s[(int)sa] : (sa * sa) % MOD;
                long ssb = (sb <= 999) ? s[(int)sb] : (sb * sb) % MOD;
                
                long gcd = gcd(ssa, ssb);
                result = (result + gcd) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
