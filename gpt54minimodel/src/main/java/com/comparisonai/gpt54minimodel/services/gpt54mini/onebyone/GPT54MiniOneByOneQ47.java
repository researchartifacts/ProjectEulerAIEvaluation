package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ47 extends GPT54MiniOneByOneBase {

    public ResponseDto Question47() {
        ResponseDto responseDto = new ResponseDto();
        int consecutive = 0;
        for (int i = 1; ; i++) {
            if (countPrimeFactors(i) == 4) {
                consecutive++;
                if (consecutive == 4) {
                    responseDto.setAnswer(String.valueOf(i - 3));
                    return responseDto;
                }
            } else {
                consecutive = 0;
            }
        }
    }

}
