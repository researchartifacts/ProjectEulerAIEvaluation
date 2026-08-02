package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ52 extends GPT54MiniOneByOneBase {

    public ResponseDto Question52() {
        ResponseDto responseDto = new ResponseDto();
        for (int x = 1; ; x++) {
            if (isPermutation(x, 2 * x) && isPermutation(x, 3 * x) && isPermutation(x, 4 * x) && isPermutation(x, 5 * x) && isPermutation(x, 6 * x)) {
                responseDto.setAnswer(String.valueOf(x));
                return responseDto;
            }
        }
    }

}
