package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ17 extends GPT54MiniOneByOneBase {

    public ResponseDto Question17() {
        ResponseDto responseDto = new ResponseDto();
        int total = 0;
        for (int i = 1; i <= 1000; i++) {
            total += countLetters(i);
        }
        responseDto.setAnswer(String.valueOf(total));
        return responseDto;
    }

}
