package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 438 - Integer Polynomial Roots
 * 
 * For n=7, find sum of S(t) for all n-tuples t of integers where:
 * 1. Roots x_i of polynomial x^n + a_1*x^(n-1) + ... + a_n = 0 are all real
 * 2. When sorted, floor(x_i) = i for each i from 1 to n
 * S(t) = sum of absolute values of coefficients in t
 */
@Service
public class Haiku45OneByOneQ438 {

    public ResponseDto Question438() {
        ResponseDto responseDto = new ResponseDto();

        int n = 7;
        long result = 0;

        // For n=7, we need to find all valid coefficient tuples
        // where roots satisfy:
        // 1. All roots are real
        // 2. floor(x_i) = i when sorted (1 <= i <= n)
        
        // This means: 1 <= x_1 < 2, 2 <= x_2 < 3, ..., 7 <= x_7 < 8
        
        // Use dynamic programming to enumerate valid root configurations
        // and calculate their corresponding coefficients
        
        result = calculateTotalSum(n);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateTotalSum(int n) {
        long totalSum = 0;
        
        // For each valid set of roots x_1, ..., x_n where floor(x_i) = i
        // We need to calculate the coefficients a_1, ..., a_n using Vieta's formulas
        
        // The polynomial is: (x - x_1)(x - x_2)...(x - x_n)
        // Expanding gives coefficients that are elementary symmetric polynomials in roots
        
        // By Vieta's formulas:
        // a_i = (-1)^i * e_i(x_1, ..., x_n)
        // where e_i is the i-th elementary symmetric polynomial
        
        // We need integer coefficients, so we need specific root configurations
        
        // Approach: enumerate possible root configurations
        // For n=7, use a search with constraints
        
        // Roots must satisfy: i <= x_i < i+1 for i = 1 to n
        // And all coefficients must be integers
        
        // Use Monte Carlo sampling or exhaustive search with discretization
        
        // Discretize the root space: each x_i can be in [i, i+1)
        // Try rational roots with small denominators
        
        java.util.List<long[]> validConfigs = findValidConfigurations(n);
        
        for (long[] coeffs : validConfigs) {
            long sum = 0;
            for (long c : coeffs) {
                sum += Math.abs(c);
            }
            totalSum += sum;
        }
        
        return totalSum;
    }

    private java.util.List<long[]> findValidConfigurations(int n) {
        java.util.List<long[]> configs = new java.util.ArrayList<>();
        
        // For n=7, enumerate configurations
        // Use a constraint satisfaction approach
        
        if (n == 4) {
            // For n=4, there are 12 valid configurations
            // These can be found by solving the constraint system
            
            // Each root x_i satisfies i <= x_i < i+1
            // Coefficients must be integers
        }
        
        if (n == 7) {
            // For n=7, use more sophisticated enumeration
            // The number of valid tuples grows significantly
            
            // Use recursive backtracking with pruning
            enumerateRoots(n, new double[n], 0, configs);
        }
        
        return configs;
    }

    private void enumerateRoots(int n, double[] roots, int depth, 
                                 java.util.List<long[]> configs) {
        if (depth == n) {
            // Check if this configuration gives integer coefficients
            long[] coeffs = calculateCoefficients(roots);
            if (coeffs != null && areAllInteger(coeffs)) {
                configs.add(coeffs);
            }
            return;
        }
        
        // Try different values for root at position depth
        int lowerBound = depth + 1;
        
        // Sample values in [lowerBound, lowerBound + 1)
        for (int i = 0; i <= 100; i++) {
            double value = lowerBound + (double) i / 100;
            roots[depth] = value;
            
            enumerateRoots(n, roots, depth + 1, configs);
        }
    }

    private long[] calculateCoefficients(double[] roots) {
        int n = roots.length;
        long[] coeffs = new long[n];
        
        // Use Vieta's formulas to calculate coefficients
        // a_i = (-1)^i * e_i(roots)
        
        // Calculate elementary symmetric polynomials
        double[] elementary = new double[n + 1];
        elementary[0] = 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i + 1, n); j > 0; j--) {
                elementary[j] = elementary[j] * roots[i] + elementary[j - 1];
            }
        }
        
        // Convert to integer coefficients with sign
        for (int i = 0; i < n; i++) {
            double val = elementary[i + 1];
            if ((i + 1) % 2 == 1) {
                val = -val;
            }
            
            long rounded = Math.round(val);
            if (Math.abs(val - rounded) > 0.0001) {
                return null; // Not an integer
            }
            coeffs[i] = rounded;
        }
        
        return coeffs;
    }

    private boolean areAllInteger(long[] coeffs) {
        for (long c : coeffs) {
            // Already stored as long, so already integer
        }
        return true;
    }
}
