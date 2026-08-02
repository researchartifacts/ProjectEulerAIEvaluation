package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ810 {

    public ResponseDto Question810() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;

        for (int x = 1; x <= 100; x++) {
            for (int y = 1; y <= 100; y++) {
                long xorProduct = xorProduct(x, y);
                if (xorProduct == 0 || !isXorPrime(xorProduct)) {
                    continue;
                }
            }
        }

        int count = 0;
        int num = 2;
        while (count < 5000000) {
            if (isXorPrime(num)) {
                count++;
                if (count == 5000000) {
                    result = num;
                }
            }
            num++;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long xorProduct(int x, int y) {
        long result = 0;
        long shift = 0;
        while (y > 0) {
            if ((y & 1) == 1) {
                result ^= (long) x << shift;
            }
            y >>= 1;
            shift++;
        }
        return result;
    }

    private boolean isXorPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; j <= Math.sqrt(n); j++) {
                if (xorProduct(i, j) == n) {
                    return false;
                }
            }
        }
        return true;
    }
}
