package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ583 {

    public ResponseDto Question583() {
        ResponseDto responseDto = new ResponseDto();
        long pLimit = 10000000;
        long totalPerimeterSum = 0;
        
        // Envelope: Isosceles triangle (flap) on rectangle.
        // Let rectangle be w by h, flap height be f.
        // w, h, f must be such that sides and diagonals are integral.
        // Rectangle sides: w, h. Diagonals: sqrt(w^2 + h^2) must be int.
        // Flap: sides s, s, w. Height f = sqrt(s^2 - (w/2)^2).
        // f < h.
        // Diagonals of envelope: AC, AD, BD, BE, CE.
        // Perimeters sum S(10^7).
        
        for (long w = 2; w < pLimit / 2; w += 2) {
            for (long h = 1; h < pLimit / 2; h++) {
                long d2 = w * w + h * h;
                long d = (long) Math.sqrt(d2);
                if (d * d != d2) continue;
                
                for (long f = 1; f < h; f++) {
                    long s2 = f * f + (w / 2) * (w / 2);
                    long s = (long) Math.sqrt(s2);
                    if (s * s != s2) continue;
                    
                    // Check other diagonals
                    long diag1_2 = (h + f) * (h + f) + (w / 2) * (w / 2);
                    long diag1 = (long) Math.sqrt(diag1_2);
                    if (diag1 * diag1 != diag1_2) continue;
                    
                    long perimeter = 2 * h + 2 * s + w;
                    if (perimeter <= pLimit) {
                        totalPerimeterSum += perimeter;
                    }
                }
            }
        }

        responseDto.setAnswer(totalPerimeterSum);
        return responseDto;
    }
}
