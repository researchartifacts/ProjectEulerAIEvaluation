package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 482: Integer-sided Triangles with Integral Inradii Segments
 * 
 * Find the sum of L values for all integer-sided triangles where the segments
 * from incenter to vertices (IA, IB, IC) are also integers, with perimeter ≤ 10^7.
 * L = perimeter + |IA| + |IB| + |IC|
 */
@Service
public class Haiku45OneByOneQ482 {

    public ResponseDto Question482() {
        ResponseDto responseDto = new ResponseDto();

        long maxPerimeter = 10_000_000L;
        long sumL = 0;

        // For a triangle with sides a, b, c and inradius r:
        // s = (a+b+c)/2 (semiperimeter)
        // Area = sqrt(s(s-a)(s-b)(s-c)) (Heron's formula)
        // r = Area / s
        //
        // Distance from incenter to vertex K can be calculated as:
        // |IA| = r / sin(A/2), etc.
        // But we need |IA|, |IB|, |IC| to be integers

        // Iterate through possible triangles
        for (long a = 1; a < maxPerimeter; a++) {
            for (long b = a; b < maxPerimeter; b++) {
                for (long c = b; c < maxPerimeter; c++) {
                    long p = a + b + c;
                    if (p > maxPerimeter) break;

                    // Triangle inequality
                    if (a + b <= c) continue;

                    // Calculate semiperimeter
                    if ((a + b + c) % 2 != 0) continue; // Need integer calculations
                    
                    long s2 = a + b + c; // 2*s
                    long s_a = s2 / 2 - a;
                    long s_b = s2 / 2 - b;
                    long s_c = s2 / 2 - c;

                    // Area squared by Heron's formula: Area^2 = s(s-a)(s-b)(s-c)
                    long areaSquared = (s2 / 2) * s_a * s_b * s_c;
                    long area = (long) Math.sqrt(areaSquared);
                    
                    // Check if area is exact
                    if (area * area != areaSquared) continue;

                    // For integral distances from incenter to vertices:
                    // |IA|^2 = r^2 + (s-a)^2, where r = Area/s
                    // This requires specific angle relationships
                    
                    long s = s2 / 2;
                    long rNumerator = area;
                    long rDenominator = s;

                    // Calculate distances using formula: |IK|^2 = r^2 + (s - opposite_side)^2
                    // For integral check, compute as fractions
                    double r = (double) rNumerator / rDenominator;
                    
                    double ia2 = r * r + (s - a) * (s - a);
                    double ib2 = r * r + (s - b) * (s - b);
                    double ic2 = r * r + (s - c) * (s - c);
                    
                    double ia = Math.sqrt(ia2);
                    double ib = Math.sqrt(ib2);
                    double ic = Math.sqrt(ic2);
                    
                    // Check if distances are integers (within floating point tolerance)
                    if (Math.abs(ia - Math.round(ia)) < 1e-9 && 
                        Math.abs(ib - Math.round(ib)) < 1e-9 && 
                        Math.abs(ic - Math.round(ic)) < 1e-9) {
                        
                        long iaInt = Math.round(ia);
                        long ibInt = Math.round(ib);
                        long icInt = Math.round(ic);
                        
                        long L = p + iaInt + ibInt + icInt;
                        sumL += L;
                    }
                }
            }
        }

        responseDto.setAnswer(sumL);
        return responseDto;
    }
}
