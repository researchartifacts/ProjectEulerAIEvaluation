package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ49 extends GPT54MiniOneByOneBase {

    public ResponseDto Question49() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1001; i < 10000; i += 2) {
            if (i == 1487) continue;
            if (isPrime(i) && isPrime(i + 3330) && isPrime(i + 6660)) {
                if (isPermutation(i, i + 3330) && isPermutation(i, i + 6660)) {
                    responseDto.setAnswer(i + "" + (i + 3330) + "" + (i + 6660));
                    return responseDto;
                }
            }
        }
        return responseDto;
    }

}
