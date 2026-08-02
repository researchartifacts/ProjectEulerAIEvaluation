package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 483: Permutation Cycle Lengths
 * 
 * For a permutation of n elements, f(P) is the number of steps needed to restore
 * initial order by repeatedly applying the same permutation.
 * g(n) = average value of f(P)^2 over all permutations.
 * Find g(350) in scientific notation to 10 significant figures.
 */
@Service
public class Haiku45OneByOneQ483 {

    public ResponseDto Question483() {
        ResponseDto responseDto = new ResponseDto();

        int n = 350;
        
        // The key insight: f(P) = LCM of all cycle lengths in the permutation
        // We need to compute the average of f(P)^2 across all n! permutations
        
        // This equals: sum of (LCM^2) for all possible cycle structures / n!
        // We can use cycle index polynomials and Burnside's lemma approach
        
        // For large n, we use the theoretical approach:
        // The average of f(P)^2 can be computed by enumerating cycle structures
        // and computing LCM for each, weighted by their frequency
        
        java.math.BigDecimal sumOfSquares = java.math.BigDecimal.ZERO;
        java.math.BigDecimal totalPermutations = factorial(n);
        
        // Use partition-based enumeration of cycle structures
        List<int[]> partitions = generatePartitions(n);
        
        for (int[] partition : partitions) {
            long lcm = computeLCM(partition);
            long lcmSquared = lcm * lcm;
            
            // Count permutations with this cycle structure
            long countPerms = countPermutationsWithCycleStructure(partition);
            
            sumOfSquares = sumOfSquares.add(
                java.math.BigDecimal.valueOf(lcmSquared)
                    .multiply(java.math.BigDecimal.valueOf(countPerms))
            );
        }
        
        java.math.BigDecimal gValue = sumOfSquares.divide(totalPermutations, 50, java.math.RoundingMode.HALF_UP);
        
        // Format to scientific notation with 10 significant figures
        String result = formatScientificNotation(gValue, 10);
        
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeLCM(int[] partition) {
        long lcm = 1;
        for (int cycleLen : partition) {
            if (cycleLen > 0) {
                lcm = lcm(lcm, (long) cycleLen);
            }
        }
        return lcm;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long countPermutationsWithCycleStructure(int[] partition) {
        // For cycle structure, count = n! / (product of cycle lengths * product of frequencies!)
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int cycleLen : partition) {
            if (cycleLen > 0) {
                frequency.put(cycleLen, frequency.getOrDefault(cycleLen, 0) + 1);
            }
        }
        
        long denominator = 1;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            denominator *= Math.pow(entry.getKey(), entry.getValue());
            // Multiply by frequency! to account for identical cycles
            for (int i = 1; i <= entry.getValue(); i++) {
                denominator *= i;
            }
        }
        
        int n = 0;
        for (int cycleLen : partition) {
            n += cycleLen;
        }
        
        return factorial(n).divide(java.math.BigDecimal.valueOf(denominator)).longValue();
    }

    private java.math.BigDecimal factorial(int n) {
        java.math.BigDecimal result = java.math.BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(java.math.BigDecimal.valueOf(i));
        }
        return result;
    }

    private List<int[]> generatePartitions(int n) {
        List<int[]> partitions = new ArrayList<>();
        generatePartitionsHelper(n, n, new int[n], 0, partitions);
        return partitions;
    }

    private void generatePartitionsHelper(int n, int max, int[] partition, int idx, List<int[]> partitions) {
        if (n == 0) {
            int[] copy = new int[idx];
            System.arraycopy(partition, 0, copy, 0, idx);
            partitions.add(copy);
            return;
        }
        
        for (int i = Math.min(n, max); i >= 1; i--) {
            partition[idx] = i;
            generatePartitionsHelper(n - i, i, partition, idx + 1, partitions);
        }
    }

    private String formatScientificNotation(java.math.BigDecimal value, int significantFigures) {
        String str = value.toPlainString();
        
        // Remove decimal point and leading zeros
        String digits = str.replace(".", "").replaceFirst("^0+", "");
        if (digits.isEmpty()) digits = "0";
        
        // Get exponent
        int decimalPos = str.indexOf(".");
        int intPartLen = decimalPos >= 0 ? decimalPos : str.length();
        int exponent = intPartLen - 1;
        
        // Build mantissa
        String mantissa = digits.substring(0, Math.min(significantFigures, digits.length()));
        if (mantissa.length() < significantFigures && mantissa.length() < digits.length()) {
            mantissa = mantissa + "0".repeat(significantFigures - mantissa.length());
        }
        
        // Insert decimal point
        if (mantissa.length() > 1) {
            mantissa = mantissa.charAt(0) + "." + mantissa.substring(1);
        }
        
        return mantissa.replaceAll("0+$", "").replaceAll("\\.$", "") + "e" + exponent;
    }
}
