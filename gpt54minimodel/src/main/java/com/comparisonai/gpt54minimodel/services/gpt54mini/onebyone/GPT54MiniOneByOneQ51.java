package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ51 extends GPT54MiniOneByOneBase {

    public ResponseDto Question51() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 56003; ; i++) {
            if (!isPrime(i)) continue;
            String s = String.valueOf(i);
            for (int j = 0; j < (1 << s.length()) - 1; j++) {
                List<Integer> indices = new ArrayList<>();
                for (int k = 0; k < s.length(); k++) {
                    if (((j >> k) & 1) == 1) indices.add(k);
                }
                if (indices.isEmpty()) continue;
                int count = 0;
                int firstPrime = -1;
                for (int digit = 0; digit <= 9; digit++) {
                    if (digit == 0 && indices.contains(0)) continue;
                    char[] chars = s.toCharArray();
                    for (int idx : indices) chars[idx] = (char) (digit + '0');
                    int next = Integer.parseInt(new String(chars));
                    if (isPrime(next)) {
                        count++;
                        if (firstPrime == -1) firstPrime = next;
                    }
                }
                if (count == 8) {
                    responseDto.setAnswer(String.valueOf(firstPrime));
                    return responseDto;
                }
            }
        }
    }

}
