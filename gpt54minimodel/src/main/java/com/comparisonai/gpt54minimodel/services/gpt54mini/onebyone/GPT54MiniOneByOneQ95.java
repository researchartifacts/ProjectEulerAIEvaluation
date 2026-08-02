package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ95 extends GPT54MiniOneByOneBase {

    public ResponseDto Question95() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 1000000;
        int[] sumDiv = new int[limit + 1];
        Arrays.fill(sumDiv, 1);
        for (int i = 2; i <= limit / 2; i++) {
            for (int j = 2 * i; j <= limit; j += i) sumDiv[j] += i;
        }
        int maxLen = 0;
        int minMember = Integer.MAX_VALUE;
        for (int i = 1; i <= limit; i++) {
            int curr = i;
            List<Integer> chain = new ArrayList<>();
            while (curr <= limit && !chain.contains(curr)) {
                chain.add(curr);
                curr = sumDiv[curr];
            }
            if (curr == i) {
                if (chain.size() > maxLen) {
                    maxLen = chain.size();
                    minMember = i;
                    for (int member : chain) minMember = Math.min(minMember, member);
                }
            }
        }
        responseDto.setAnswer(String.valueOf(minMember));
        return responseDto;
    }

}
