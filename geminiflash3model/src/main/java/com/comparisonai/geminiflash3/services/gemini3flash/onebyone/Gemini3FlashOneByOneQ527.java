package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ527 {

    public ResponseDto Question527() {
        ResponseDto responseDto = new ResponseDto();
        long n = 10000000000L;
        
        // B(n) = expected guesses in standard binary search.
        // R(n) = expected guesses in random binary search.
        // B(n) = (sum of depths of nodes in a balanced BST) / n.
        // R(n) is related to the Harmonic numbers.
        // R(n) = 2 * H_n - 3 + 2 * H_n / n? (Wait, that's for QuickSort-like search).
        // For R(n), it's 2 * (1 + 1/n) * H_n - 3.
        
        double bn = B(n);
        double rn = R(n);
        
        responseDto.setAnswer(String.format("%.8f", rn - bn));
        return responseDto;
    }

    private double B(long n) {
        // B(n) = (1/n) * sum_{i=1}^n floor(log2(i)) + 1
        // B(n) = (1/n) * ( (n+1)*floor(log2(n)) - 2^(floor(log2(n))+1) + 2 ) + 1
        double log2n = Math.floor(Math.log(n) / Math.log(2));
        double sum = (n + 1) * log2n - Math.pow(2, log2n + 1) + 2;
        return sum / n + 1;
    }

    private double R(long n) {
        // R(n) = 2 * (1 + 1/n) * H_n - 3, where H_n is the nth Harmonic number.
        // H_n approx ln(n) + gamma + 1/(2n)
        double gamma = 0.5772156649;
        double hn = Math.log(n) + gamma + 1.0 / (2 * n);
        return 2 * (1 + 1.0 / n) * hn - 3;
    }
}
