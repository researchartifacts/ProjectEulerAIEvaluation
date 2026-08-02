package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ23 {

    public ResponseDto Question23() {
        ResponseDto responseDto = new ResponseDto();
        int limit = 28123;
        List<Integer> abundant = new ArrayList<>();
        for (int i = 1; i <= limit; i++) {
            if (sumProperDivisors(i) > i) abundant.add(i);
        }
        boolean[] sumOfTwoAbundant = new boolean[limit + 1];
        for (int i = 0; i < abundant.size(); i++) {
            for (int j = i; j < abundant.size(); j++) {
                int sum = abundant.get(i) + abundant.get(j);
                if (sum <= limit) sumOfTwoAbundant[sum] = true;
                else break;
            }
        }
        long totalSum = 0;
        for (int i = 1; i <= limit; i++) {
            if (!sumOfTwoAbundant[i]) totalSum += i;
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private int sumProperDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum;
    }
}
