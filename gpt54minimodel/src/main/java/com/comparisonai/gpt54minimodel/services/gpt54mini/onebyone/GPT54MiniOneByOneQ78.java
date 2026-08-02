package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ78 extends GPT54MiniOneByOneBase {

    public ResponseDto Question78() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> p = new ArrayList<>();
        p.add(1);
        for (int n = 1; ; n++) {
            long ways = 0;
            for (int k = 1; ; k++) {
                int g1 = k * (3 * k - 1) / 2;
                int g2 = k * (3 * k + 1) / 2;
                long sign = (k % 2 == 1) ? 1 : -1;
                if (g1 <= n) ways = (ways + sign * p.get(n - g1)) % 1000000;
                else break;
                if (g2 <= n) ways = (ways + sign * p.get(n - g2)) % 1000000;
            }
            if (ways < 0) ways += 1000000;
            if (ways == 0) {
                responseDto.setAnswer(String.valueOf(n));
                return responseDto;
            }
            p.add((int) ways);
        }
    }

}
