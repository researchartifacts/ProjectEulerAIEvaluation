package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ109 {

    public ResponseDto Question109() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> singles = new ArrayList<>();
        List<Integer> doubles = new ArrayList<>();
        List<Integer> trebles = new ArrayList<>();
        
        for (int i = 1; i <= 20; i++) {
            singles.add(i);
            doubles.add(i * 2);
            trebles.add(i * 3);
        }
        singles.add(25);
        doubles.add(50);

        List<Integer> allScores = new ArrayList<>(singles);
        allScores.addAll(doubles);
        allScores.addAll(trebles);

        int count = 0;
        // 1 dart
        for (int d : doubles) {
            if (d < 100) count++;
        }

        // 2 darts
        for (int s1 : allScores) {
            for (int d : doubles) {
                if (s1 + d < 100) count++;
            }
        }

        // 3 darts
        for (int i = 0; i < allScores.size(); i++) {
            for (int j = i; j < allScores.size(); j++) {
                for (int d : doubles) {
                    if (allScores.get(i) + allScores.get(j) + d < 100) count++;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }
}
