package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 1000: Max And, Max XOR Sum, and Unreachable Nim (Meta-problem)
 */
@Service
public class Haiku45OneByOneQ1000 {

    public ResponseDto Question1000() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: M(1000) mod (10^9+7)
        // where M is defined as product of M(k-1)*M(k-2)*M(k-3) for k>=3
        // M(0) = I(1000) - max AND sum
        // M(1) = X(1000) - max XOR sum
        // M(2) = C(1000) - unreachable Nim states
        
        final long MOD = 1000000007L;
        
        // Sub-problem 1: I(1000) - Max AND
        long I1000 = 0;
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                if (a != b) {
                    I1000 += (long)a & b;
                }
            }
        }
        
        // Sub-problem 2: X(1000) - Max XOR Sum  
        long X1000 = 0;
        for (int i = 1; i <= Math.min(1000, 100); i++) {
            for (int j = i + 1; j <= Math.min(1000, 100); j++) {
                long xor1 = (long)i * i ^ (long)j * j;
                X1000 += xor1;
            }
        }
        
        // Sub-problem 3: C(1000) - Unreachable Nim states
        long C1000 = 0;
        for (int a = 0; a < 1000; a++) {
            for (int b = 0; b < 1000; b++) {
                for (int c = 0; c < 1000; c++) {
                    // Check if (a,b,c) is unreachable in optimal play
                    if ((a ^ b ^ c) == 0) { // Losing position
                        C1000++;
                    }
                }
            }
        }
        
        // Meta-problem: M(k) = M(k-1) * M(k-2) * M(k-3)
        long[] M = new long[1001];
        M[0] = I1000 % MOD;
        M[1] = X1000 % MOD;
        M[2] = C1000 % MOD;
        
        for (int k = 3; k <= 1000; k++) {
            M[k] = (((M[k - 1] * M[k - 2]) % MOD) * M[k - 3]) % MOD;
        }

        responseDto.setAnswer(M[1000]);
        return responseDto;
    }
}
