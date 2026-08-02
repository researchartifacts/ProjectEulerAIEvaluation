package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ23 {

    public ResponseDto Question23() {
        ResponseDto responseDto = new ResponseDto();
        boolean[] isAbundant = new boolean[28124];
        for (int i = 1; i < 28124; i++) {
            if (sumOfDivisors(i) > i) {
                isAbundant[i] = true;
            }
        }
        long sum = 0;
        for (int i = 1; i < 28124; i++) {
            boolean canBeExpressed = false;
            for (int j = 1; j < i; j++) {
                if (isAbundant[j] && isAbundant[i - j]) {
                    canBeExpressed = true;
                    break;
                }
            }
            if (!canBeExpressed) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i && i != 1) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
