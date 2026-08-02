package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 910: Khinchin's Constant and Continued Fractions
 */
@Service
public class Haiku45OneByOneQ910 {

    public ResponseDto Question910() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find geometric mean of k_∞(ρ_n) for n from 0 to 50
        // where ρ_n = sum of 2^n / 2^(2^i) for i from 0 to infinity
        
        double geometricMean = 1.0;
        int terms = 51;
        
        for (int n = 0; n <= 50; n++) {
            // Calculate ρ_n
            double rho = 0;
            for (int i = 0; i <= 30; i++) { // 30 terms is sufficient for convergence
                long denominator = 1L << (1L << i); // 2^(2^i)
                long numerator = 1L << n; // 2^n
                rho += (double) numerator / denominator;
                if (rho > 1e15) break; // Stop if diverging
            }
            
            // Compute continued fraction of ρ_n
            double[] cfTerms = computeContinuedFraction(rho, 100);
            
            // Compute k_∞(ρ_n) = geometric mean of continued fraction terms
            double kInfinity = computeGeometricMean(cfTerms);
            
            // Update overall geometric mean
            geometricMean *= kInfinity;
        }
        
        // Take the 51st root
        geometricMean = Math.pow(geometricMean, 1.0 / terms);

        responseDto.setAnswer(String.format("%.6f", geometricMean));
        return responseDto;
    }
    
    private double[] computeContinuedFraction(double x, int maxTerms) {
        double[] cf = new double[maxTerms];
        double current = x;
        
        for (int i = 0; i < maxTerms && i < 100; i++) {
            cf[i] = Math.floor(current);
            current -= cf[i];
            if (Math.abs(current) < 1e-15) break;
            current = 1.0 / current;
        }
        
        return cf;
    }
    
    private double computeGeometricMean(double[] terms) {
        double product = 1.0;
        int count = 0;
        
        for (double term : terms) {
            if (term > 0 && term < 1e15) {
                product *= term;
                count++;
            }
        }
        
        if (count == 0) return 1.0;
        return Math.pow(product, 1.0 / count);
    }
}
