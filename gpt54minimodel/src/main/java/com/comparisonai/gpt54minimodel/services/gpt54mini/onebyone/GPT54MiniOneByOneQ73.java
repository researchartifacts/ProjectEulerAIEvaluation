package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ73 extends GPT54MiniOneByOneBase {

    public ResponseDto Question73() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 12000;
        int count = 0;
        for (int d = 2; d <= limit; d++) {
            for (int n = d / 3 + 1; n < (d + 1) / 2; n++) {
                if (gcd(n, d) == 1) count++;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
