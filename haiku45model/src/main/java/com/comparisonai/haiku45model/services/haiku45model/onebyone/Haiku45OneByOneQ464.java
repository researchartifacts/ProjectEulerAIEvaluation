package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ464 {

    public ResponseDto Question464() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 100;

        for (int start = 2; start <= limit; start++) {
            for (int end = start; end <= limit; end++) {
                int positiveCount = 0;
                int negativeCount = 0;

                for (int n = start; n <= end; n++) {
                    if (moebiusFunction(n) == 1) positiveCount++;
                    else if (moebiusFunction(n) == -1) negativeCount++;
                }

                if (positiveCount == negativeCount) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private int moebiusFunction(int n) {
        if (n == 1) return 1;
        int primeFactors = 0;
        int temp = n;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (temp % (i * i) == 0) return 0;
                primeFactors++;
                while (temp % i == 0) temp /= i;
            }
        }

        if (temp > 1) primeFactors++;
        return primeFactors % 2 == 0 ? 1 : -1;
    }
}
