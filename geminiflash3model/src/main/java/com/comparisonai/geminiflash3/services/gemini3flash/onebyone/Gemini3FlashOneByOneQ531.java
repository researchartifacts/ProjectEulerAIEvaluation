package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ531 {

    public ResponseDto Question531() {
        ResponseDto responseDto = new ResponseDto();
        int start = 1000000;
        int end = 1005000;
        long totalSum = 0;
        
        int[] phi = new int[end];
        for (int i = 0; i < end; i++) phi[i] = i;
        for (int i = 2; i < end; i++) {
            if (phi[i] == i) {
                for (int j = i; j < end; j += i) phi[j] = phi[j] / i * (i - 1);
            }
        }
        
        for (int n = start; n < end; n++) {
            for (int m = n + 1; m < end; m++) {
                totalSum += g(phi[n], n, phi[m], m);
            }
        }
        
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long g(long a, long n, long b, long m) {
        // x = a mod n, x = b mod m
        // x = n*k + a
        // n*k + a = b mod m => n*k = (b - a) mod m
        long[] gcdResult = extendedGCD(n, m);
        long g = gcdResult[0];
        long x0 = gcdResult[1];
        
        long diff = (b - a) % m;
        if (diff < 0) diff += m;
        
        if (diff % g != 0) return 0;
        
        long mod = n / g * m;
        long k = multiplyMod(diff / g, x0, m / g);
        long res = (n * k + a) % mod;
        if (res < 0) res += mod;
        return res;
    }

    private long[] extendedGCD(long a, long b) {
        if (a == 0) return new long[]{b, 0, 1};
        long[] res = extendedGCD(b % a, a);
        long g = res[0];
        long x1 = res[1];
        long y1 = res[2];
        long x = y1 - (b / a) * x1;
        long y = x1;
        return new long[]{g, x, y};
    }

    private long multiplyMod(long a, long b, long m) {
        long res = 0;
        a %= m;
        while (b > 0) {
            if (b % 2 == 1) res = (res + a) % m;
            a = (a + a) % m;
            b /= 2;
        }
        return res;
    }
}
