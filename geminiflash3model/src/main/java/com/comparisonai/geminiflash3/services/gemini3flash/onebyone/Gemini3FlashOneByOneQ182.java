package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ182 {

    public ResponseDto Question182() {
        ResponseDto responseDto = new ResponseDto();
        int p = 1009;
        int q = 3643;
        int phi = (p - 1) * (q - 1);
        long sumE = 0;

        for (int e = 2; e < phi; e++) {
            if (gcd(e, phi) == 1) {
                int unconcealed = (gcd(e - 1, p - 1) + 1) * (gcd(e - 1, q - 1) + 1);
                if (unconcealed == 9) {
                    sumE += e;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(sumE));
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
