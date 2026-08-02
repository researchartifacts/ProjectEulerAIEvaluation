package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ62 {

    public ResponseDto Question62() {
        ResponseDto responseDto = new ResponseDto();
        Map<String, long[]> map = new HashMap<>();
        for (long i = 1; ; i++) {
            long cube = i * i * i;
            char[] chars = String.valueOf(cube).toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) map.put(sorted, new long[]{0, cube});
            long[] val = map.get(sorted);
            val[0]++;
            if (val[0] == 5) {
                responseDto.setAnswer(val[1]);
                break;
            }
        }
        return responseDto;
    }
}
