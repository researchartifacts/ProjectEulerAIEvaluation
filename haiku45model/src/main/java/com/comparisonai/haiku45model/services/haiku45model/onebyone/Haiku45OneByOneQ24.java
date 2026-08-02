package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ24 {

    public ResponseDto Question24() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        int count = 0;
        while (count < 999999) {
            nextPermutation(digits);
            count++;
        }
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        responseDto.setAnswer(Long.parseLong(result.toString()));
        return responseDto;
    }

    private boolean nextPermutation(List<Integer> list) {
        int i = list.size() - 2;
        while (i >= 0 && list.get(i) >= list.get(i + 1)) i--;
        if (i < 0) return false;
        int j = list.size() - 1;
        while (list.get(j) <= list.get(i)) j--;
        Collections.swap(list, i, j);
        Collections.reverse(list.subList(i + 1, list.size()));
        return true;
    }
}
