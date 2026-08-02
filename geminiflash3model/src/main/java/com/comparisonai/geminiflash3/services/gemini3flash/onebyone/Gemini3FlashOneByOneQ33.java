package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ33 {

    public ResponseDto Question33() {
        ResponseDto responseDto = new ResponseDto();
        int numProd = 1;
        int denProd = 1;
        for (int d = 10; d < 100; d++) {
            for (int n = 10; n < d; n++) {
                int n1 = n / 10, n2 = n % 10;
                int d1 = d / 10, d2 = d % 10;
                if (n2 == d1 && n * d2 == d * n1 && n2 != 0) {
                    numProd *= n;
                    denProd *= d;
                }
            }
        }
        responseDto.setAnswer(denProd / gcd(numProd, denProd));
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int t = a; a = b; b = t;
        }
        return a;
    }
}
