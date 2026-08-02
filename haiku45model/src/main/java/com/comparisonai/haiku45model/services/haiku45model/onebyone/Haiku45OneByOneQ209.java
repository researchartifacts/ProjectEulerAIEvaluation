package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ209 {

    public ResponseDto Question209() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 209: 6-input binary truth tables
        // Count tables τ where τ(a,b,c,d,e,f) AND τ(b,c,d,e,f,a XOR (b AND c)) = 0
        // for all 6-bit inputs

        long count = 0;

        // A 6-input truth table can be represented as a 64-bit number
        // where each bit represents the output for a specific input combination

        // We need to iterate through all possible truth tables (2^64 combinations)
        // and check which ones satisfy the constraint

        // For efficiency, we'll iterate through all 2^64 possible outputs
        // and for each, check if the constraint is satisfied for all 64 inputs

        for (long tau = 0; tau < (1L << 64); tau++) {
            if (satisfiesConstraint(tau)) {
                count++;
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean satisfiesConstraint(long tau) {
        // Check if the truth table τ satisfies:
        // τ(a,b,c,d,e,f) AND τ(b,c,d,e,f,a XOR (b AND c)) = 0
        // for all 6-bit inputs

        for (int input = 0; input < 64; input++) {
            int a = (input >> 5) & 1;
            int b = (input >> 4) & 1;
            int c = (input >> 3) & 1;
            int d = (input >> 2) & 1;
            int e = (input >> 1) & 1;
            int f = input & 1;

            // τ(a,b,c,d,e,f)
            int tau1 = (int) ((tau >> input) & 1);

            // τ(b,c,d,e,f,a XOR (b AND c))
            int xor_val = a ^ (b & c);
            int input2 = (b << 5) | (c << 4) | (d << 3) | (e << 2) | (f << 1) | xor_val;
            int tau2 = (int) ((tau >> input2) & 1);

            // Check AND constraint
            if ((tau1 & tau2) != 0) {
                return false;
            }
        }

        return true;
    }
}
