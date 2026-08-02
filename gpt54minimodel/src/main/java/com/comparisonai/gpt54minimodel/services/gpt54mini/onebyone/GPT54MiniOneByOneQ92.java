package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ92 extends GPT54MiniOneByOneBase {

    public ResponseDto Question92() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        int[] cache = new int[10000000];
        for (int i = 1; i < 10000000; i++) {
            int curr = i;
            while (curr != 1 && curr != 89) {
                int next = 0;
                int temp = curr;
                while (temp > 0) {
                    int d = temp % 10;
                    next += d * d;
                    temp /= 10;
                }
                curr = next;
                if (curr < i && cache[curr] != 0) {
                    curr = cache[curr];
                    break;
                }
            }
            cache[i] = curr;
            if (curr == 89) count++;
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

}
