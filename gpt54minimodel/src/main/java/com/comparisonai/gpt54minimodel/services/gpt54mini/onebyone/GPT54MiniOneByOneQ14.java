package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ14 extends GPT54MiniOneByOneBase {

    public ResponseDto Question14() {
        ResponseDto responseDto = new ResponseDto();
        int maxChain = 0;
        int startingNum = 0;
        int[] cache = new int[1000001];
        for (int i = 1; i < 1000000; i++) {
            long n = i;
            int count = 0;
            while (n != 1 && n >= i) {
                if (n % 2 == 0) n /= 2;
                else n = 3 * n + 1;
                count++;
            }
            int totalChain = count + (n == 1 ? 1 : cache[(int) n]);
            cache[i] = totalChain;
            if (totalChain > maxChain) {
                maxChain = totalChain;
                startingNum = i;
            }
        }
        responseDto.setAnswer(String.valueOf(startingNum));
        return responseDto;
    }

}
