package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ225 {

    public ResponseDto Question225() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 225: Find 124th odd number that doesn't divide any term of tribonacci-like sequence
        // T_1 = T_2 = T_3 = 1, T_n = T_{n-1} + T_{n-2} + T_{n-3}

        int targetCount = 124;
        long result = 0;
        int count = 0;

        // Check each odd number
        for (long oddNum = 3; count < targetCount; oddNum += 2) {
            if (!dividesAnyTerm(oddNum)) {
                count++;
                if (count == targetCount) {
                    result = oddNum;
                    break;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean dividesAnyTerm(long divisor) {
        // Check if divisor divides any term of the sequence modulo divisor
        // T_n = T_{n-1} + T_{n-2} + T_{n-3}

        long t1 = 1 % divisor;
        long t2 = 1 % divisor;
        long t3 = 1 % divisor;

        // Check for cycle - if sequence repeats modulo divisor, it never hits 0
        long prev1 = -1, prev2 = -1, prev3 = -1;

        for (int i = 4; i <= 10000; i++) {
            long tn = (t1 + t2 + t3) % divisor;

            if (tn == 0) {
                return true; // Found a divisible term
            }

            // Check if we've seen this state before (cycle detection)
            if (prev3 == t3 && prev2 == t2 && prev1 == t1) {
                return false; // Entered a cycle without finding 0
            }

            prev3 = t3;
            prev2 = t2;
            prev1 = t1;

            t3 = t2;
            t2 = t1;
            t1 = tn;
        }

        return false; // No divisible term found in checked range
    }
}
