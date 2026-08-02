package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ806 {

    public ResponseDto Question806() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007L;
        int n = 100000;
        long result = 0;

        int disks = 20;
        long positions = 1L << disks;

        for (long pos = 0; pos < positions; pos++) {
            boolean isLosingPosition = isNimLosingPosition(pos, disks);
            if (isLosingPosition) {
                result = (result + pos) % MOD;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isNimLosingPosition(long pos, int disks) {
        List<Integer> pegs = new ArrayList<>();
        long temp = pos;
        for (int i = 0; i < disks; i++) {
            pegs.add((int) (temp & 1));
            temp >>= 1;
        }

        int xorSum = 0;
        for (int peg : pegs) {
            xorSum ^= peg;
        }

        return xorSum == 0;
    }
}
