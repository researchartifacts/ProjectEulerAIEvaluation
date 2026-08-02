package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ86 extends GPT54MiniOneByOneBase {

    public ResponseDto Question86() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int m = 1; ; m++) {
            for (int wh = 2; wh <= 2 * m; wh++) {
                double dist = Math.sqrt(m * m + wh * wh);
                if (dist == (int) dist) {
                    count += (wh <= m) ? wh / 2 : m - (wh - 1) / 2;
                }
            }
            if (count > 1000000) {
                responseDto.setAnswer(String.valueOf(m));
                return responseDto;
            }
        }
    }

}
