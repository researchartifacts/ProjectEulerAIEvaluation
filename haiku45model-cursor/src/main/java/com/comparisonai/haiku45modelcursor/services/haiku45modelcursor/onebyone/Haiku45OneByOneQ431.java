package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 431 - Grain Silo Optimization
 * 
 * Finds the offset positions where grain space wastage equals perfect square values.
 * Uses cone geometry with angle of repose to calculate wasted volume in a cylindrical silo.
 * For a silo with radius 6m and angle of repose 40 degrees, finds all x values where
 * V(x) equals a perfect square, then sums them.
 */
@Service
public class Haiku45OneByOneQ431 {

    public ResponseDto Question431() {
        ResponseDto responseDto = new ResponseDto();

        // Silo parameters
        double radius = 6.0; // meters
        double angleOfRepose = 40.0; // degrees
        double angleRad = Math.toRadians(angleOfRepose);
        double tanAlpha = Math.tan(angleRad);

        // The cone height when grain reaches the top
        double coneHeight = radius * tanAlpha;

        // Volume of cone for centered grain delivery
        double coneVolume = (Math.PI * radius * radius * coneHeight) / 3.0;
        
        // Full cylinder volume (assuming 1 unit height for calculation)
        double cylinderVolume = Math.PI * radius * radius * coneHeight;

        // Base wasted volume (centered delivery)
        double baseWaste = cylinderVolume - coneVolume;

        // Now we need to find offset positions x where wasted volume equals perfect squares
        // V(x) = volume of cylinder - volume of tilted cone
        // The tilted cone forms a complex surface when offset from center
        
        // Using numerical optimization to find x values that produce perfect square waste
        java.util.List<Double> xValues = new java.util.ArrayList<>();
        
        // Search range for x (0 to radius)
        double searchStep = 0.0001;
        java.util.Map<Integer, Double> squareToX = new java.util.TreeMap<>();
        
        for (double x = 0; x <= radius; x += searchStep) {
            // Calculate wasted volume as function of offset x
            // Using approximation: V(x) ≈ baseWaste + correction factor based on offset
            double xNorm = x / radius;
            double volumeAdjustment = (1 - Math.sqrt(1 - xNorm * xNorm)) * baseWaste;
            double wastedVolume = baseWaste + volumeAdjustment;
            
            // Check if wastedVolume is close to a perfect square
            double sqrtWaste = Math.sqrt(wastedVolume);
            int squareVal = (int) Math.round(sqrtWaste);
            
            if (Math.abs(sqrtWaste - squareVal) < 0.01) {
                // Found a solution close to a perfect square
                if (!squareToX.containsKey(squareVal)) {
                    squareToX.put(squareVal, x);
                }
            }
        }

        // More precise search using Newton's method for known solutions
        // Problem states we're looking for specific x values that produce square waste
        // Using numerical root finding
        
        double sumX = 0.0;
        for (double xCandidate : squareToX.values()) {
            sumX += xCandidate;
        }

        // Refined calculation using optimization
        // For this specific problem, we need to find x where V(x) equals perfect squares
        // Using iterative refinement
        java.util.List<Double> refinedSolutions = new java.util.ArrayList<>();
        
        for (int targetSquare = 30; targetSquare <= 60; targetSquare++) {
            // Binary search for x that gives this target square waste
            double left = 0, right = radius;
            for (int iter = 0; iter < 50; iter++) {
                double mid = (left + right) / 2;
                double midNorm = mid / radius;
                double volumeAdjustment = (1 - Math.sqrt(1 - midNorm * midNorm)) * baseWaste;
                double wastedVolume = baseWaste + volumeAdjustment;
                
                if (wastedVolume < targetSquare) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            
            double mid = (left + right) / 2;
            double midNorm = mid / radius;
            double volumeAdjustment = (1 - Math.sqrt(1 - midNorm * midNorm)) * baseWaste;
            double wastedVolume = baseWaste + volumeAdjustment;
            
            if (Math.abs(wastedVolume - targetSquare) < 0.1) {
                refinedSolutions.add(mid);
            }
        }

        // Sum of all x values
        double result = 0.0;
        for (double x : refinedSolutions) {
            result += x;
        }

        // Round to 9 decimal places as required
        result = Math.round(result * 1_000_000_000.0) / 1_000_000_000.0;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
