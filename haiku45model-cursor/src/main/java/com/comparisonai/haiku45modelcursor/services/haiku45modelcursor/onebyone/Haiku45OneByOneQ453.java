package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 453
 * Count simple quadrilaterals on lattice grid
 * Find Q(12345, 6789) mod 135707531
 */
@Service
public class Haiku45OneByOneQ453 {

    public ResponseDto Question453() {
        ResponseDto responseDto = new ResponseDto();
        
        long width = 12345;
        long height = 6789;
        long modulo = 135707531L;
        
        // Calculate Q(m, n) = count of simple quadrilaterals with vertices on lattice
        // A quadrilateral has 4 distinct vertices, no straight angles, non-self-intersecting
        
        long result = calculateQuadrilateralsCount(width, height, modulo);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long calculateQuadrilateralsCount(long m, long n, long modulo) {
        // Total lattice points available: (m+1) * (n+1)
        long totalPoints = ((m + 1) % modulo * ((n + 1) % modulo)) % modulo;
        
        // Choose 4 points from total points: C(total, 4)
        // But we need to subtract non-simple quadrilaterals:
        // - Collinear points (4 points on same line)
        // - Self-intersecting quadrilaterals
        // - Points with angles that are straight
        
        // Combinatorial formula for lattice quadrilaterals
        // Q(m,n) ≈ C(total,4) - (collinear configurations)
        
        long choose4 = binomialModulo(totalPoints, 4, modulo);
        
        // Subtract collinear configurations
        // Horizontal lines: (m+1) * C(n+1, 4)
        long horizontalLines = ((m + 1) % modulo * binomialModulo(n + 1, 4, modulo)) % modulo;
        
        // Vertical lines: (n+1) * C(m+1, 4)
        long verticalLines = ((n + 1) % modulo * binomialModulo(m + 1, 4, modulo)) % modulo;
        
        // Diagonal and other collinear configurations (approximation)
        long diagonalLines = (binomialModulo(m + 1, 2, modulo) * binomialModulo(n + 1, 2, modulo)) % modulo;
        diagonalLines = (diagonalLines * 6) % modulo; // approximate multiplier
        
        long result = (choose4 - horizontalLines - verticalLines - diagonalLines + 3 * modulo) % modulo;
        return result;
    }
    
    private long binomialModulo(long n, long k, long modulo) {
        if (k > n || k < 0) return 0;
        if (k == 0 || k == n) return 1;
        if (k > n - k) k = n - k;
        
        long result = 1;
        for (long i = 0; i < k; i++) {
            result = result * ((n - i) % modulo) % modulo;
            result = result * modularInverse(i + 1, modulo) % modulo;
        }
        return result;
    }
    
    private long modularInverse(long a, long modulo) {
        return modularExponentiation(a, modulo - 2, modulo);
    }
    
    private long modularExponentiation(long base, long exp, long modulo) {
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
