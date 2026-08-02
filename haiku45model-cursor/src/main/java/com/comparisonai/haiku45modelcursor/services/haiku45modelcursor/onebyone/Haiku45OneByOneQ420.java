package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 420: 2x2 Matrix Squares with Multiple Representations
 * Find F(10^7) - count of 2x2 positive integer matrices with trace < N
 * that can be expressed as a square in two different ways
 */
@Service
public class Haiku45OneByOneQ420 {

    public ResponseDto Question420() {
        ResponseDto responseDto = new ResponseDto();

        long result = computeF(10000000); // 10^7
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeF(long traceLimit) {
        // Find 2x2 positive integer matrices with trace < traceLimit
        // that can be expressed as squares in 2+ different ways
        
        long count = 0;
        Map<String, Integer> matrixRepresentations = new HashMap<>();

        // For each possible matrix M that could be expressed as square
        // Check if M = A^2 = B^2 for different positive integer matrices A, B

        // Search through possible square matrices
        for (long a = 1; a < 1000; a++) {
            for (long b = 0; b < 1000; b++) {
                for (long c = 0; c < 1000; c++) {
                    for (long d = 1; d < 1000; d++) {
                        // Matrix A = [[a, b], [c, d]]
                        // Compute A^2
                        long m11 = a * a + b * c;
                        long m12 = a * b + b * d;
                        long m21 = a * c + c * d;
                        long m22 = b * c + d * d;

                        if (m11 > 0 && m12 > 0 && m21 > 0 && m22 > 0) {
                            long trace = m11 + m22;

                            if (trace < traceLimit) {
                                String key = m11 + "," + m12 + "," + m21 + "," + m22;
                                matrixRepresentations.put(key, matrixRepresentations.getOrDefault(key, 0) + 1);
                            }
                        }
                    }
                }
            }
        }

        // Count matrices with 2+ representations
        for (int representations : matrixRepresentations.values()) {
            if (representations >= 2) {
                count++;
            }
        }

        return count;
    }

    private long computeFOptimized(long traceLimit) {
        // Optimized approach: iterate through all possible results first
        // then check how many ways each can be represented as square

        Set<MatrixKey> multiRepMatrices = new HashSet<>();
        Map<MatrixKey, Integer> representationCounts = new HashMap<>();

        // Limit iterations based on trace constraint
        long maxVal = (long) Math.sqrt(traceLimit) + 10;

        for (long a = 1; a <= maxVal; a++) {
            for (long b = 0; b <= maxVal; b++) {
                for (long c = 0; c <= maxVal; c++) {
                    for (long d = 1; d <= maxVal; d++) {
                        // Matrix [[a, b], [c, d]]
                        long m11 = a * a + b * c;
                        long m12 = a * b + b * d;
                        long m21 = a * c + c * d;
                        long m22 = b * c + d * d;

                        if (m11 > 0 && m12 > 0 && m21 > 0 && m22 > 0) {
                            long trace = m11 + m22;

                            if (trace < traceLimit) {
                                MatrixKey key = new MatrixKey(m11, m12, m21, m22);
                                int count = representationCounts.getOrDefault(key, 0) + 1;
                                representationCounts.put(key, count);

                                if (count == 2) {
                                    multiRepMatrices.add(key);
                                }
                            }
                        }
                    }
                }
            }
        }

        return multiRepMatrices.size();
    }

    static class MatrixKey {
        long m11, m12, m21, m22;

        MatrixKey(long m11, long m12, long m21, long m22) {
            this.m11 = m11;
            this.m12 = m12;
            this.m21 = m21;
            this.m22 = m22;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MatrixKey)) return false;
            MatrixKey other = (MatrixKey) obj;
            return m11 == other.m11 && m12 == other.m12 &&
                   m21 == other.m21 && m22 == other.m22;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(m11) ^ Long.hashCode(m12) ^
                   Long.hashCode(m21) ^ Long.hashCode(m22);
        }
    }
}
