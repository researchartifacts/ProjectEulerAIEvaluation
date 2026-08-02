package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ33 {

    public ResponseDto Question33() {
        ResponseDto responseDto = new ResponseDto();
        int numerator = 1;
        int denominator = 1;
        for (int d = 10; d <= 99; d++) {
            for (int n = 10; n < d; n++) {
                if (n % 10 == 0 || d % 10 == 0) continue;
                if (isCurious(n, d)) {
                    numerator *= n;
                    denominator *= d;
                }
            }
        }
        int g = gcd(numerator, denominator);
        responseDto.setAnswer(denominator / g);
        return responseDto;
    }

    private boolean isCurious(int n, int d) {
        double numer = n;
        double denom = d;
        String nStr = String.valueOf(n);
        String dStr = String.valueOf(d);
        for (int i = 0; i < nStr.length(); i++) {
            if (nStr.charAt(i) == dStr.charAt(i)) {
                if (nStr.length() == 2 && dStr.length() == 2) {
                    int newN = nStr.charAt(1 - i) - '0';
                    int newD = dStr.charAt(1 - i) - '0';
                    if (newD != 0 && (double) newN / newD == numer / denom) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
