package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ91 extends GPT54MiniOneByOneBase {

    public ResponseDto Question91() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 50;
        int count = limit * limit * 3;
        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                int common = (int) gcd(x, y);
                count += Math.min(y * common / x, (limit - x) * common / y) * 2;
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
