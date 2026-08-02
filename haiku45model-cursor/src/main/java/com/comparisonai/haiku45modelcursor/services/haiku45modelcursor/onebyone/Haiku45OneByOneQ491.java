package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 491: Double Pandigital Numbers Divisible by 11
 * Count positive integers using digits 0-9 exactly twice with no leading zero
 * that are divisible by 11
 */
@Service
public class Haiku45OneByOneQ491 {

    public ResponseDto Question491() {
        ResponseDto responseDto = new ResponseDto();

        // Generate all permutations of a double pandigital number
        // A double pandigital has each digit 0-9 appearing exactly twice
        int[] digits = new int[20];
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            digits[idx++] = i;
            digits[idx++] = i;
        }

        long count = 0;
        long[] permutations = generatePermutationsAndCheckDivisibility(digits);
        count = permutations[0];

        Long result = count;
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long[] generatePermutationsAndCheckDivisibility(int[] digits) {
        long[] result = new long[1];
        result[0] = 0;
        permute(digits, 0, result);
        return result;
    }

    private void permute(int[] arr, int l, long[] count) {
        if (l == arr.length - 1) {
            // Skip if first digit is 0 (no leading zero)
            if (arr[0] != 0 && isDivisibleBy11(arr)) {
                count[0]++;
            }
        } else {
            for (int i = l; i < arr.length; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, count);
                swap(arr, l, i);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isDivisibleBy11(int[] digits) {
        // Divisibility rule for 11: alternating sum of digits is divisible by 11
        int alternatingSum = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                alternatingSum += digits[i];
            } else {
                alternatingSum -= digits[i];
            }
        }
        return alternatingSum % 11 == 0;
    }
}
