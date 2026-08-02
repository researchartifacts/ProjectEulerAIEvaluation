package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ101 {

    public ResponseDto Question101() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Optimum polynomial - Method of differences
        long[] seq = new long[102];
        for (int n = 1; n <= 101; n++) {
            long val = 1;
            long nPow = 1;
            for (int k = 1; k <= 10; k++) {
                nPow *= n;
                if (k % 2 == 1) val -= nPow;
                else val += nPow;
            }
            seq[n] = val;
        }

        long fitSum = 0;
        for (int k = 1; k <= 10; k++) {
            long[][] diff = new long[12][102];
            for (int i = 1; i <= k; i++) diff[0][i] = seq[i];

            int degree = k;
            for (int d = 1; d <= k; d++) {
                for (int i = 1; i <= k - d; i++) {
                    diff[d][i] = diff[d-1][i+1] - diff[d-1][i];
                }
                boolean constant = true;
                for (int i = 2; i <= k - d; i++) {
                    if (diff[d][i] != diff[d][1]) constant = false;
                }
                if (constant) { degree = d; break; }
            }

            if (degree < k) {
                long next = diff[0][k];
                for (int d = 1; d <= degree; d++) {
                    next += diff[d][1];
                }
                if (next != seq[k+1]) fitSum += next;
            }
        }
        result = fitSum;

        responseDto.setAnswer(result);
        return responseDto;
    }
}

