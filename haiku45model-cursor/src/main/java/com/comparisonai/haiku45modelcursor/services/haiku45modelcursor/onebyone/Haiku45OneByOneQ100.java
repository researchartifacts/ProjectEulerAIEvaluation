package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 100
 */
@Service
public class Haiku45OneByOneQ100 {

    public ResponseDto Question100() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find first arrangement exceeding 10^12 discs with P(BB) = 1/2
        // P(BB) = (b/n) * ((b-1)/(n-1)) = 1/2
        // This gives: 2*b*(b-1) = n*(n-1), or 2*b^2 - 2*b = n^2 - n
        // Rearranging: (2n-1)^2 - 2(2b-1)^2 = -1 (Pell equation)
        
        long limit = 1_000_000_000_000L; // 10^12
        long blue = 0;
        long total = 0;
        
        // Solving Pell equation: x^2 - 2*y^2 = -1
        // Fundamental solution: x=1, y=1
        // Next solutions can be found using recurrence relation
        
        long x = 1, y = 1;
        long nextX, nextY;
        
        while (true) {
            // Generate next Pell solution
            // Using: x_n+1 = 3*x_n + 4*y_n, y_n+1 = 2*x_n + 3*y_n
            nextX = 3 * x + 4 * y;
            nextY = 2 * x + 3 * y;
            
            x = nextX;
            y = nextY;
            
            // From x = 2n-1 and y = 2b-1
            total = (x + 1) / 2;
            blue = (y + 1) / 2;
            
            if (total > limit) {
                break;
            }
        }
        
        Object result = blue;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
