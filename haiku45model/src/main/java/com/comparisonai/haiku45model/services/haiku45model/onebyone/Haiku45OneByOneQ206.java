package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ206 {

    public ResponseDto Question206() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 206: Find unique positive integer whose square matches 1_2_3_4_5_6_7_8_9_0
        // where _ is a single digit (0-9)

        String pattern = "1_2_3_4_5_6_7_8_9_0";
        long result = 0;

        // The square must start with 1 and end with 0
        // So the number must end with 0
        // Also, the pattern is 19 digits long

        // Range of possible numbers: roughly sqrt(10^18) to sqrt(2*10^18)
        // sqrt(1020304050607080900) ≈ 1,010,100,000
        // sqrt(1929394959697989690) ≈ 1,388,700,000

        long lowerBound = 1000000000L; // 10^9
        long upperBound = 2000000000L; // 2*10^9

        for (long n = lowerBound; n < upperBound; n++) {
            long square = n * n;
            String squareStr = String.valueOf(square);

            if (matchesPattern(squareStr, pattern)) {
                result = n;
                break;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean matchesPattern(String squareStr, String pattern) {
        if (squareStr.length() != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != '_') {
                if (squareStr.charAt(i) != pattern.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
