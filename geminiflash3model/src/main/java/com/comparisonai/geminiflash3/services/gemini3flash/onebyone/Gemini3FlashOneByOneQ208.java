package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ208 {

    public ResponseDto Question208() {
        ResponseDto responseDto = new ResponseDto();
        int total = 70;
        int k = total / 5;
        
        // DP: dp[n0][n1][n2][n3][n4][last]
        // Use Map to save space
        Map<String, Long> memo = new HashMap<>();
        long result = solve(k, k, k, k, k, 0, memo);
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long solve(int n0, int n1, int n2, int n3, int n4, int last, Map<String, Long> memo) {
        if (n0 < 0 || n1 < 0 || n2 < 0 || n3 < 0 || n4 < 0) return 0;
        if (n0 == 0 && n1 == 0 && n2 == 0 && n3 == 0 && n4 == 0) return last == 0 ? 1 : 0;
        
        String key = n0 + "," + n1 + "," + n2 + "," + n3 + "," + n4 + "," + last;
        if (memo.containsKey(key)) return memo.get(key);
        
        long ways = 0;
        // From last dir, can go to (last+1)%5 or (last+4)%5
        int next1 = (last + 1) % 5;
        int next2 = (last + 4) % 5;
        
        ways += solve(n0 - (next1==0?1:0), n1 - (next1==1?1:0), n2 - (next1==2?1:0), n3 - (next1==3?1:0), n4 - (next1==4?1:0), next1, memo);
        ways += solve(n0 - (next2==0?1:0), n1 - (next2==1?1:0), n2 - (next2==2?1:0), n3 - (next2==3?1:0), n4 - (next2==4?1:0), next2, memo);
        
        memo.put(key, ways);
        return ways;
    }
}
