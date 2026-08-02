package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ76 extends GPT54MiniOneByOneBase {

    public ResponseDto Question76() {
        ResponseDto responseDto = new ResponseDto();
        int target = 100;
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = i; j <= target; j++) {
                ways[j] += ways[j - i];
            }
        }
        responseDto.setAnswer(String.valueOf(ways[target]));
        return responseDto;
    }

}
