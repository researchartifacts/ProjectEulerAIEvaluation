package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ45 extends GPT54MiniOneByOneBase {

    public ResponseDto Question45() {
        ResponseDto responseDto = new ResponseDto();
        for (long i = 144; ; i++) {
            long h = i * (2 * i - 1);
            if (isPentagonal(h)) {
                responseDto.setAnswer(String.valueOf(h));
                return responseDto;
            }
        }
    }

}
