package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ814 {

    public ResponseDto Question814() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 998244353L;
        int n = 1000;
        long result = countScreamingConfigurations(n) % MOD;

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countScreamingConfigurations(int n) {
        int totalPeople = 4 * n;
        long count = 0;

        for (long config = 0; config < Math.pow(3, totalPeople); config++) {
            int[] looks = new int[totalPeople];
            long temp = config;
            for (int i = 0; i < totalPeople; i++) {
                looks[i] = (int) (temp % 3);
                temp /= 3;
            }

            int screamingCount = 0;
            for (int i = 0; i < totalPeople; i++) {
                int target;
                if (looks[i] == 0) {
                    target = (i - 1 + totalPeople) % totalPeople;
                } else if (looks[i] == 1) {
                    target = (i + 1) % totalPeople;
                } else {
                    target = (i + totalPeople / 2) % totalPeople;
                }

                if (looks[target] == 0 && target == (i - 1 + totalPeople) % totalPeople) {
                    screamingCount++;
                } else if (looks[target] == 1 && target == (i + 1) % totalPeople) {
                    screamingCount++;
                } else if (looks[target] == 2 && target == (i + totalPeople / 2) % totalPeople) {
                    screamingCount++;
                }
            }

            if (screamingCount == totalPeople / 2) {
                count++;
            }
        }

        return count;
    }
}
