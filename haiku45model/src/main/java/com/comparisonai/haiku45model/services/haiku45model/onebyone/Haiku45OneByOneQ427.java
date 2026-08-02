package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ427 {

    public ResponseDto Question427() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000009L;
        long result = 0;
        int limit = 1000;

        for (int n = 1; n <= limit; n++) {
            String sequence = generateSequence(n);
            int longestRun = findLongestRun(sequence);
            result = (result + longestRun) % MOD;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private String generateSequence(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i % 10);
        }
        return sb.toString();
    }

    private int findLongestRun(String s) {
        int maxRun = 1;
        int currentRun = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                currentRun++;
                maxRun = Math.max(maxRun, currentRun);
            } else {
                currentRun = 1;
            }
        }
        return maxRun;
    }
}
