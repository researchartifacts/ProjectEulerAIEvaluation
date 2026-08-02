package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ360 {

    public ResponseDto Question360() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Count valid pile configurations
        // Each player removes a divisor of current pile size
        for (int n = 1; n <= 1000; n++) {
            for (int k = 1; k <= n; k++) {
                if (n % k == 0) result++;
            }
        }
        result = result / 1000;

        responseDto.setAnswer(result);
        return responseDto;
    }
}
