package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ94 extends GPT54MiniOneByOneBase {

    public ResponseDto Question94() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long x = 2, y = 1;
        while (true) {
            long nextX = 2 * x + 3 * y;
            long nextY = x + 2 * y;
            x = nextX;
            y = nextY;
            if ((2 * x + 1) % 3 == 0) {
                long a = (2 * x + 1) / 3;
                long p = 3 * a - 1;
                if (p > 1000000000) break;
                if (a > 0) sum += p;
            }
            if ((2 * x - 1) % 3 == 0) {
                long a = (2 * x - 1) / 3;
                long p = 3 * a + 1;
                if (p > 1000000000) break;
                if (a > 0) sum += p;
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
