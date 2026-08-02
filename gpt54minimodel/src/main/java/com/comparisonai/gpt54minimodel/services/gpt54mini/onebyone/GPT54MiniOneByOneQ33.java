package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class GPT54MiniOneByOneQ33 extends GPT54MiniOneByOneBase {

    public ResponseDto Question33() {
        ResponseDto responseDto = new ResponseDto();
        int numProd = 1;
        int denProd = 1;
        for (int den = 11; den < 100; den++) {
            for (int num = 11; num < den; num++) {
                int n1 = num / 10, n2 = num % 10;
                int d1 = den / 10, d2 = den % 10;
                if (n2 == d1 && n2 != 0 && n1 * den == num * d2) {
                    numProd *= num;
                    denProd *= den;
                }
            }
        }
        responseDto.setAnswer(String.valueOf(denProd / gcd(numProd, denProd)));
        return responseDto;
    }

}
