package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ45 {

    public ResponseDto Question45() {
        ResponseDto responseDto = new ResponseDto();
        long index = 2;
        while (true) {
            long pentagonal = index * (3 * index - 1) / 2;
            if (isHexagonal(pentagonal)) {
                long sqrtTri = (long) (Math.sqrt(1 + 8.0 * pentagonal) - 1) / 2;
                if (sqrtTri * (sqrtTri + 1) / 2 == pentagonal) {
                    responseDto.setAnswer(pentagonal);
                    return responseDto;
                }
            }
            index++;
        }
    }

    private boolean isHexagonal(long n) {
        long sqrt = (long) Math.sqrt(n);
        for (long i = Math.max(1, sqrt - 2); i <= sqrt + 2; i++) {
            if (i * (2 * i - 1) == n) {
                return true;
            }
        }
        return false;
    }
}
