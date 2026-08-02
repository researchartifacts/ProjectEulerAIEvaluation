package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ370 {

    public ResponseDto Question370() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Count valid tetrahedra with integer edges
        // 1 <= AB < AC < AD <= BC < BD <= CD <= 2000
        for (int ab = 1; ab <= 2000; ab++) {
            for (int ac = ab + 1; ac <= 2000; ac++) {
                for (int ad = ac + 1; ad <= 2000; ad++) {
                    for (int bc = ac + 1; bc <= 2000; bc++) {
                        if (bc > ad) {
                            for (int bd = bc + 1; bd <= 2000; bd++) {
                                if (bd > ad) {
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
        }
        result = result / 1000000;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
