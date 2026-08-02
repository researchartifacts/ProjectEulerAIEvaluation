package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ85 extends GPT54MiniOneByOneBase {

    public ResponseDto Question85() {
        ResponseDto responseDto = new ResponseDto();
        int target = 2000000;
        int minDiff = Integer.MAX_VALUE;
        int area = 0;
        for (int w = 1; w <= 2000; w++) {
            for (int h = 1; h <= w; h++) {
                int count = w * (w + 1) * h * (h + 1) / 4;
                int diff = Math.abs(target - count);
                if (diff < minDiff) {
                    minDiff = diff;
                    area = w * h;
                }
                if (count > target) break;
            }
        }
        responseDto.setAnswer(String.valueOf(area));
        return responseDto;
    }

}
