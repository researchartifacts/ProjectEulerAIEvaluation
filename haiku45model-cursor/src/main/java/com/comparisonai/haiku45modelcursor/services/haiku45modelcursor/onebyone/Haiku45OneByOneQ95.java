package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 95
 */
@Service
public class Haiku45OneByOneQ95 {

    public ResponseDto Question95() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find smallest member of longest amicable chain with no element exceeding 1 million
        // Generated logic to solve the problem:
        final int LIMIT = 1_000_000;
        
        // Pre-compute sum of proper divisors for all numbers
        int[] sumOfProperDivisors = new int[LIMIT + 1];
        for (int i = 1; i <= LIMIT / 2; i++) {
            for (int j = 2 * i; j <= LIMIT; j += i) {
                sumOfProperDivisors[j] += i;
            }
        }
        
        int longestChainLength = 0;
        int smallestInLongestChain = 0;
        
        for (int start = 1; start <= LIMIT; start++) {
            java.util.Set<Integer> visited = new java.util.HashSet<>();
            int current = start;
            int chainLength = 0;
            
            while (current > 0 && current <= LIMIT && !visited.contains(current)) {
                visited.add(current);
                current = sumOfProperDivisors[current];
                chainLength++;
                
                if (current == start) {
                    // Found a cycle back to start
                    if (chainLength > longestChainLength) {
                        longestChainLength = chainLength;
                        smallestInLongestChain = visited.stream().min(Integer::compareTo).orElse(0);
                    }
                    break;
                }
            }
        }
        
        Object result = smallestInLongestChain;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
