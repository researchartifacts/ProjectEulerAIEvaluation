package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ826 {

    public ResponseDto Question826() {
        ResponseDto responseDto = new ResponseDto();

        double sum = 0;
        int count = 0;

        for (int p = 2; p < 1000000; p++) {
            if (isPrime(p) && p % 2 == 1) {
                double paintedLength = calculateExpectedPaintedLength(p);
                sum += paintedLength;
                count++;
            }
        }

        double average = (count > 0) ? sum / count : 0;

        responseDto.setAnswer(Math.round(average * 10000000000.0) / 10000000000.0);
        return responseDto;
    }

    private double calculateExpectedPaintedLength(int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += 1.0 / (n + 1);
        }
        return total;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
