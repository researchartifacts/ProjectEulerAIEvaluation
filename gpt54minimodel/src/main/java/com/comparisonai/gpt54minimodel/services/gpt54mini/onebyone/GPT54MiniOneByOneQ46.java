package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ46 extends GPT54MiniOneByOneBase {

    public ResponseDto Question46() {
        ResponseDto responseDto = new ResponseDto();
        for (int i = 9; ; i += 2) {
            if (isPrime(i)) continue;
            boolean found = false;
            for (int j = 1; 2 * j * j < i; j++) {
                if (isPrime(i - 2 * j * j)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                responseDto.setAnswer(String.valueOf(i));
                return responseDto;
            }
        }
    }

}
