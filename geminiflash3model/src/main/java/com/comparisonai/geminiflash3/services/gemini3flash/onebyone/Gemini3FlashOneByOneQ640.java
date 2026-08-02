package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ640 {

    public ResponseDto Question640() {
        ResponseDto responseDto = new ResponseDto();
        
        // Markov Chain with 2^12 states.
        // E[S] = 1 + (1/36) * sum_{x,y} min(E[S^x], E[S^y], E[S^(x+y)])
        double expectedTurns = solve();
        
        responseDto.setAnswer(String.format("%.6f", expectedTurns));
        return responseDto;
    }

    private double solve() {
        int numCards = 12;
        int numStates = 1 << numCards;
        double[] e = new double[numStates];
        Arrays.fill(e, 100.0); // Initial guess
        e[numStates - 1] = 0; // Target state: all down
        
        // Probability of (x, y) sums:
        double[] prob = new double[13];
        for (int x = 1; x <= 6; x++) {
            for (int y = 1; y <= 6; y++) {
                // Bob choices for (x, y) are cards x, y, or x+y.
            }
        }
        
        // Iteratively solve for expected turns.
        for (int iter = 0; iter < 500; iter++) {
            double[] nextE = new double[numStates];
            nextE[numStates - 1] = 0;
            for (int s = 0; s < numStates - 1; s++) {
                double sum = 0;
                for (int x = 1; x <= 6; x++) {
                    for (int y = 1; y <= 6; y++) {
                        double m = Math.min(e[s ^ (1 << (x - 1))], Math.min(e[s ^ (1 << (y - 1))], e[s ^ (1 << (x + y - 1))]));
                        sum += m;
                    }
                }
                nextE[s] = 1 + sum / 36.0;
            }
            e = nextE;
        }
        
        return e[0]; // Start state: all up (00...0)
    }
}
