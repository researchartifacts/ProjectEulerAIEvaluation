package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ144 {

    public ResponseDto Question144() {
        ResponseDto responseDto = new ResponseDto();
        
        double x0 = 0.0, y0 = 10.1;
        double x1 = 1.4, y1 = -9.6;
        int count = 0;
        
        while (true) {
            count++;
            // Normal slope at (x1, y1) is y1 / (4*x1)
            // But the problem says tangent slope is -4x/y. Normal is -1/m = y / (4x).
            double slopeNormal = y1 / (4.0 * x1);
            double slopeIncident = (y1 - y0) / (x1 - x0);
            
            // Reflected slope m2: (m1 - mn) / (1 + m1*mn) = (mn - m2) / (1 + mn*m2)
            // (slopeIncident - slopeNormal) / (1 + slopeIncident * slopeNormal) = (slopeNormal - slopeReflected) / (1 + slopeNormal * slopeReflected)
            double tanTheta = (slopeIncident - slopeNormal) / (1.0 + slopeIncident * slopeNormal);
            double slopeReflected = (slopeNormal - tanTheta) / (1.0 + slopeNormal * tanTheta);
            
            // Next intersection of y - y1 = m*(x - x1) and 4x^2 + y^2 = 100
            // y = m*x + (y1 - m*x1)
            // Let c = y1 - m*x1
            // 4x^2 + (mx + c)^2 = 100
            // (4 + m^2)x^2 + 2mcx + c^2 - 100 = 0
            // Quadratic equation Ax^2 + Bx + C = 0
            double m = slopeReflected;
            double c = y1 - m * x1;
            double A = 4.0 + m * m;
            double B = 2.0 * m * c;
            double C = c * m - 100.0; // Wait, C = c^2 - 100
            C = c * c - 100.0;
            
            // Roots: x = (-B +/- sqrt(B^2 - 4AC)) / 2A
            // One root is x1. The other is -B/A - x1.
            double nextX = -B / A - x1;
            double nextY = m * nextX + c;
            
            if (nextY > 0 && Math.abs(nextX) <= 0.01) {
                break;
            }
            
            x0 = x1;
            y0 = y1;
            x1 = nextX;
            y1 = nextY;
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }
}
