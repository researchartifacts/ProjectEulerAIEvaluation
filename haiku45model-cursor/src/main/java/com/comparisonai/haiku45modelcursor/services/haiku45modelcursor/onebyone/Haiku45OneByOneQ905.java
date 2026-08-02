package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 905: Epistemologists and Hat Numbers
 */
@Service
public class Haiku45OneByOneQ905 {

    public ResponseDto Question905() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Calculate sum of F(a^b, b^a, a^b + b^a) for epistemologists game
        // F(A,B,C) is number of turns until declaration with A + B = C knowledge constraint
        long result = 0;

        for (int a = 1; a <= 7; a++) {
            for (int b = 1; b <= 19; b++) {
                long A = (long) Math.pow(a, b);
                long B = (long) Math.pow(b, a);
                long C = A + B;
                
                // Simulate epistemologist deduction game
                long turns = 0;
                boolean[] deduced = {false, false, false};
                
                // Each person knows sum is a+b or c and sees others' values
                for (long turn = 1; turn <= 100000; turn++) {
                    for (int person = 0; person < 3; person++) {
                        long[] values = {A, B, C};
                        long myValue = values[person];
                        
                        // Can deduce if unique possibility
                        int possibleCount = 0;
                        for (int other1 = 0; other1 < 3; other1++) {
                            for (int other2 = other1 + 1; other2 < 3; other2++) {
                                if (other1 != person && other2 != person) {
                                    long v1 = values[other1];
                                    long v2 = values[other2];
                                    if (myValue + v1 == v2 || myValue + v2 == v1 || v1 + v2 == myValue) {
                                        possibleCount++;
                                    }
                                }
                            }
                        }
                        
                        if (possibleCount == 1) {
                            deduced[person] = true;
                        }
                    }
                    
                    if (deduced[0] || deduced[1] || deduced[2]) {
                        turns = turn;
                        break;
                    }
                }
                
                result += turns;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
