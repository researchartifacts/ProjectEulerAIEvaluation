package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ127 {

    public ResponseDto Question127() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 120000;
        int[] rads = new int[limit];
        for (int i = 1; i < limit; i++) rads[i] = 1;
        for (int i = 2; i < limit; i++) {
            if (rads[i] == 1) {
                for (int j = i; j < limit; j += i) {
                    rads[j] *= i;
                }
            }
        }

        long sumC = 0;
        for (int c = 3; c < limit; c++) {
            int radC = rads[c];
            int limitRadAB = c / radC;
            for (int a = 1; a < c / 2; a++) {
                int b = c - a;
                if ((long) rads[a] * rads[b] < limitRadAB) {
                    if (gcd(a, b) == 1) {
                        sumC += c;
                    }
                }
            }
        }

        responseDto.setAnswer(String.valueOf(sumC));
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
