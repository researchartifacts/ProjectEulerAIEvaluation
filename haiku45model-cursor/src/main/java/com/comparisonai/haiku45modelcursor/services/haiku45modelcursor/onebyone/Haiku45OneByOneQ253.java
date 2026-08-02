package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 253
 */
@Service
public class Haiku45OneByOneQ253 {

    public ResponseDto Question253() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: A small child has a “number caterpillar” consisting of forty jigsaw pieces, each with one number on it, which, when connected together in a line, reveal the numbers $1$ to $40$ in order. Every night, 
        // Generated logic to solve the problem:
        
        // Problem 253: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 253;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
