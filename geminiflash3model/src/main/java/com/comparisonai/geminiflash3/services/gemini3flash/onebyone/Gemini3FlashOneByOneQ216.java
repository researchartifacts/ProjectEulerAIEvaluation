package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ216 {

    public ResponseDto Question216() {
        ResponseDto responseDto = new ResponseDto();
        int L = 50_000_000;
        
        // Use a sieve-like approach. For each odd prime p, solve 2n^2 - 1 = 0 mod p.
        // n^2 = (p+1)/2 mod p.
        // This is possible if ((p+1)/2 / p) = 1 (Legendre symbol).
        // If possible, solve using Tonelli-Shanks.
        // Then mark all n = k*p +/- n0 as non-prime for 2n^2-1.
        
        boolean[] isComposite = new boolean[L + 1];
        int count = L - 1; // n from 2 to L

        for (int p = 3; p <= 1.5 * L; p += 2) {
            if (!isPrime(p)) continue;
            
            long target = (p + 1L) / 2;
            if (legendre(target, p) != 1) continue;
            
            long n0 = tonelliShanks(target, p);
            long n1 = p - n0;
            
            // For n in [2, L], if 2n^2 - 1 = m*p and m > 1, then not prime.
            // 2n^2 - 1 = p => 2n^2 = p+1 => n = n0 or n = n1.
            // If 2n^2 - 1 is exactly p, it's prime.
            long pVal = p;
            
            for (long n = n0; n <= L; n += p) {
                if (n > 1 && 2 * n * n - 1 > pVal) {
                    if (!isComposite[(int) n]) {
                        isComposite[(int) n] = true;
                        count--;
                    }
                }
            }
            for (long n = n1; n <= L; n += p) {
                if (n > 1 && 2 * n * n - 1 > pVal) {
                    if (!isComposite[(int) n]) {
                        isComposite[(int) n] = true;
                        count--;
                    }
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    private int legendre(long a, int p) {
        return BigInteger.valueOf(a).modPow(BigInteger.valueOf((p - 1) / 2), BigInteger.valueOf(p)).intValue();
    }

    private long tonelliShanks(long n, int p) {
        if (legendre(n, p) != 1) return -1;
        if (p == 2) return n % 2;
        if (p % 4 == 3) return BigInteger.valueOf(n).modPow(BigInteger.valueOf((p + 1) / 4), BigInteger.valueOf(p)).longValue();
        
        long s = 0, q = p - 1;
        while (q % 2 == 0) { q /= 2; s++; }
        
        long z = 2;
        while (legendre(z, p) != p - 1) z++;
        
        long c = BigInteger.valueOf(z).modPow(BigInteger.valueOf(q), BigInteger.valueOf(p)).longValue();
        long r = BigInteger.valueOf(n).modPow(BigInteger.valueOf((q + 1) / 2), BigInteger.valueOf(p)).longValue();
        long t = BigInteger.valueOf(n).modPow(BigInteger.valueOf(q), BigInteger.valueOf(p)).longValue();
        long m = s;
        
        while (t != 1) {
            long i = 1;
            long temp = (t * t) % p;
            while (temp != 1) { temp = (temp * temp) % p; i++; }
            long b = BigInteger.valueOf(c).modPow(BigInteger.valueOf(1L << (m - i - 1)), BigInteger.valueOf(p)).longValue();
            r = (r * b) % p;
            t = (t * b % p * b) % p;
            c = (b * b) % p;
            m = i;
        }
        return r;
    }
}
