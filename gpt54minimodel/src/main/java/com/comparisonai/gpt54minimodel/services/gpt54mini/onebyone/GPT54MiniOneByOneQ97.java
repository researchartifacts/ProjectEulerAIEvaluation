package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ97 extends GPT54MiniOneByOneBase {

    public ResponseDto Question97() {
        ResponseDto responseDto = new ResponseDto();
        BigInteger mod = BigInteger.TEN.pow(10);
        BigInteger n = BigInteger.valueOf(2).modPow(BigInteger.valueOf(7830457), mod);
        n = n.multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE).mod(mod);
        responseDto.setAnswer(n.toString());
        return responseDto;
    }

}
