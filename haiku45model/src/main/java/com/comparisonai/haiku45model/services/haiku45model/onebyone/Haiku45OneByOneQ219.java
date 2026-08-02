package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ219 {

    public ResponseDto Question219() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 219: Prefix-free codes with asymmetric costs
        // Cost: 1 pence for '0', 4 pence for '1'
        // Find minimum cost of prefix-free code with 10^9 codewords

        long n = 1000000000L;
        long result = findMinimumCost(n);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long findMinimumCost(long n) {
        // Use Kraft inequality and optimal code construction
        // For prefix-free codes, sum of 2^(-L_i) = 1, where L_i is codeword length

        // To minimize cost with weights w0=1, w1=4:
        // Use weighted tree construction (Huffman-like)

        // Optimal strategy: use '0' (weight 1) for common lengths
        // Use '1' (weight 4) sparingly

        // Cost function: C = sum(length_i * weight_i * count_i)

        long cost = 0;
        long remaining = n;

        int length = 1;

        // Greedily allocate codewords by cost efficiency
        while (remaining > 0) {
            // Maximum codewords of length L using only '0's: 1
            // Using one '1': 1 (then rest must use increasing length)

            long costsFor0Only = length * 1; // L bits of '0'
            long costsFor1UseOne = length * 4; // L bits, one is '1'

            if (remaining == 1) {
                cost += length;
                remaining--;
            } else if (costsFor0Only < costsFor1UseOne) {
                cost += costsFor0Only;
                remaining--;
            } else {
                long count = Math.min(remaining, (1L << length) - 1);
                cost += count * length;
                remaining -= count;
            }

            length++;
        }

        return cost;
    }
}
