package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ352 {

    public ResponseDto Question352() {
        ResponseDto responseDto = new ResponseDto();
        int maxS = 10000;
        double totalT = 0;

        for (int pInt = 1; pInt <= 50; pInt++) {
            double p = pInt / 100.0;
            totalT += T(maxS, p);
        }

        responseDto.setAnswer(String.format("%.6f", totalT));
        return responseDto;
    }

    private double T(int s, double p) {
        double[] f = new double[s + 1]; // f[n] = min tests for n sheep
        double[] g = new double[s + 1]; // g[n] = min tests for n sheep given at least one infected

        f[0] = 0;
        g[0] = 0;
        f[1] = 1;
        g[1] = 0;

        double q = 1 - p;
        for (int n = 2; n <= s; n++) {
            // Calculate g[n]
            double minG = n; // Worst case: test each individually
            for (int k = 1; k < n; k++) {
                double probK = (1 - Math.pow(q, k)) / (1 - Math.pow(q, n));
                double val = 1 + probK * g[k] + (1 - probK) * g[n - k];
                // Note: if k tests negative, we know n-k has at least one, so we use g[n-k]
                // If k tests positive, we use g[k] and then we don't know about n-k, so we add f[n-k]
                // Wait, the restriction: "all contributing to that sample must be fully screened"
                // This means if we test k and it's positive, we finish k. Then we still need to screen n-k.
                val = 1 + probK * (g[k] + f[n - k]) + (1 - probK) * g[n - k];
                if (val < minG) minG = val;
            }
            g[n] = minG;

            // Calculate f[n]
            double minF = n;
            for (int k = 1; k <= n; k++) {
                double probK = 1 - Math.pow(q, k);
                double val = 1 + probK * (g[k] + f[n - k]) + (1 - probK) * f[n - k];
                if (val < minF) minF = val;
            }
            f[n] = minF;
        }

        return f[s];
    }
}
