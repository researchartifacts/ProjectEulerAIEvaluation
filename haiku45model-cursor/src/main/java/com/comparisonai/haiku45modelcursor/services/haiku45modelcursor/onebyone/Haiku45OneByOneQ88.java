package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 88
 */
@Service
public class Haiku45OneByOneQ88 {

    public ResponseDto Question88() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find sum of minimal product-sum numbers for k from 2 to 12000
        int maxK = 12000;
        int[] minProdSum = new int[maxK + 1];
        java.util.Arrays.fill(minProdSum, Integer.MAX_VALUE);
        
        // Find minimal product-sum for each k by trying all factorizations
        // For k elements: sum = product + (k - number_of_factors)
        // So product - sum = k - n where n is number of factors
        
        findProductSums(1, 1, 1, 1, minProdSum);
        
        java.util.Set<Integer> uniqueNumbers = new java.util.HashSet<>();
        for (int k = 2; k <= maxK; k++) {
            if (minProdSum[k] != Integer.MAX_VALUE) {
                uniqueNumbers.add(minProdSum[k]);
            }
        }
        
        long sum = 0;
        for (int num : uniqueNumbers) {
            sum += num;
        }
        
        Object result = sum;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private void findProductSums(int prod, int sum, int numFactors, int nextFactor, int[] minProdSum) {
        // k = prod - sum + numFactors
        int k = prod - sum + numFactors;
        
        if (k <= minProdSum.length - 1) {
            minProdSum[k] = Math.min(minProdSum[k], prod);
        }
        
        // Try multiplying by factors
        for (int f = nextFactor; f <= 100; f++) {
            if (prod * f > 50000) break; // Reasonable upper bound
            findProductSums(prod * f, sum + f, numFactors + 1, f, minProdSum);
        }
    }
}
