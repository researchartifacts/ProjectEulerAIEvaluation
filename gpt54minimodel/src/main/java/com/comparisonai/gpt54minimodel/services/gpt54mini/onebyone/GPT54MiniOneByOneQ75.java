package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ75 extends GPT54MiniOneByOneBase {

    public ResponseDto Question75() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1500000;
        int[] count = new int[limit + 1];
        for (long m = 2; 2 * m * m < limit; m++) {
            for (long n = 1; n < m; n++) {
                if ((m - n) % 2 == 1 && gcd(m, n) == 1) {
                    long L = 2 * m * (m + n);
                    for (long k = L; k <= limit; k += L) {
                        count[(int) k]++;
                    }
                }
            }
        }
        int result = 0;
        for (int c : count) if (c == 1) result++;
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
