package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ818 {

    public ResponseDto Question818() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;

        Set<String> allCollections = new HashSet<>();
        for (int mask = 0; mask < (1 << 12); mask++) {
            allCollections.add(Integer.toBinaryString(mask));
        }

        for (String collection : allCollections) {
            long setCount = countSets(collection);
            result += setCount * setCount * setCount * setCount;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countSets(String collection) {
        int count = 0;
        int[] cards = new int[collection.length()];
        for (int i = 0; i < collection.length(); i++) {
            cards[i] = collection.charAt(i) - '0';
        }

        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    if (isValidSet(cards[i], cards[j], cards[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isValidSet(int a, int b, int c) {
        return (a == b && b == c) || (a != b && b != c && a != c);
    }
}
