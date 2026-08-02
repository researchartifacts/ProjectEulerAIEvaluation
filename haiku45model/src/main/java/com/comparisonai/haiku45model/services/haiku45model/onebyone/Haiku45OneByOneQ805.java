package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ805 {

    public ResponseDto Question805() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007L;
        long result = 0;

        for (long m = 1; m <= 200; m++) {
            for (long v = 1; v <= m; v++) {
                if (gcd(m, v) == 1) {
                    long u = m;
                    long nValue = findN(u, v);
                    if (nValue > 0) {
                        result = (result + nValue) % MOD;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findN(long u, long v) {
        for (long n = 1; n <= 10000000; n++) {
            long r = (u * u * u * n) / (v * v * v);
            if ((u * u * u * n) % (v * v * v) == 0) {
                long shifted = shiftLeftmost(n);
                if (shifted == r * n) {
                    return n;
                }
            }
        }
        return 0;
    }

    private long shiftLeftmost(long n) {
        String s = String.valueOf(n);
        if (s.length() == 1) return n;
        return Long.parseLong(s.substring(1) + s.charAt(0));
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
