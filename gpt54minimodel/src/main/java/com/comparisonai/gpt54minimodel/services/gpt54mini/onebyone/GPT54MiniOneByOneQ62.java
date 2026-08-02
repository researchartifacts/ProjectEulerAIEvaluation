package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ62 extends GPT54MiniOneByOneBase {

    public ResponseDto Question62() {
        ResponseDto responseDto = new ResponseDto();
        Map<String, List<Long>> map = new HashMap<>();
        for (long i = 1; ; i++) {
            long cube = i * i * i;
            char[] chars = String.valueOf(cube).toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(cube);
            if (map.get(sorted).size() == 5) {
                responseDto.setAnswer(String.valueOf(map.get(sorted).get(0)));
                return responseDto;
            }
        }
    }

}
