package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ201 {

    public ResponseDto Question201() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 201: Sum of unique sums of 50-element subsets
        // Set S = {1^2, 2^2, ..., 100^2}
        // Find sum of all integers that appear exactly once as the sum of a 50-element subset

        int[] squares = new int[100];
        for (int i = 0; i < 100; i++) {
            squares[i] = (i + 1) * (i + 1);
        }

        // Use dynamic programming to count sum occurrences
        // Map: sum -> count of how many subsets produce that sum
        Map<Long, Integer> sumCount = new HashMap<>();

        // Generate all 50-element subsets and count their sums
        generateCombinations(squares, 0, new long[50], 0, sumCount);

        // Sum only those that appear exactly once
        long result = 0;
        for (Map.Entry<Long, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() == 1) {
                result += entry.getKey();
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private void generateCombinations(int[] squares, int startIdx, long[] current, int depth, Map<Long, Integer> sumCount) {
        if (depth == 50) {
            long sum = 0;
            for (long val : current) {
                sum += val;
            }
            sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            return;
        }

        for (int i = startIdx; i < squares.length; i++) {
            if (squares.length - i >= 50 - depth) {
                current[depth] = squares[i];
                generateCombinations(squares, i + 1, current, depth + 1, sumCount);
            }
        }
    }
}
