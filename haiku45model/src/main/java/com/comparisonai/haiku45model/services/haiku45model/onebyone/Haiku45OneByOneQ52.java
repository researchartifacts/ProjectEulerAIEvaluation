package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ52 {

    public ResponseDto Question52() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1; i < 1000000; i++) {
            String iStr = sortDigits(String.valueOf(i));
            boolean allSame = true;
            for (int j = 2; j <= 6; j++) {
                String jStr = sortDigits(String.valueOf(i * j));
                if (!iStr.equals(jStr)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                responseDto.setAnswer(i);
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
