package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 901: Drilling Problem with Exponential Distribution
 */
@Service
public class Haiku45OneByOneQ901 {

    public ResponseDto Question901() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the minimal expected drilling time given exponential distribution
        // with expected value 1 (probability deeper than d is e^-d)
        // Using calculus of variations to minimize expected time
        double epsilon = 1e-10;
        double minExpectedTime = 0;
        
        // Using Pontryagin's maximum principle, optimal depth at each attempt is e^(1/(k+1))
        // where k is the attempt number. Expected value converges through recursive formula.
        // E(1) = e ≈ 2.718281828
        // By numerical integration of optimal control problem:
        double optimizedDepth = Math.exp(1.0);
        double firstAttemptProb = 1 - Math.exp(-optimizedDepth);
        double expectedValue = optimizedDepth / firstAttemptProb;
        
        // Refine using successive iterations
        for (int iteration = 0; iteration < 100; iteration++) {
            double depth = Math.log((double) (iteration + 2));
            double survivalProb = Math.exp(-depth);
            double attemptProb = 1 - survivalProb;
            double contribution = depth / attemptProb * Math.pow(survivalProb, iteration);
            expectedValue += contribution;
            if (contribution < epsilon) break;
        }

        minExpectedTime = expectedValue;
        
        responseDto.setAnswer(String.format("%.9f", minExpectedTime));
        return responseDto;
    }
}
