package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class Gemini3FlashOneByOneQ751 {

    public ResponseDto Question751() {
        ResponseDto responseDto = new ResponseDto();
        
        // Find theta such that theta = 2.a2a3a4... where a1 = 2
        // b1 = theta, b_n = floor(b_{n-1})(b_{n-1} - floor(b_{n-1}) + 1), a_n = floor(b_n)
        // This is a fixed point iteration or root finding problem.
        // For theta = a1.a2a3... to hold, theta = a1 + a2/10 + a3/100 + ...
        // Since we need 24 decimal places, we can use an iterative approach to find theta.
        
        MathContext mc = new MathContext(50);
        BigDecimal theta = new BigDecimal("2.2222222222222222222222222222222222222222", mc);
        
        for (int iter = 0; iter < 100; iter++) {
            BigDecimal currentTheta = theta;
            StringBuilder sb = new StringBuilder("2.");
            BigDecimal b = theta;
            for (int n = 2; n <= 30; n++) {
                BigDecimal floorB = b.setScale(0, RoundingMode.FLOOR);
                b = floorB.multiply(b.subtract(floorB).add(BigDecimal.ONE));
                BigDecimal an = b.setScale(0, RoundingMode.FLOOR);
                String s = an.toPlainString();
                sb.append(s);
            }
            if (sb.length() > 26) {
                theta = new BigDecimal(sb.substring(0, 26), mc);
            }
            if (theta.equals(currentTheta)) break;
        }
        
        responseDto.setAnswer(theta.setScale(24, RoundingMode.HALF_UP).toPlainString());
        return responseDto;
    }
}
