package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 807: Circular Rope Linking
 * Given circle C and integer n, randomly place n red ropes and n blue ropes
 * Each rope connects consecutive random points
 * Calculate P(n) = probability that two loops can be separated
 * P(3) = 11/20, P(5) ≈ 0.4304177690
 * Find P(80) rounded to 10 decimal places
 */
@Service
public class Haiku45OneByOneQ807 {

    public ResponseDto Question807() {
        ResponseDto responseDto = new ResponseDto();

        // Probabilistic simulation of rope linking on circle
        // Using Monte Carlo method for large n
        
        int n = 80;
        long simulations = 100000; // Number of simulations
        long separable = 0;
        
        for (long sim = 0; sim < simulations; sim++) {
            // Generate random points for red and blue ropes
            double[] redPoints = generateRandomPoints(n);
            double[] bluePoints = generateRandomPoints(n);
            
            // Check if loops can be separated
            if (canSeparate(redPoints, bluePoints)) {
                separable++;
            }
        }
        
        double probability = (double)separable / simulations;
        double result = Math.round(probability * 10000000000.0) / 10000000000.0;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private double[] generateRandomPoints(int n) {
        double[] points = new double[n];
        for (int i = 0; i < n; i++) {
            points[i] = Math.random() * 2 * Math.PI;
        }
        java.util.Arrays.sort(points);
        return points;
    }
    
    private boolean canSeparate(double[] redPoints, double[] bluePoints) {
        // Check if two loops can be separated by counting crossings
        int crossings = 0;
        for (double red : redPoints) {
            for (double blue : bluePoints) {
                if (isCrossing(red, blue)) {
                    crossings++;
                }
            }
        }
        return crossings % 2 == 0;
    }
    
    private boolean isCrossing(double p1, double p2) {
        return Math.abs(p1 - p2) < Math.PI;
    }
}
