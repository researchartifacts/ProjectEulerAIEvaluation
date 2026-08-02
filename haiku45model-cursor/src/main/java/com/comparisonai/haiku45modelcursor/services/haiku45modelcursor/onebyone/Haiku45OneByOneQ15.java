package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 15: Lattice paths
 */
@Service
public class Haiku45OneByOneQ15 {

    public ResponseDto Question15() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many routes are there through a 20x20 grid (only right and down)?
        // This is a combinatorial problem: we need to choose 20 "right" moves and 20 "down" moves
        // from a total of 40 moves. This is C(40, 20) = 40! / (20! * 20!)
        
        long routes = binomial(40, 20);
        
        Object result = routes;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long binomial(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        
        return result;
    }
}
