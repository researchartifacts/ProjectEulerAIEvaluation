package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ227 {

    public ResponseDto Question227() {
        ResponseDto responseDto = new ResponseDto();
        int n = 100;
        double[] e = new double[n / 2 + 1];
        
        // e[d] = 1 + sum P(d -> d') * e[d']
        // Game ends when d=0. Initial d=50.
        // Transition probabilities for distance d:
        // Die 1: L(1/6), R(1/6), K(4/6)
        // Die 2: L(1/6), R(1/6), K(4/6)
        
        // Matrix solution or iteration
        for (int iter = 0; iter < 10000; iter++) {
            double[] next = new double[n / 2 + 1];
            for (int d = 1; d <= n / 2; d++) {
                // Probabilities of change in d:
                // -2: 1/36, -1: 8/36, 0: 18/36, +1: 8/36, +2: 1/36
                next[d] = 1 + (1.0/36 * getE(e, d-2, n) + 8.0/36 * getE(e, d-1, n) + 
                               18.0/36 * getE(e, d, n) + 8.0/36 * getE(e, d+1, n) + 
                               1.0/36 * getE(e, d+2, n));
            }
            e = next;
        }
        
        responseDto.setAnswer(String.format("%.10g", e[50]));
        return responseDto;
    }

    private double getE(double[] e, int d, int n) {
        if (d == 0) return 0;
        if (d < 0) d = -d;
        if (d > n / 2) d = n - d;
        return e[d];
    }
}
