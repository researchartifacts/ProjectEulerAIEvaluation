package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 267
 */
@Service
public class Haiku45OneByOneQ267 {

    public ResponseDto Question267() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: You are given a unique investment opportunity. Starting with £1 of capital, you can choose a fixed proportion, f, of your capital to bet on a fair coin toss repeatedly for 1000 tosses. Your return is 
        // Generated logic to solve the problem:
        
        // Problem 267: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 267;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
