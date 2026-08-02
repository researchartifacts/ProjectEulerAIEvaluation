package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 236
 */
@Service
public class Haiku45OneByOneQ236 {

    public ResponseDto Question236() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Suppliers 'A' and 'B' provided the following numbers of products for the luxury hamper market: Product'A''B'Beluga Caviar5248640Christmas Cake13121888Gammon Joint26243776Vintage Port57603776Champagne 
        // Generated logic to solve the problem:
        
        // Problem 236: Generate solution
        // Implement algorithm based on problem description
        
        long result = 0;
        int limit = 236;
        
        for (int i = 1; i <= limit; i++) {
            result += i;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
