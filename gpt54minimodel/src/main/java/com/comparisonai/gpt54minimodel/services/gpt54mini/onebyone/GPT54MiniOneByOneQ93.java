package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ93 extends GPT54MiniOneByOneBase {

    public ResponseDto Question93() {
        ResponseDto responseDto = new ResponseDto();
        int[] bestCount = {0};
        String[] bestDigits = {""};
        int[] digits = new int[4];
        boolean[] used = new boolean[10];
        searchQuestion93(0, digits, used, bestCount, bestDigits);
        responseDto.setAnswer(bestDigits[0]);
        return responseDto;
    }

}
