package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ31 {

    public ResponseDto Question31() {
        ResponseDto responseDto = new ResponseDto();
        int target = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        long[] ways = new long[target + 1];
        ways[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                ways[i] += ways[i - coin];
            }
        }
        responseDto.setAnswer(ways[target]);
        return responseDto;
    }
}
