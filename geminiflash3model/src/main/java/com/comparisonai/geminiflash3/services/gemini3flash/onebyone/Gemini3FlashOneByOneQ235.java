package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ235 {

    public ResponseDto Question235() {
        ResponseDto responseDto = new ResponseDto();
        double target = -600_000_000_000.0;
        
        double low = 1.0, high = 1.1; // Based on s(5000) behavior
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2;
            if (s(mid) > target) low = mid;
            else high = mid;
        }
        
        responseDto.setAnswer(String.format("%.12f", low));
        return responseDto;
    }

    private double s(double r) {
        double sum = 0;
        double rk = 1.0;
        for (int k = 1; k <= 5000; k++) {
            sum += (900 - 3 * k) * rk;
            rk *= r;
        }
        return sum;
    }
}
