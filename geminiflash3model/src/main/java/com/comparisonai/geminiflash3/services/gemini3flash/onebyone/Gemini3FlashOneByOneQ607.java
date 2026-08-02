package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ607 {

    public ResponseDto Question607() {
        ResponseDto responseDto = new ResponseDto();
        
        double targetV = 50.0 * Math.sqrt(2.0);
        double[] du = {25.0 * Math.sqrt(2.0) - 25.0, 10, 10, 10, 10, 10, 25.0 * Math.sqrt(2.0) - 25.0};
        double[] speeds = {10, 9, 8, 7, 6, 5, 10};
        
        double low = 0, high = 1.0 / 10.0;
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            if (calcV(mid, du, speeds) < targetV) low = mid;
            else high = mid;
        }
        
        double C = low;
        double time = 0;
        for (int i = 0; i < du.length; i++) {
            time += du[i] / (speeds[i] * Math.sqrt(1.0 - Math.pow(speeds[i] * C, 2)));
        }
        
        responseDto.setAnswer(String.format("%.10f", time));
        return responseDto;
    }

    private double calcV(double C, double[] du, double[] speeds) {
        double v = 0;
        for (int i = 0; i < du.length; i++) {
            v += du[i] * (speeds[i] * C) / Math.sqrt(1.0 - Math.pow(speeds[i] * C, 2));
        }
        return v;
    }
}
