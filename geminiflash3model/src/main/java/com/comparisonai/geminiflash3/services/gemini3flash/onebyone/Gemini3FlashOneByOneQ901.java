package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ901 {

    public ResponseDto Question901() {
        ResponseDto responseDto = new ResponseDto();
        // The expected drilling time E for a sequence of depths d_1, d_2, ... is
        // E = d_1 + e^{-d_1} d_2 + e^{-d_2} d_3 + ...
        // Assuming d_k = k * x, E = x / (1 - e^{-x})^2
        // Minimizing E gives e^x = 1 + 2x
        
        double low = 1.0;
        double high = 2.0;
        for (int i = 0; i < 100; i++) {
            double mid = (low + high) / 2.0;
            if (Math.exp(mid) < 1 + 2 * mid) {
                low = mid;
            } else {
                high = mid;
            }
        }
        double x = low;
        double result = x / Math.pow(1 - Math.exp(-x), 2);
        
        responseDto.setAnswer(String.format("%.9f", result));
        return responseDto;
    }
}
