package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

@Service
public class Haiku45OneByOneQ390 {

    public ResponseDto Question390() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        // Count triangles with vertices on integer lattice points
        // that contain the origin
        for (int x1 = -50; x1 <= 50; x1++) {
            for (int y1 = -50; y1 <= 50; y1++) {
                for (int x2 = -50; x2 <= 50; x2++) {
                    for (int y2 = -50; y2 <= 50; y2++) {
                        for (int x3 = -50; x3 <= 50; x3++) {
                            for (int y3 = -50; y3 <= 50; y3++) {
                                if ((x1 * y2 - x2 * y1) * (x1 * y3 - x3 * y1) < 0) {
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
