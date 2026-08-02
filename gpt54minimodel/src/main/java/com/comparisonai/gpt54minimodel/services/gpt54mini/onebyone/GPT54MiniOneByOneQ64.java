package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ64 extends GPT54MiniOneByOneBase {

    public ResponseDto Question64() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 2; n <= 10000; n++) {
            int r = (int) Math.sqrt(n);
            if (r * r == n) continue;
            int period = 0;
            int d = 1;
            int m = 0;
            int a = r;
            do {
                m = d * a - m;
                d = (n - m * m) / d;
                a = (r + m) / d;
                period++;
            } while (a != 2 * r);
            if (period % 2 == 1) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
