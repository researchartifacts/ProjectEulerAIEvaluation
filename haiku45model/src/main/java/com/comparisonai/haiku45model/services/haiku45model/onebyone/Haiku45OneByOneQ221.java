package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ221 {

    public ResponseDto Question221() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 221: Alexandrian integers
        // Find 150000th integer A where A = p*q*r and 1/A = 1/p + 1/q + 1/r

        int targetIndex = 150000;
        long result = findAlexandrianInteger(targetIndex);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findAlexandrianInteger(int targetIndex) {
        // From 1/A = 1/p + 1/q + 1/r and A = pqr
        // We get: 1/(pqr) = 1/p + 1/q + 1/r
        // Multiply by pqr: 1 = qr + pr + pq
        // This is: pq + pr + qr = 1

        TreeSet<Long> alexandrians = new TreeSet<>();

        // For each valid combination of p, q, r
        // We need pq + pr + qr = 1, which means p, q, r can be negative or positive

        // Without loss of generality, assume p <= q <= r
        // From pq + pr + qr = 1: p(q+r) = 1 - qr

        for (long p = -1000; p <= 1000; p++) {
            if (p == 0) continue;

            for (long q = -1000; q <= 1000; q++) {
                if (q == 0) continue;
                if (p > q) continue;

                // Solve for r: pq + pr + qr = 1
                // r(p + q) = 1 - pq
                // r = (1 - pq) / (p + q)

                if (p + q == 0) continue;

                if ((1 - p * q) % (p + q) != 0) continue;

                long r = (1 - p * q) / (p + q);
                if (r == 0) continue;
                if (r < q) continue;

                // Verify the equation
                if (p * q + p * r + q * r == 1) {
                    long A = Math.abs(p * q * r);
                    if (A > 0) {
                        alexandrians.add(A);
                    }
                }
            }
        }

        // Convert to sorted list
        List<Long> sorted = new ArrayList<>(alexandrians);
        Collections.sort(sorted);

        if (sorted.size() >= targetIndex) {
            return sorted.get(targetIndex - 1);
        }

        return -1;
    }
}
