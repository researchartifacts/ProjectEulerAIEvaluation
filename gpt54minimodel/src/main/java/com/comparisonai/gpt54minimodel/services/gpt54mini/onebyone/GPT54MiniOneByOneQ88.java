package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ88 extends GPT54MiniOneByOneBase {

    public ResponseDto Question88() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 12000;
        int[] minN = new int[limit + 1];
        Arrays.fill(minN, Integer.MAX_VALUE);
        findProductSum(2, 1, 1, 0, minN);
        Set<Integer> uniqueN = new HashSet<>();
        for (int i = 2; i <= limit; i++) uniqueN.add(minN[i]);
        long sum = 0;
        for (int n : uniqueN) sum += n;
        responseDto.setAnswer(String.valueOf(sum));
        return responseDto;
    }

}
