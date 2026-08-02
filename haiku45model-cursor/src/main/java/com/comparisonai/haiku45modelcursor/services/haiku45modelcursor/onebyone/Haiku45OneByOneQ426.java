package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 426: Box-Ball System (BBS) simulation
 * Simulate BBS evolution and find sum of squares of final state
 */
@Service
public class Haiku45OneByOneQ426 {

    public ResponseDto Question426() {
        ResponseDto responseDto = new ResponseDto();

        // Initialize sequence using LCG
        long s0 = 290797L;
        long mod = 50515093L;
        
        // Generate initial configuration
        List<Integer> config = new ArrayList<>();
        long s = s0;
        
        for (int k = 0; k <= 10000000; k++) {
            int t = (int)((s % 64) + 1);
            config.add(t);
            s = (s * s) % mod;
        }
        
        // Simulate BBS until reaching final state
        List<Integer> finalState = simulateBBS(config);
        
        // Calculate sum of squares
        long result = 0;
        for (int val : finalState) {
            result += (long)val * val;
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private List<Integer> simulateBBS(List<Integer> initialConfig) {
        List<Integer> current = new ArrayList<>(initialConfig);
        List<Integer> previous = null;
        
        // Simulate until reaching invariant state
        int maxIterations = 1000;
        
        for (int iter = 0; iter < maxIterations; iter++) {
            List<Integer> next = performTurn(current);
            
            // Check if reached final state (invariant)
            if (isFinalState(current, next)) {
                return extractFinalState(next);
            }
            
            previous = current;
            current = next;
        }
        
        return extractFinalState(current);
    }
    
    private List<Integer> performTurn(List<Integer> config) {
        // Each turn: move leftmost unmoved ball to nearest empty box
        List<Integer> expanded = expandConfig(config);
        List<Integer> result = new ArrayList<>();
        
        boolean[] moved = new boolean[expanded.size()];
        int ballPos = 0;
        int writePos = 0;
        
        // Track occupied and empty positions
        for (int i = 0; i < expanded.size(); i++) {
            if (expanded.get(i) == 1) {
                ballPos = i;
                break;
            }
        }
        
        // Move balls according to rule
        for (int i = 0; i < expanded.size(); i++) {
            if (expanded.get(i) == 1 && !moved[i]) {
                // Find next empty box
                int emptyPos = findNextEmpty(expanded, i);
                if (emptyPos > i) {
                    moved[i] = true;
                    writePos = emptyPos;
                }
            }
        }
        
        // Reconstruct configuration
        return collapseConfig(expanded);
    }
    
    private List<Integer> expandConfig(List<Integer> config) {
        List<Integer> expanded = new ArrayList<>();
        boolean isOccupied = true;
        
        for (int count : config) {
            for (int i = 0; i < count; i++) {
                expanded.add(isOccupied ? 1 : 0);
            }
            isOccupied = !isOccupied;
        }
        
        return expanded;
    }
    
    private List<Integer> collapseConfig(List<Integer> expanded) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        boolean isOccupied = true;
        
        for (int val : expanded) {
            if ((val == 1) == isOccupied) {
                count++;
            } else {
                if (count > 0) {
                    result.add(count);
                }
                count = 1;
                isOccupied = !isOccupied;
            }
        }
        
        if (count > 0) {
            result.add(count);
        }
        
        return result;
    }
    
    private int findNextEmpty(List<Integer> expanded, int startPos) {
        for (int i = startPos + 1; i < expanded.size(); i++) {
            if (expanded.get(i) == 0) {
                return i;
            }
        }
        return expanded.size();
    }
    
    private boolean isFinalState(List<Integer> current, List<Integer> next) {
        // Check if configuration is invariant (reached steady state)
        if (current.size() != next.size()) return false;
        
        for (int i = 0; i < current.size(); i++) {
            if (!current.get(i).equals(next.get(i))) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<Integer> extractFinalState(List<Integer> config) {
        // Extract only occupied box counts from final state
        List<Integer> finalState = new ArrayList<>();
        
        for (int i = 0; i < config.size(); i += 2) {
            finalState.add(config.get(i));
        }
        
        return finalState;
    }
}
