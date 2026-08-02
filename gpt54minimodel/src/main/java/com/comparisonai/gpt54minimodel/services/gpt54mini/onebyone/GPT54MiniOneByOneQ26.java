package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ26 extends GPT54MiniOneByOneBase {

    public ResponseDto Question26() {
        ResponseDto responseDto = new ResponseDto();
        int maxCycle = 0;
        int result = 0;
        for (int d = 2; d < 1000; d++) {
            int cycle = getCycleLength(d);
            if (cycle > maxCycle) {
                maxCycle = cycle;
                result = d;
            }
        }
        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

}
