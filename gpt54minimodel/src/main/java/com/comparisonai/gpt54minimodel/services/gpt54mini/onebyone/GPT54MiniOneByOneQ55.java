package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ55 extends GPT54MiniOneByOneBase {

    public ResponseDto Question55() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i)) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
