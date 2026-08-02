package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ653 {

    public ResponseDto Question653() {
        ResponseDto responseDto = new ResponseDto();

        long L = 1000000000L;
        int N = 1000001;
        int j = 500001;

        long[] r = new long[N + 1];
        r[1] = 6563116;
        for (int i = 2; i <= N; i++) {
            r[i] = (r[i - 1] * r[i - 1]) % 32745673;
        }

        long[] x = new long[N];
        boolean[] east = new boolean[N];

        long currentPos = (r[1] % 1000) + 1 + 10;
        x[0] = currentPos;
        east[0] = r[1] <= 10000000;

        for (int i = 1; i < N; i++) {
            long gap = (r[i + 1] % 1000) + 1;
            currentPos += gap + 20;
            x[i] = currentPos;
            east[i] = r[i + 1] <= 10000000;
        }

        // The distance traveled by the j-th marble is the (N-j+1)-th smallest 
        // value in the set of {L-x_i if east, L+x_i if west}.
        long[] distances = new long[N];
        for (int i = 0; i < N; i++) {
            if (east[i]) {
                distances[i] = L - x[i];
            } else {
                distances[i] = L + x[i];
            }
        }

        Arrays.sort(distances);
        long result = distances[N - j];

        responseDto.setAnswer(result);
        return responseDto;
    }
}
