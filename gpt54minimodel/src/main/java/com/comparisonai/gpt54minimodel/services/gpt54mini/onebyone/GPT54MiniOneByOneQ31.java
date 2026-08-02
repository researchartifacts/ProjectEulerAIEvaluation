package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ31 extends GPT54MiniOneByOneBase {

    public ResponseDto Question31() {
        ResponseDto responseDto = new ResponseDto();
        int target = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                ways[i] += ways[i - coin];
            }
        }
        responseDto.setAnswer(String.valueOf(ways[target]));
        return responseDto;
    }

}
