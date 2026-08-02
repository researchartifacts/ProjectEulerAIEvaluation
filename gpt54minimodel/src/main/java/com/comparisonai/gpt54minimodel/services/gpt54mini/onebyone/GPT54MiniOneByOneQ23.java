package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ23 extends GPT54MiniOneByOneBase {

    public ResponseDto Question23() {
        ResponseDto responseDto = new ResponseDto();
        final int LIMIT = 28123;
        List<Integer> abundantNumbers = new ArrayList<>();
        for (int i = 1; i <= LIMIT; i++) {
            if (sumDivisors(i) > i) {
                abundantNumbers.add(i);
            }
        }
        boolean[] canBeWrittenAsSum = new boolean[LIMIT + 1];
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i; j < abundantNumbers.size(); j++) {
                int sum = abundantNumbers.get(i) + abundantNumbers.get(j);
                if (sum <= LIMIT) {
                    canBeWrittenAsSum[sum] = true;
                } else {
                    break;
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= LIMIT; i++) {
            if (!canBeWrittenAsSum[i]) {
                sum += i;
            }
        }
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
