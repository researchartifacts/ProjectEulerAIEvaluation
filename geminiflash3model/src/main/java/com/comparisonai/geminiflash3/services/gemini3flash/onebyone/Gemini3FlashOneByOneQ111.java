package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ111 {

    public ResponseDto Question111() {
        ResponseDto responseDto = new ResponseDto();
        long totalS = 0;
        for (int d = 0; d <= 9; d++) {
            totalS += getS(10, d);
        }
        responseDto.setAnswer(String.valueOf(totalS));
        return responseDto;
    }

    private long getS(int n, int d) {
        for (int m = n - 1; m >= 1; m--) {
            long sum = search(n, m, d, 0, 0, 0);
            if (sum > 0) return sum;
        }
        return 0;
    }

    private long search(int n, int m, int d, int pos, int count, long currentNum) {
        if (pos == n) {
            if (count == m && isPrime(currentNum)) return currentNum;
            return 0;
        }

        long sum = 0;
        int start = (pos == 0) ? 1 : 0;
        for (int digit = start; digit <= 9; digit++) {
            int nextCount = count + (digit == d ? 1 : 0);
            if (nextCount > m) continue;
            if (n - pos - 1 < m - nextCount) continue;
            sum += search(n, m, d, pos + 1, nextCount, currentNum * 10 + digit);
        }
        return sum;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
