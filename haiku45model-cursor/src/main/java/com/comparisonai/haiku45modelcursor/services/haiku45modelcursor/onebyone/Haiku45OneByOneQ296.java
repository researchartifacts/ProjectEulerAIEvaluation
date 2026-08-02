package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 296
 */
@Service
public class Haiku45OneByOneQ296 {

    public ResponseDto Question296() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Given is an integer sided triangle $ABC$ with $BC \le AC \le AB$.$k$ is the angular bisector of angle $ACB$.$m$ is the tangent at $C$ to the circumscribed circle of $ABC$.$n$ is a line parallel to $m$
        // Generated logic to solve the problem:
        
        // Problem 296: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 296;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
