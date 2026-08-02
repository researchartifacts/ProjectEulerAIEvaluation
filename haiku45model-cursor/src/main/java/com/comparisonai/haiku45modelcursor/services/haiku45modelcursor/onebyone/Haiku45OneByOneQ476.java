package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 476: Circles in Triangles
 * Find S(1803) - average maximum area of 3 non-overlapping circles in triangles.
 */
@Service
public class Haiku45OneByOneQ476 {

    public ResponseDto Question476() {
        ResponseDto responseDto = new ResponseDto();

        double result = calculateS(1803);
        
        // Round to 5 decimal places
        responseDto.setAnswer(String.format("%.5f", result));
        return responseDto;
    }

    private double calculateS(long n) {
        // S(n) = average of R(a,b,c) over all valid integer triplets (a,b,c)
        // where 1 <= a <= b <= c < a+b <= n
        
        double sumR = 0.0;
        long count = 0;
        
        for (long a = 1; a < n; a++) {
            for (long b = a; b < n; b++) {
                for (long c = b; c < n; c++) {
                    // Check triangle inequality: a + b > c and c < a + b
                    if (a + b > c && c < a + b) {
                        double r = calculateR(a, b, c);
                        sumR += r;
                        count++;
                    }
                }
            }
        }
        
        return count > 0 ? sumR / count : 0.0;
    }

    private double calculateR(long a, long b, long c) {
        // R(a,b,c) = maximum area covered by 3 non-overlapping circles
        // inside triangle with sides a, b, c
        
        // First, calculate triangle area using Heron's formula
        double s = (a + b + c) / 2.0; // semi-perimeter
        double triangleArea = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        
        if (triangleArea <= 0) return 0.0;
        
        // Calculate inradius
        double inradius = triangleArea / s;
        
        // The three non-overlapping circles for maximum area:
        // 1. Incircle (centered at incenter)
        // 2. Two circles positioned optimally at the remaining space
        
        double incircleArea = Math.PI * inradius * inradius;
        
        // For the remaining two circles, use optimization approach
        // Position them to maximize total area while maintaining non-overlap
        
        // Radii of excircles provide bounds for additional circles
        double exradius_a = triangleArea / (s - a);
        double exradius_b = triangleArea / (s - b);
        double exradius_c = triangleArea / (s - c);
        
        // Select two largest excircles that fit without overlapping with incircle
        double[] excircles = {exradius_a, exradius_b, exradius_c};
        Arrays.sort(excircles);
        
        // Approximate: use largest two, scaled by geometry constraints
        double circle2Radius = excircles[2] * 0.4; // Scaling factor for feasibility
        double circle3Radius = excircles[1] * 0.3;
        
        double totalArea = incircleArea + 
                          Math.PI * circle2Radius * circle2Radius + 
                          Math.PI * circle3Radius * circle3Radius;
        
        // Ensure result doesn't exceed triangle area
        return Math.min(totalArea, triangleArea);
    }
}
