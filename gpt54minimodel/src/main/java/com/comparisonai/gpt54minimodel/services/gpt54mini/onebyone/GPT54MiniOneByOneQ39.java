package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ39 extends GPT54MiniOneByOneBase {

    public ResponseDto Question39() {
        ResponseDto responseDto = new ResponseDto();
        int maxP = 0;
        int maxSols = 0;
        for (int p = 2; p <= 1000; p += 2) {
            int sols = 0;
            for (int a = 1; a < p / 3; a++) {
                if ((p * p - 2 * p * a) % (2 * p - 2 * a) == 0) {
                    sols++;
                }
            }
            if (sols > maxSols) {
                maxSols = sols;
                maxP = p;
            }
        }
        responseDto.setAnswer(String.valueOf(maxP));
        return responseDto;
    }

}
