package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ41 {

    public ResponseDto Question41() {
        ResponseDto responseDto = new ResponseDto();
        // Largest possible pandigital prime must be 7 digits (8 and 9 digits are always divisible by 3)
        for (int i = 7654321; i >= 1234567; i--) {
            if (isPandigital(String.valueOf(i), 7) && isPrime(i)) {
                responseDto.setAnswer(i);
                return responseDto;
            }
        }
        return responseDto;
    }

    private boolean isPandigital(String s, int n) {
        if (s.length() != n) return false;
        boolean[] used = new boolean[n + 1];
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (d == 0 || d > n || used[d]) return false;
            used[d] = true;
        }
        return true;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
}
