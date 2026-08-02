package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ226 {

    public ResponseDto Question226() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 226: Area under blancmange curve enclosed by circle
        // Circle: center (1/4, 1/2), radius 1/4
        // Blancmange curve: y = sum(s(2^n * x) / 2^n) where s(x) = distance to nearest integer

        double circleCenterX = 0.25;
        double circleCenterY = 0.5;
        double circleRadius = 0.25;

        double area = calculateEnclosedArea(circleCenterX, circleCenterY, circleRadius);

        String result = String.format("%.8f", area);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private double calculateEnclosedArea(double cx, double cy, double r) {
        // Numerically integrate the blancmange curve within the circle
        // Use monte carlo or numerical integration

        int samples = 100000;
        double enclosed = 0;

        for (int i = 0; i < samples; i++) {
            double x = Math.random();
            double y = calculateBlancmangeY(x);

            // Check if point is within circle
            double dx = x - cx;
            double dy = y - cy;
            if (dx * dx + dy * dy <= r * r) {
                enclosed++;
            }
        }

        return enclosed / samples * 1.0; // Estimate of area
    }

    private double calculateBlancmangeY(double x) {
        // Calculate y value of blancmange curve at x
        // y = sum_{n=0}^{infinity} s(2^n * x) / 2^n

        double y = 0;

        for (int n = 0; n < 20; n++) { // 20 terms should be sufficient
            double scaled = Math.pow(2, n) * x;
            double s = getDistanceToNearestInteger(scaled);
            y += s / Math.pow(2, n);
        }

        return y;
    }

    private double getDistanceToNearestInteger(double x) {
        // Distance from x to nearest integer
        double fractional = x - Math.floor(x);
        return Math.min(fractional, 1.0 - fractional);
    }
}
