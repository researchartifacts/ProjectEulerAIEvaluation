package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 493: Expected Distinct Colors
 * 70 colored balls (10 each of 7 colors) in an urn
 * Expected distinct colors in 20 randomly picked balls
 */
@Service
public class Haiku45OneByOneQ493 {

    public ResponseDto Question493() {
        ResponseDto responseDto = new ResponseDto();

        // Expected value of distinct colors
        // Probability that a specific color appears at least once
        // = 1 - P(color doesn't appear)
        // = 1 - C(60,20)/C(70,20)
        
        double expectedColors = 0.0;
        int totalBalls = 70;
        int ballsPerColor = 10;
        int numColors = 7;
        int ballsDrawn = 20;
        
        // For each color, calculate probability it appears
        for (int i = 0; i < numColors; i++) {
            double probColorDoesntAppear = combination(totalBalls - ballsPerColor, ballsDrawn) 
                                          / combination(totalBalls, ballsDrawn);
            double probColorAppears = 1.0 - probColorDoesntAppear;
            expectedColors += probColorAppears;
        }

        // Round to 9 decimal places
        double result = Math.round(expectedColors * 1_000_000_000) / 1_000_000_000.0;

        responseDto.setAnswer(String.format("%.9f", result));
        return responseDto;
    }

    private double combination(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n - k) k = n - k;
        
        double result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
}
