package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ32 {

    public ResponseDto Question32() {
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> products = new HashSet<>();
        for (int i = 1; i < 10000; i++) {
            for (int j = i; j < 100000 / i; j++) {
                int product = i * j;
                if (isPandigital(i, j, product)) {
                    products.add(product);
                }
            }
        }
        long sum = 0;
        for (int product : products) {
            sum += product;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private boolean isPandigital(int a, int b, int product) {
        String combined = "" + a + b + product;
        return combined.length() == 9 && combined.matches("[1-9]*") && combined.chars().distinct().count() == 9;
    }
}
