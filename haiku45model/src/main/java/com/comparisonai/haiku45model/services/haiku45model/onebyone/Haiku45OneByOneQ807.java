package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ807 {

    public ResponseDto Question807() {
        ResponseDto responseDto = new ResponseDto();

        int n = 80;
        double probability = calculateProbability(n);

        responseDto.setAnswer(Math.round(probability * 10000000000.0) / 10000000000.0);
        return responseDto;
    }

    private double calculateProbability(int n) {
        double simulations = 100000;
        int separable = 0;

        for (int i = 0; i < simulations; i++) {
            if (canBeSeparated(n)) {
                separable++;
            }
        }

        return separable / simulations;
    }

    private boolean canBeSeparated(int n) {
        double[] redAngles = new double[n + 1];
        double[] blueAngles = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            redAngles[i] = Math.random() * 2 * Math.PI;
            blueAngles[i] = Math.random() * 2 * Math.PI;
        }

        int redIntersections = 0;
        int blueIntersections = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (doSegmentsIntersect(redAngles[i], redAngles[i + 1], redAngles[j], redAngles[j + 1])) {
                    redIntersections++;
                }
                if (doSegmentsIntersect(blueAngles[i], blueAngles[i + 1], blueAngles[j], blueAngles[j + 1])) {
                    blueIntersections++;
                }
            }
        }

        return (redIntersections % 2) == (blueIntersections % 2);
    }

    private boolean doSegmentsIntersect(double a1, double a2, double b1, double b2) {
        return (a1 < b1 && b1 < a2 && a2 < b2) || (b1 < a1 && a1 < b2 && b2 < a2);
    }
}
