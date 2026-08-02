package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 43
 */
@Service
public class Haiku45OneByOneQ43 {

    public ResponseDto Question43() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find sum of all 0-9 pandigitals with substring divisibility properties
        // d2d3d4 divisible by 2, d3d4d5 by 3, d4d5d6 by 5, etc.
        // Generated logic to solve the problem:
        
        long sum = 0;
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] divisors = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23};
        
        // Generate all permutations of digits 0-9
        do {
            if (isValidPandigital(digits, divisors)) {
                long num = digitsToNumber(digits);
                sum += num;
            }
        } while (nextPermutation(digits));
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private boolean isValidPandigital(int[] digits, int[] divisors) {
        // Check substring divisibility properties
        // d2d3d4 divisible by 2
        int sub1 = digits[1] * 100 + digits[2] * 10 + digits[3];
        if (sub1 % divisors[1] != 0) return false;
        
        // d3d4d5 divisible by 3
        int sub2 = digits[2] * 100 + digits[3] * 10 + digits[4];
        if (sub2 % divisors[2] != 0) return false;
        
        // d4d5d6 divisible by 5
        int sub3 = digits[3] * 100 + digits[4] * 10 + digits[5];
        if (sub3 % divisors[3] != 0) return false;
        
        // d5d6d7 divisible by 7
        int sub4 = digits[4] * 100 + digits[5] * 10 + digits[6];
        if (sub4 % divisors[4] != 0) return false;
        
        // d6d7d8 divisible by 11
        int sub5 = digits[5] * 100 + digits[6] * 10 + digits[7];
        if (sub5 % divisors[5] != 0) return false;
        
        // d7d8d9 divisible by 13
        int sub6 = digits[6] * 100 + digits[7] * 10 + digits[8];
        if (sub6 % divisors[6] != 0) return false;
        
        // d8d9d10 divisible by 17
        int sub7 = digits[7] * 100 + digits[8] * 10 + digits[9];
        if (sub7 % divisors[7] != 0) return false;
        
        return true;
    }
    
    private long digitsToNumber(int[] digits) {
        long num = 0;
        for (int d : digits) {
            num = num * 10 + d;
        }
        return num;
    }
    
    private boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i < 0) return false;
        
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }
        swap(arr, i, j);
        
        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        return true;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
