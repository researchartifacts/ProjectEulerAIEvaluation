package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 75
 */
@Service
public class Haiku45OneByOneQ75 {

    public ResponseDto Question75() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count wire lengths L <= 1,500,000 that form exactly one integer-sided right triangle
        // Generated logic to solve the problem:
        
        // Use array to count how many triangles have each perimeter
        int[] triangleCount = new int[1500001];
        
        // Generate Pythagorean triples using Euclid's formula
        // For primitive triples: a = m^2 - n^2, b = 2mn, c = m^2 + n^2
        // where m > n, gcd(m,n)=1, m-n is odd
        for (int m = 2; m * m < 1500000; m++) {
            for (int n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    long a = (long)m * m - (long)n * n;
                    long b = 2L * m * n;
                    long c = (long)m * m + (long)n * n;
                    
                    long perimeter = a + b + c;
                    
                    // Also count all multiples of this triple
                    for (long k = 1; k * perimeter <= 1500000; k++) {
                        triangleCount[(int)(k * perimeter)]++;
                    }
                }
            }
        }
        
        long count = 0;
        for (int i = 1; i <= 1500000; i++) {
            if (triangleCount[i] == 1) {
                count++;
            }
        }
        
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
