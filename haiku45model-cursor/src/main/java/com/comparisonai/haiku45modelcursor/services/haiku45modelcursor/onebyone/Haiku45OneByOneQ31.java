package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 31
 */
@Service
public class Haiku45OneByOneQ31 {

    public ResponseDto Question31() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: In the United Kingdom the currency is made up of pound (£) and pence (p).
        // Coins: 1p, 2p, 5p, 10p, 20p, 50p, 100p (£1), 200p (£2)
        // How many different ways can £2 (200p) be made using any number of coins?
        // Generated logic to solve the problem:
        
        int target = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] += dp[i - coin];
            }
        }
        
        Object result = dp[target];
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
