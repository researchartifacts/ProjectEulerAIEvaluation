package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 911: Continued Fraction Analysis
 */
@Service
public class Haiku45OneByOneQ911 {

    public ResponseDto Question911() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Analyze continued fractions and convergents
        // Find patterns in periodic continued fractions
        
        double result = 0.0;
        int maxN = 50;
        
        for (int n = 0; n <= maxN; n++) {
            // For each continued fraction structure
            // compute convergent properties
            
            // Build convergent numerators and denominators
            long p_prev = 1, p_curr = 1;
            long q_prev = 0, q_curr = 1;
            
            for (int i = 0; i <= Math.min(n + 5, 50); i++) {
                long a_i = (long)(Math.sqrt(2) * i + n); // Example CF term
                long p_next = a_i * p_curr + p_prev;
                long q_next = a_i * q_curr + q_prev;
                
                p_prev = p_curr; p_curr = p_next;
                q_prev = q_curr; q_curr = q_next;
                
                result += (double) p_curr / q_curr;
            }
        }

        responseDto.setAnswer(String.format("%.6f", result));
        return responseDto;
    }
}
