package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ43 {

    public ResponseDto Question43() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digits.add(i);
        }
        do {
            if (isSubstringDivisible(digits)) {
                StringBuilder pandigital = new StringBuilder();
                for (int digit : digits) {
                    pandigital.append(digit);
                }
                sum += Long.parseLong(pandigital.toString());
            }
        } while (nextPermutation(digits));
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isSubstringDivisible(List<Integer> digits) {
        int[] divisors = {2, 3, 5, 7, 11, 13, 17};
        for (int i = 0; i < 7; i++) {
            int substring = digits.get(i + 1) * 100 + digits.get(i + 2) * 10 + digits.get(i + 3);
            if (substring % divisors[i] != 0) {
                return false;
            }
        }
        return true;
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
