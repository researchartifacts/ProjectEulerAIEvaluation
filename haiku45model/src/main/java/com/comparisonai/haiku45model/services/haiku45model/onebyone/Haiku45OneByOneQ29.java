package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45OneByOneQ29 {

    public ResponseDto Question29() {
        ResponseDto responseDto = new ResponseDto();
        Set<String> uniquePowers = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            BigInteger base = BigInteger.valueOf(a);
            for (int b = 2; b <= 100; b++) {
                BigInteger power = base.pow(b);
                uniquePowers.add(power.toString());
            }
        }
        responseDto.setAnswer((long) uniquePowers.size());
        return responseDto;
    }
}
