package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ74 extends GPT54MiniOneByOneBase {

    public ResponseDto Question74() {
        ResponseDto responseDto = new ResponseDto();
        int[] facts = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        int count = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 1; i < 1000000; i++) {
            List<Integer> chain = new ArrayList<>();
            int curr = i;
            while (!chain.contains(curr)) {
                chain.add(curr);
                int next = 0;
                int temp = curr;
                if (temp == 0) next = facts[0];
                while (temp > 0) {
                    next += facts[temp % 10];
                    temp /= 10;
                }
                curr = next;
                if (cache.containsKey(curr)) {
                    int total = chain.size() + cache.get(curr);
                    if (total == 60) count++;
                    cache.put(i, total);
                    break;
                }
            }
            if (!cache.containsKey(i)) {
                if (chain.size() == 60) count++;
                cache.put(i, chain.size());
            }
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
