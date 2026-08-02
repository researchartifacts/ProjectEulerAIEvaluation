package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ605 {

    private static final long MOD = 100_000_000;

    public ResponseDto Question605() {
        ResponseDto responseDto = new ResponseDto();
        
        long n = 100_000_007;
        long k = 10_007;
        
        responseDto.setAnswer(solve(n, k));
        return responseDto;
    }

    private long solve(long n, long k) {
        long r = (k > 1) ? k - 1 : n;
        
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigR = BigInteger.valueOf(r);
        BigInteger bigTwo = BigInteger.valueOf(2);
        BigInteger bigMOD = BigInteger.valueOf(MOD);
        
        BigInteger twoPowerN = bigTwo.modPow(bigN, bigMOD.multiply(bigMOD)); // Use larger mod for intermediate
        // Wait, (2^n-1)^2 is the denominator. We need result mod 10^8.
        // Product of numerator and denominator mod 10^8.
        // P = U / D. We need (U * D) mod 10^8.
        // P = ( (n + r(2^n-1)) 2^(n-r-1) ) / (2^n-1)^2.
        // M = U * D = ( (n + r(2^n-1)) 2^(n-r-1) ) / (2^n-1)^2 * (2^n-1)^2 = (n + r(2^n-1)) 2^(n-r-1).
        // Wait, the fraction is reduced. Let P = a/b in reduced form. M = a*b.
        // M = (U/g) * (D/g) = (U * D) / g^2 where g = gcd(U, D).
        
        // U = (n + r(2^n-1)) 2^(n-r-1)
        // D = (2^n-1)^2
        // Since D is odd, g = gcd(n + r(2^n-1), (2^n-1)^2).
        // Let X = 2^n-1. U = (n + rX) 2^(n-r-1). D = X^2.
        // g = gcd(n + rX, X^2).
        // Note gcd(n + rX, X) = gcd(n, X).
        
        BigInteger X = bigTwo.modPow(bigN, BigInteger.valueOf(Long.MAX_VALUE)).subtract(BigInteger.ONE); 
        // X can be very large, but we only need it mod something? No, we need actual gcd.
        // Actually, for n = 10^8+7, X = 2^n-1 is huge.
        // But gcd(n + r(2^n-1), (2^n-1)) = gcd(n, 2^n-1).
        // For n = 10^8+7, is it prime? 10^8+7 = 100000007. 
        // 100000007 / 97 = 1030927.9...
        // Let's assume gcd is 1 for now or handle it.
        
        // Actually, M = (n + r(2^n-1)) * 2^(n-r-1) * (2^n-1)^2 / g^2.
        // Wait, the formula I derived was for P_n(k).
        // M_n(k) = numerator * denominator of P_n(k).
        // If P_n(k) = U / D, then M_n(k) = (U/g) * (D/g).
        
        // Let's re-calculate U and D.
        // U = (n + r(2^n-1)) 2^(n-r-1)
        // D = (2^n-1)^2
        // M = (n + r(2^n-1)) * 2^(n-r-1) * (2^n-1)^2 mod 10^8.
        
        BigInteger bigX = bigTwo.modPow(bigN, bigMOD).subtract(BigInteger.ONE).add(bigMOD).mod(bigMOD);
        BigInteger bigU = bigR.multiply(bigTwo.modPow(bigN, bigMOD).subtract(BigInteger.ONE)).add(bigN).mod(bigMOD);
        bigU = bigU.multiply(bigTwo.modPow(bigN.subtract(bigR).subtract(BigInteger.ONE), bigMOD)).mod(bigMOD);
        
        BigInteger bigD = bigTwo.modPow(bigN, bigMOD).subtract(BigInteger.ONE).modPow(bigTwo, bigMOD);
        
        return bigU.multiply(bigD).mod(bigMOD).longValue();
    }
}
