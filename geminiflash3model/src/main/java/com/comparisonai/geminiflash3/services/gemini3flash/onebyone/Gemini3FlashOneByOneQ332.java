package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ332 {

    public ResponseDto Question332() {
        ResponseDto responseDto = new ResponseDto();
        
        double totalArea = 0;
        for (int r = 1; r <= 50; r++) {
            totalArea += getMinArea(r);
        }
        
        responseDto.setAnswer(String.format("%.6f", totalArea));
        return responseDto;
    }
    
    private double getMinArea(int r) {
        List<int[]> points = new ArrayList<>();
        int r2 = r * r;
        for (int x = -r; x <= r; x++) {
            for (int y = -r; y <= r; y++) {
                int rem = r2 - x * x - y * y;
                if (rem < 0) continue;
                int z = (int) Math.sqrt(rem);
                if (z * z == rem) {
                    points.add(new int[]{x, y, z});
                    if (z > 0) points.add(new int[]{x, y, -z});
                }
            }
        }
        
        double minA = Double.MAX_VALUE;
        int n = points.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = sphericalArea(points.get(i), points.get(j), points.get(k), r);
                    if (area > 1e-10 && area < minA) {
                        minA = area;
                    }
                }
            }
        }
        return minA == Double.MAX_VALUE ? 0 : minA;
    }
    
    private double sphericalArea(int[] A, int[] B, int[] C, int r) {
        // Area = r^2 * (E) where E is the spherical excess
        // tan(E/4) = sqrt(tan(s/2)tan((s-a)/2)tan((s-b)/2)tan((s-c)/2))
        // where a, b, c are side lengths (angles)
        
        double a = angle(A, B);
        double b = angle(B, C);
        double c = angle(C, A);
        
        if (Math.abs(a + b - c) < 1e-10 || Math.abs(a + c - b) < 1e-10 || Math.abs(b + c - a) < 1e-10) return 0;
        
        double s = (a + b + c) / 2.0;
        double tanE4 = Math.sqrt(Math.max(0, Math.tan(s/2.0) * Math.tan((s-a)/2.0) * Math.tan((s-b)/2.0) * Math.tan((s-c)/2.0)));
        return 4.0 * r * r * Math.atan(tanE4);
    }
    
    private double angle(int[] P1, int[] P2) {
        double dot = P1[0]*P2[0] + P1[1]*P2[1] + P1[2]*P2[2];
        double r2 = P1[0]*P1[0] + P1[1]*P1[1] + P1[2]*P1[2];
        return Math.acos(Math.max(-1.0, Math.min(1.0, dot / r2)));
    }
}
