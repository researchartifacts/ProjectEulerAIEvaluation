package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ62 {

    public ResponseDto Question62() {
        ResponseDto responseDto = new ResponseDto();
        Map<String, Long> cubeMap = new HashMap<>();
        for (int i = 1; i <= 10000; i++) {
            long cube = (long) i * i * i;
            String sorted = sortDigits(String.valueOf(cube));
            cubeMap.put(sorted, cube);
            long count = 0;
            for (int j = 1; j <= 10000; j++) {
                if (sortDigits(String.valueOf((long) j * j * j)).equals(sorted)) {
                    count++;
                }
            }
            if (count == 5) {
                responseDto.setAnswer(cube);
                return responseDto;
            }
        }
        return responseDto;
    }

    private String sortDigits(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
