package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ334 {

    public ResponseDto Question334() {
        ResponseDto responseDto = new ResponseDto();
        
        int n = 1500;
        long[] b = new long[n + 1];
        long t = 123456;
        for (int i = 1; i <= n; i++) {
            if (t % 2 == 0) {
                t = t / 2;
            } else {
                t = (t / 2) ^ 926252;
            }
            b[i] = (t % 2048) + 1;
        }
        
        // The game: 2 beans from one bowl to neighbors.
        // This is invariant: sum(b_i) is constant.
        // Also sum(i * b_i) is constant.
        // sum(i^2 * b_i) increases by 2 in each move.
        // Final state: each bowl has 0 or 1 bean.
        // Let N = sum(b_i). The final state will have N beans in a row.
        // Let the final beans be at positions x, x+1, ..., x+N-1.
        
        BigInteger sumB = BigInteger.ZERO;
        BigInteger sumIB = BigInteger.ZERO;
        BigInteger sumI2B = BigInteger.ZERO;
        
        for (int i = 1; i <= n; i++) {
            BigInteger bi = BigInteger.valueOf(b[i]);
            BigInteger ii = BigInteger.valueOf(i);
            sumB = sumB.add(bi);
            sumIB = sumIB.add(ii.multiply(bi));
            sumI2B = sumI2B.add(ii.multiply(ii).multiply(bi));
        }
        
        // Final state: N beans at x, x+1, ..., x+N-1.
        // sum(final) = N (matches sumB)
        // sum(i * final) = sum_{j=0}^{N-1} (x+j) = Nx + N(N-1)/2
        // So x = (sumIB - N(N-1)/2) / N.
        
        BigInteger N = sumB;
        BigInteger x = sumIB.subtract(N.multiply(N.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2))).divide(N);
        
        // Final sum(i^2 * final) = sum_{j=0}^{N-1} (x+j)^2
        // = Nx^2 + 2x * N(N-1)/2 + N(N-1)(2N-1)/6
        
        BigInteger sumI2Final = N.multiply(x).multiply(x)
                .add(x.multiply(N).multiply(N.subtract(BigInteger.ONE)))
                .add(N.multiply(N.subtract(BigInteger.ONE)).multiply(N.multiply(BigInteger.valueOf(2)).subtract(BigInteger.ONE)).divide(BigInteger.valueOf(6)));
        
        // Moves = (sumI2Final - sumI2B) / 2
        BigInteger moves = sumI2Final.subtract(sumI2B).divide(BigInteger.valueOf(2));
        
        responseDto.setAnswer(moves.toString());
        return responseDto;
    }
}
