package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ202 {

    public ResponseDto Question202() {
        ResponseDto responseDto = new ResponseDto();
        long b = 12017639147L;
        long L = (b + 3) / 2;
        
        // Number of m s.t. gcd(m, L) = 1 and m is odd.
        // Actually, the mirrors problem is about coprime m, L and parity.
        // C(n) = sum_{m=1}^{n-1} [gcd(m, n) == 1 and m % 2 != 0]
        
        long result = countCoprimeOdd(L);
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countCoprimeOdd(long n) {
        if (n % 2 == 0) return phi(n);
        else return phi(n); // Both cases are related to phi
    }

    private long phi(long n) {
        long res = n;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                res = res / i * (i - 1);
            }
        }
        if (n > 1) res = res / n * (n - 1);
        return res;
    }
}
