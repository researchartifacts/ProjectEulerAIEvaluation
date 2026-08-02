package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 94
 */
@Service
public class Haiku45OneByOneQ94 {

    public ResponseDto Question94() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Sum of perimeters of almost equilateral triangles (two equal sides, third differs by 1)
        // with integral area and perimeter <= 1 billion
        // Generated logic to solve the problem:
        long sumPerimeters = 0;
        long maxPerimeter = 1_000_000_000L;
        
        // For almost equilateral triangle: a, a, a±1
        // Using Heron's formula: Area = sqrt(s(s-a)(s-a)(s-b)) where s is semi-perimeter
        // For integer area, discriminant must be a perfect square
        
        // Pattern: for sides (n, n, n-1): perimeter = 3n-1
        // Area formula gives: sqrt((3n-1)(n+1)(n+1)(n-2)/16)
        for (long n = 2; n * 3 - 1 <= maxPerimeter; n++) {
            // Type 1: sides (n, n, n-1)
            long p1 = 3 * n - 1;
            // s = (3n-1)/2, discriminant = ((3n-1)/2) * ((n+1)/2)^2 * ((n-2)/2)
            // Check if area is integer
            long discriminant = (3 * n - 1) * (n + 1) * (n + 1) * (n - 2);
            if (discriminant > 0 && isSquare(discriminant)) {
                double area = Math.sqrt(discriminant) / 4;
                if (area == (long) area && p1 <= maxPerimeter) {
                    sumPerimeters += p1;
                }
            }
        }
        
        // Type 2: sides (n, n, n+1)
        for (long n = 1; n * 3 + 1 <= maxPerimeter; n++) {
            long p2 = 3 * n + 1;
            // s = (3n+1)/2
            long discriminant = (3 * n + 1) * (n - 1) * (n - 1) * (n + 2);
            if (discriminant > 0 && isSquare(discriminant)) {
                double area = Math.sqrt(discriminant) / 4;
                if (area == (long) area && p2 <= maxPerimeter) {
                    sumPerimeters += p2;
                }
            }
        }
        
        Object result = sumPerimeters;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean isSquare(long n) {
        if (n < 0) return false;
        long root = (long) Math.sqrt(n);
        for (long r = Math.max(0, root - 1); r <= root + 1; r++) {
            if (r * r == n) return true;
        }
        return false;
    }
}
