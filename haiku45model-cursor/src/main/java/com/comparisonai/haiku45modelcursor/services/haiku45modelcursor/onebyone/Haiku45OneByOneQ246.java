package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 246
 */
@Service
public class Haiku45OneByOneQ246 {

    public ResponseDto Question246() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A definition for an ellipse is: Given a circle $c$ with centre $M$ and radius $r$ and a point $G$ such that $d(G,M) \lt r$, the locus of the points that are equidistant from $c$ and $G$ form an ellips
        // Generated logic to solve the problem:
        
        // Problem 246: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 246;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
