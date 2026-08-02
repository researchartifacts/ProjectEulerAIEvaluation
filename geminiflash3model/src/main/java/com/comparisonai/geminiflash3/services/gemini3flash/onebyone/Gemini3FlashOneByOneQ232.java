package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ232 {

    public ResponseDto Question232() {
        ResponseDto responseDto = new ResponseDto();
        int target = 100;
        double[][] E = new double[target + 1][target + 1];
        double[][] F = new double[target + 1][target + 1];
        for (int i = 0; i < target; i++) { E[i][target] = 1.0; F[i][target] = 1.0; }
        for (int iter = 0; iter < 200; iter++) {
            for (int s1 = target - 1; s1 >= 0; s1--) {
                for (int s2 = target - 1; s2 >= 0; s2--) {
                    E[s1][s2] = 0.5 * F[Math.min(target, s1 + 1)][s2] + 0.5 * F[s1][s2];
                    double maxP = 0;
                    for (int T = 1; T <= 8; T++) {
                        double pT = Math.pow(0.5, T);
                        int nextS2 = Math.min(target, s2 + (1 << (T - 1)));
                        double prob = pT * E[s1][nextS2] + (1 - pT) * E[s1][s2];
                        if (prob > maxP) maxP = prob;
                    }
                    F[s1][s2] = maxP;
                }
            }
        }
        responseDto.setAnswer(String.format("%.8f", E[0][0]));
        return responseDto;
    }
}
