package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ58 {

    public ResponseDto Question58() {
        ResponseDto responseDto = new ResponseDto();
        long diagCount = 0;
        long primeCount = 0;
        long sideLength = 1;
        while (true) {
            sideLength += 2;
            long baseNum = (sideLength - 1) * (sideLength - 1) + 1;
            for (int i = 0; i < 4; i++) {
                baseNum += (sideLength - 1);
                if (isPrime(baseNum)) {
                    primeCount++;
                }
                diagCount++;
            }
            if (diagCount > 0 && primeCount * 10 < diagCount) {
                responseDto.setAnswer(sideLength);
                return responseDto;
            }
        }
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
