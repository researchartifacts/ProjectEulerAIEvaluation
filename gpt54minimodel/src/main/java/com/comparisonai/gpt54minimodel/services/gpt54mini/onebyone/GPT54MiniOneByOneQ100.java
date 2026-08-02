package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ100 extends GPT54MiniOneByOneBase {

    public ResponseDto Question100() {
        ResponseDto responseDto = new ResponseDto();
        long b = 15;
        long n = 21;
        long target = 1000000000000L;
        while (n <= target) {
            long nextB = 3 * b + 2 * n - 2;
            long nextN = 4 * b + 3 * n - 3;
            b = nextB;
            n = nextN;
        }
        responseDto.setAnswer(String.valueOf(b));
        return responseDto;
    }

}
