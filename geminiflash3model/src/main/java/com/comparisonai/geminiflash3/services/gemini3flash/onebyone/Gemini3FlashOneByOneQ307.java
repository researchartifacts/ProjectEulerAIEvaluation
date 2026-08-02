package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
public class Gemini3FlashOneByOneQ307 {

    public ResponseDto Question307() {
        ResponseDto responseDto = new ResponseDto();
        
        int k = 20000;
        int n = 1000000;
        
        // Probability p(k, n) = 1 - P(no chip has >= 3 defects)
        // P(no chip has >= 3 defects) = sum_{x=0}^{k/2} [n! / (x! * (k-2x)! * (n-k+x)!)] * [k! / 2^x] / n^k
        
        BigDecimal probNoThree = BigDecimal.ZERO;
        MathContext mc = new MathContext(50);
        
        // Using log-based approach for large factorials and powers
        double logTotal = k * Math.log(n);
        
        for (int x = 0; x <= k / 2; x++) {
            int y = k - 2 * x;
            int z = n - k + x;
            
            double logWays = logFactorial(n) - logFactorial(x) - logFactorial(y) - logFactorial(z)
                           + logFactorial(k) - x * Math.log(2);
            
            probNoThree = probNoThree.add(new BigDecimal(Math.exp(logWays - logTotal)));
        }
        
        BigDecimal result = BigDecimal.ONE.subtract(probNoThree).setScale(10, RoundingMode.HALF_UP);
        
        responseDto.setAnswer(result.toString());
        return responseDto;
    }

    private double logFactorial(int n) {
        double res = 0;
        for (int i = 2; i <= n; i++) {
            res += Math.log(i);
        }
        return res;
    }
}
