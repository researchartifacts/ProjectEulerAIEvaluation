package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class Gemini3FlashOneByOneQ666 {

    public ResponseDto Question666() {
        ResponseDto responseDto = new ResponseDto();

        int k = 500;
        int m = 10;
        
        int[] r = new int[k * m];
        r[0] = 306;
        for (int i = 1; i < k * m; i++) {
            r[i] = (int) (((long) r[i - 1] * r[i - 1]) % 10007);
        }

        double[][] p = new double[k][5];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                int q = r[i * m + j] % 5;
                p[i][q] += 1.0 / m;
            }
        }

        double[] x = new double[k];
        Arrays.fill(x, 0.5); // Initial guess

        for (int iter = 0; iter < 1000; iter++) {
            double[] nextX = new double[k];
            double maxDiff = 0;
            for (int i = 0; i < k; i++) {
                nextX[i] = p[i][0] 
                        + p[i][1] * x[i] * x[i] 
                        + p[i][2] * x[(2 * i) % k]
                        + p[i][3] * Math.pow(x[(i * i + 1) % k], 3)
                        + p[i][4] * x[i] * x[(i + 1) % k];
                maxDiff = Math.max(maxDiff, Math.abs(nextX[i] - x[i]));
            }
            x = nextX;
            if (maxDiff < 1e-12) break;
        }

        responseDto.setAnswer(Math.round(x[0] * 100000000.0) / 100000000.0);
        return responseDto;
    }
}
