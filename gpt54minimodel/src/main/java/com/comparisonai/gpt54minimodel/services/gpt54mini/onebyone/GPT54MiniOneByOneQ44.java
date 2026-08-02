package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ44 extends GPT54MiniOneByOneBase {

    public ResponseDto Question44() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; ; i++) {
            long pi = (long) i * (3 * i - 1) / 2;
            for (int j = i - 1; j > 0; j--) {
                long pj = (long) j * (3 * j - 1) / 2;
                if (isPentagonal(pi - pj) && isPentagonal(pi + pj)) {
                    responseDto.setAnswer(String.valueOf(pi - pj));
                    return responseDto;
                }
            }
        }
    }

}
