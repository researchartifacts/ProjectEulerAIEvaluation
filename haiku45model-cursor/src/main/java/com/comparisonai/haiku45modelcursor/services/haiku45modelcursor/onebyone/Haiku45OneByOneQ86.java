package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 86
 */
@Service
public class Haiku45OneByOneQ86 {

    public ResponseDto Question86() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find smallest M such that cuboids with integer dimensions up to M x M x M 
        // have more than 1 million with integer shortest path distance
        int count = 0;
        int M = 1;
        
        while (count <= 1000000) {
            M++;
            for (int a = 1; a <= M; a++) {
                for (int b = a; b <= M; b++) {
                    for (int c = b; c <= M; c++) {
                        // Check 3 possible shortest paths when unfolding the cuboid:
                        // Path 1: a^2 + (b+c)^2
                        // Path 2: b^2 + (a+c)^2  
                        // Path 3: c^2 + (a+b)^2
                        
                        if (isPerfectSquare((long)a * a + (long)(b + c) * (b + c)) ||
                            isPerfectSquare((long)b * b + (long)(a + c) * (a + c)) ||
                            isPerfectSquare((long)c * c + (long)(a + b) * (a + b))) {
                            count++;
                        }
                    }
                }
            }
        }
        
        Object result = M;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean isPerfectSquare(long n) {
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
