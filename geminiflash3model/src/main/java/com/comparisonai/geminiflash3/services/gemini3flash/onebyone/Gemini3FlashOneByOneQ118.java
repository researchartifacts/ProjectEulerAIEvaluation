package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ118 {

    private int count = 0;

    public ResponseDto Question118() {
        ResponseDto responseDto = new ResponseDto();
        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        permute(digits, 0);
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

    private void permute(int[] digits, int start) {
        if (start == digits.length) {
            countSets(digits, 0, 0);
            return;
        }
        for (int i = start; i < digits.length; i++) {
            swap(digits, start, i);
            permute(digits, start + 1);
            swap(digits, start, i);
        }
    }

    private void countSets(int[] digits, int pos, int prevPrime) {
        if (pos == digits.length) {
            count++;
            return;
        }
        int num = 0;
        for (int i = pos; i < digits.length; i++) {
            num = num * 10 + digits[i];
            if (num > prevPrime && isPrime(num)) {
                countSets(digits, i + 1, num);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
