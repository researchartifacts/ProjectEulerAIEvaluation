package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ613 {

    public ResponseDto Question613() {
        ResponseDto responseDto = new ResponseDto();
        
        // P = (1/Area) * \iint (\alpha(x,y) / 2\pi) dx dy
        // For a right triangle (0,0), (a,0), (0,b), the integral is:
        // P = (1/2 + (a*log(b/hyp) + b*log(a/hyp)) / (pi * a * b) * Area) ... no.
        // Actually the formula is:
        // P = 1/2 - (a*b*log(a*b/(hyp^2)) + ...) / (2 * pi * Area) ... no.
        
        double a = 40.0;
        double b = 30.0;
        double h = 50.0;
        double area = 0.5 * a * b;
        
        double prob = 0.5 - (a * a * Math.atan(b / a) + b * b * Math.atan(a / b) - a * b) / (2 * Math.PI * area);
        
        responseDto.setAnswer(String.format("%.10f", prob));
        return responseDto;
    }
}
