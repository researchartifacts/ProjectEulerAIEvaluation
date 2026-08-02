package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ504 {

    public ResponseDto Question504() {
        ResponseDto responseDto = new ResponseDto();
        // A(a, 0), B(0, b), C(-c, 0), D(0, -d) where 1 <= a,b,c,d <= m.
        // Count how many contain a square number of lattice points strictly inside.
        
        int m = 100;
        int count = 0;
        
        // For each (a, b, c, d):
        // Area = (a+c)*(b+d)/2
        // Boundary points = gcd(a,b) + gcd(b,c) + gcd(c,d) + gcd(d,a)
        // Pick's Theorem: Area = I + B/2 - 1 => I = Area - B/2 + 1
        
        for (int a = 1; a <= m; a++) {
            for (int b = 1; b <= m; b++) {
                for (int c = 1; c <= m; c++) {
                    for (int d = 1; d <= m; d++) {
                        int area2 = (a + c) * (b + d);
                        int boundary = gcd(a, b) + gcd(b, c) + gcd(c, d) + gcd(d, a);
                        int inside = (area2 - boundary + 2) / 2;
                        if (isSquare(inside)) {
                            count++;
                        }
                    }
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }

    private boolean isSquare(int n) {
        if (n < 0) return false;
        int s = (int) Math.sqrt(n);
        return s * s == n;
    }
}
