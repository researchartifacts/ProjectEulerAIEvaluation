package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 68
 */
@Service
public class Haiku45OneByOneQ68 {

    public ResponseDto Question68() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, an...
        // Generated logic to solve the problem:
        
        String maxString = "";
        
        // A 5-gon ring has 5 lines, each line has 3 numbers that sum to a magic constant
        // Structure: outer nodes (5) + inner nodes (5) = 10 numbers total
        // For 16-digit string, we need to arrange so outer nodes are small (1-5)
        
        // Try all permutations and test magic ring conditions
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        java.util.Arrays.sort(nums);
        
        do {
            // nums[0:5] are outer, nums[5:10] are inner
            int[] outer = java.util.Arrays.copyOfRange(nums, 0, 5);
            int[] inner = java.util.Arrays.copyOfRange(nums, 5, 10);
            
            // Try all magic sums
            for (int magicSum = 6; magicSum <= 28; magicSum++) {
                if (isValidMagicRing(outer, inner, magicSum)) {
                    String ringString = getRingString(outer, inner);
                    if (ringString.length() == 16 && ringString.compareTo(maxString) > 0) {
                        maxString = ringString;
                    }
                }
            }
        } while (nextPermutation(nums));
        
        Object result = Long.parseLong(maxString);
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean isValidMagicRing(int[] outer, int[] inner, int magicSum) {
        for (int i = 0; i < 5; i++) {
            if (outer[i] + inner[i] + inner[(i + 1) % 5] != magicSum) {
                return false;
            }
        }
        return true;
    }
    
    private String getRingString(int[] outer, int[] inner) {
        // Find minimum outer node position and build string clockwise
        int minIdx = 0;
        for (int i = 1; i < 5; i++) {
            if (outer[i] < outer[minIdx]) {
                minIdx = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int idx = (minIdx + i) % 5;
            sb.append(outer[idx]);
            sb.append(inner[idx]);
            sb.append(inner[(idx + 1) % 5]);
        }
        return sb.toString();
    }
    
    private boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;
        
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
        java.util.Arrays.sort(arr, i + 1, arr.length);
        return true;
    }
}
