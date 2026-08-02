package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ44 {

    public ResponseDto Question44() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> pentagonals = new ArrayList<>();
        for (long i = 1; i <= 10000; i++) {
            pentagonals.add(i * (3 * i - 1) / 2);
        }
        Set<Long> pentagonalSet = new HashSet<>(pentagonals);
        for (int i = 0; i < pentagonals.size(); i++) {
            for (int j = i + 1; j < pentagonals.size(); j++) {
                long sum = pentagonals.get(i) + pentagonals.get(j);
                long diff = pentagonals.get(j) - pentagonals.get(i);
                if (pentagonalSet.contains(sum) && pentagonalSet.contains(diff)) {
                    responseDto.setAnswer(diff);
                    return responseDto;
                }
            }
        }
        return responseDto;
    }
}
