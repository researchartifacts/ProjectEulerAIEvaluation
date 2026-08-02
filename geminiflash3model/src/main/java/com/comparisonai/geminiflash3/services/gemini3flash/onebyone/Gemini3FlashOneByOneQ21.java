package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ21 {

    public ResponseDto Question21() {
        ResponseDto responseDto = new ResponseDto();
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int d_a = d(i);
            int d_b = d(d_a);
            if (i == d_b && i != d_a) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private int d(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum;
    }
}
