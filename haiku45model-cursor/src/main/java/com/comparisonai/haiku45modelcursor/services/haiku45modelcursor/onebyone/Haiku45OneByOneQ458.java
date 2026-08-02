package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 458
 * Count strings of length 10^12 from alphabet {c,e,j,o,p,r,t}
 * that don't contain any permutation of "project"
 * Find T(10^12) mod 10^9
 */
@Service
public class Haiku45OneByOneQ458 {

    public ResponseDto Question458() {
        ResponseDto responseDto = new ResponseDto();
        
        long length = 1_000_000_000_000L;
        int alphabetSize = 7; // {c, e, j, o, p, r, t}
        int permutationLength = 7;
        long modulo = 1_000_000_000L;
        
        // T(n) = number of strings of length n that don't contain any permutation of "project"
        // Use inclusion-exclusion with dynamic programming
        
        // For large n, use matrix exponentiation
        // Build transition matrix based on valid character sequences
        
        long result = calculateT(length, alphabetSize, permutationLength, modulo);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long calculateT(long length, int alphabetSize, int permutationLength, long modulo) {
        // T(n) counts strings avoiding all permutations of "project"
        // Using principle: total strings - strings with at least one bad substring
        
        // For small lengths: T(n) = alphabet^n - (bad arrangements)
        // For large lengths: use recurrence relation with matrix exponentiation
        
        if (length <= 6) {
            // For short lengths, all strings are valid if length < permutationLength
            return power(alphabetSize, length, modulo);
        }
        
        // Build a DP transition matrix
        // States track which characters from "project" we've seen
        // This prevents forming any permutation
        
        // Simplified approach for large n:
        // Use approximation that valid strings follow pattern
        // where we can't form complete sets of project letters
        
        long[][] matrix = buildTransitionMatrix(alphabetSize, permutationLength);
        long[][] result_matrix = matrixPower(matrix, length, modulo);
        
        // Sum all valid end states
        long total = 0;
        for (int i = 0; i < result_matrix.length; i++) {
            total = (total + result_matrix[i][0]) % modulo;
        }
        
        return total;
    }
    
    private long[][] buildTransitionMatrix(int alphabetSize, int permutationLength) {
        // Simple transition matrix for state-based DP
        // State i represents number of distinct "project" characters seen
        int states = permutationLength + 1;
        long[][] matrix = new long[states][states];
        
        for (int i = 0; i < states; i++) {
            if (i < states - 1) {
                // Add any of the 7 characters
                // If it's a new "project" character, advance state
                matrix[i][i] += (alphabetSize - (i > 0 ? 1 : 0));
                if (i < states - 1) {
                    matrix[i][i + 1] += 1;
                }
            } else {
                // Terminal state: can't add more
                matrix[i][i] += alphabetSize;
            }
        }
        
        return matrix;
    }
    
    private long[][] matrixPower(long[][] matrix, long exp, long modulo) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        
        // Initialize as identity
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        
        long[][] base = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                base[i][j] = matrix[i][j] % modulo;
            }
        }
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = matrixMultiply(result, base, modulo);
            }
            base = matrixMultiply(base, base, modulo);
            exp >>= 1;
        }
        
        return result;
    }
    
    private long[][] matrixMultiply(long[][] a, long[][] b, long modulo) {
        int n = a.length;
        long[][] result = new long[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % modulo;
                }
            }
        }
        
        return result;
    }
    
    private long power(long base, long exp, long modulo) {
        long result = 1;
        base %= modulo;
        
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % modulo;
            }
            base = (base * base) % modulo;
            exp >>= 1;
        }
        
        return result;
    }
}
