package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 41
 */
@Service
public class Haiku45OneByOneQ41 {

    public ResponseDto Question41() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the largest n-digit pandigital prime
        // Generated logic to solve the problem:
        long largestPandigitalPrime = 0;
        
        // Check from 9-digit pandigitals down to 1-digit
        for (int n = 9; n >= 1; n--) {
            largestPandigitalPrime = findLargestPandigitalPrimeWithDigits(n);
            if (largestPandigitalPrime > 0) {
                break;
            }
        }
        
        Object result = largestPandigitalPrime;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long findLargestPandigitalPrimeWithDigits(int n) {
        // Generate all n-digit pandigitals in descending order
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = i + 1; // 1 to n
        }
        
        // Permute in reverse order
        long result = 0;
        do {
            long num = 0;
            for (int d : digits) {
                num = num * 10 + d;
            }
            if (isPrime(num)) {
                return num;
            }
        } while (prevPermutation(digits));
        
        return result;
    }
    
    private boolean prevPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) return false;
        
        int j = arr.length - 1;
        while (arr[j] >= arr[i]) {
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
    
    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
