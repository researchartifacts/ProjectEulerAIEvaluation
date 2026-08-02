package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ105 {

    public ResponseDto Question105() {
        ResponseDto responseDto = new ResponseDto();
        long totalSum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("helloworld-api/problems/101to200/0105_sets.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int[] set = new int[parts.length];
                int sum = 0;
                for (int i = 0; i < parts.length; i++) {
                    set[i] = Integer.parseInt(parts[i]);
                    sum += set[i];
                }
                if (isSpecialSumSet(set)) {
                    totalSum += sum;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseDto.setAnswer(String.valueOf(totalSum));
        return responseDto;
    }

    private boolean isSpecialSumSet(int[] set) {
        Arrays.sort(set);
        int n = set.length;
        
        // Property 2
        for (int i = 1; i <= (n + 1) / 2; i++) {
            int sumL = 0;
            for (int j = 0; j < i; j++) sumL += set[j];
            int sumR = 0;
            for (int j = 0; j < i - 1; j++) sumR += set[n - 1 - j];
            if (sumL <= sumR) return false;
        }

        // Property 1
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for (int x : set) {
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                int newSum = sums.get(i) + x;
                if (sums.contains(newSum)) return false;
                sums.add(newSum);
            }
        }
        return true;
    }
}
