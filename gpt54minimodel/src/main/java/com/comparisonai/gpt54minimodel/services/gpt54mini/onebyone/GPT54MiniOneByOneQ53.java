package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ53 extends GPT54MiniOneByOneBase {

    public ResponseDto Question53() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 0; r <= n; r++) {
                if (nCrExceeds(n, r, 1000000)) count++;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
