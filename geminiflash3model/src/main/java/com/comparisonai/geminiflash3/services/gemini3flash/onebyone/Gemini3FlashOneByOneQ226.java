package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ226 {

    public ResponseDto Question226() {
        ResponseDto responseDto = new ResponseDto();
        
        // Blancmange curve Area calculation
        // Circle: (x-1/4)^2 + (y-1/2)^2 = (1/4)^2
        // y = 1/2 +/- sqrt(1/16 - (x-1/4)^2)
        // We need area under curve and inside circle.
        // Intersection points: x=0 to x=0.5
        
        double area = integrate(0, 0.5, 1000000);
        responseDto.setAnswer(String.format("%.8f", area));
        return responseDto;
    }

    private double integrate(double a, double b, int n) {
        double h = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double x = a + (i + 0.5) * h;
            double curveY = blancmange(x);
            double circleYLow = 0.5 - Math.sqrt(Math.max(0, 1.0/16.0 - (x - 0.25) * (x - 0.25)));
            if (curveY > circleYLow) {
                double circleYHigh = 0.5 + Math.sqrt(Math.max(0, 1.0/16.0 - (x - 0.25) * (x - 0.25)));
                sum += Math.min(curveY, circleYHigh) - circleYLow;
            }
        }
        return sum * h;
    }

    private double blancmange(double x) {
        double y = 0;
        double pow2 = 1;
        for (int n = 0; n < 40; n++) {
            y += s(pow2 * x) / pow2;
            pow2 *= 2;
        }
        return y;
    }

    private double s(double x) {
        return Math.abs(x - Math.round(x));
    }
}
