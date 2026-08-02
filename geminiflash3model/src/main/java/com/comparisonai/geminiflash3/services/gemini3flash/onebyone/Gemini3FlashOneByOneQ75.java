package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ75 {

    public ResponseDto Question75() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1500000;
        int[] count = new int[limit + 1];
        for (long m = 2; m * m < limit; m++) {
            for (long n = 1; n < m; n++) {
                if ((m + n) % 2 == 1 && gcd((int) m, (int) n) == 1) {
                    long L = 2 * m * (m + n);
                    for (long k = L; k <= limit; k += L) {
                        count[(int) k]++;
                    }
                }
            }
        }
        int result = 0;
        for (int c : count) if (c == 1) result++;
        responseDto.setAnswer(result);
        return responseDto;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int t = a; a = b; b = t;
        }
        return a;
    }
}
