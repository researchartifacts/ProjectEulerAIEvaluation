package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ587 {

    public ResponseDto Question587() {
        ResponseDto responseDto = new ResponseDto();
        
        // Area of L-section for 1 circle: 1 - pi/4 (assuming radius 1, square side 2)
        // Wait, diagram says square around circle. Radius r, side 2r.
        // Area square = 4r^2, Area circle = pi*r^2. L-section = (4 - pi)r^2 / 4 (one corner).
        // Actually, it's 1 - pi/4 if we consider the unit square corner.
        
        // For n circles, rectangle is 2n by 2.
        // Line from (0,0) to (2n, 2). Equation: y = x/n.
        // Concave triangle is the area below y = x/n and above the first circle's arc.
        
        double lSectionArea = 1 - Math.PI / 4;
        int n = 1;
        while (true) {
            double concaveArea = calculateConcaveArea(n);
            if (concaveArea / lSectionArea < 0.001) {
                break;
            }
            n++;
        }
        
        responseDto.setAnswer(n);
        return responseDto;
    }

    private double calculateConcaveArea(int n) {
        // Line: y = x/n. Circle: (x-1)^2 + (y-1)^2 = 1.
        // Intersection: (x-1)^2 + (x/n - 1)^2 = 1
        // x^2 - 2x + 1 + x^2/n^2 - 2x/n + 1 = 1
        // (1 + 1/n^2)x^2 - 2(1 + 1/n)x + 1 = 0
        // Use quadratic formula for smallest x.
        double a = 1 + 1.0 / (n * n);
        double b = -2 * (1 + 1.0 / n);
        double c = 1;
        double x = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double y = x / n;
        
        // Area = Integral from 0 to x of (x/n) dx + Integral from x to ... of circle?
        // Actually it's triangle (0,0), (x,0), (x,y) + area under circle from x to 1?
        // No, concave triangle is area between y=x/n, y=0, and the circle.
        // Area = area of triangle (0,0), (x, y), (x,0) + area under circle from x to 1? 
        // No, it's the region bounded by (0,0), the line, and the circle.
        
        double triangleArea = 0.5 * x * y;
        // Area under circle (1 - sqrt(1 - (x-1)^2)) from x to 1.
        // Let u = x-1. Integral of (1 - sqrt(1 - u^2)) du from x-1 to 0.
        // = [u - 0.5(u sqrt(1-u^2) + asin(u))] from x-1 to 0.
        double u = x - 1;
        double integral = -(u - 0.5 * (u * Math.sqrt(1 - u * u) + Math.asin(u)));
        
        return triangleArea + integral;
    }
}
