package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ43 {

    public ResponseDto Question43() {
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        List<String> perms = new ArrayList<>();
        generatePermutations("0123456789", "", perms);
        int[] divisors = {2, 3, 5, 7, 11, 13, 17};
        for (String s : perms) {
            boolean match = true;
            for (int i = 0; i < 7; i++) {
                if (Integer.parseInt(s.substring(i + 1, i + 4)) % divisors[i] != 0) {
                    match = false;
                    break;
                }
            }
            if (match) sum += Long.parseLong(s);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    private void generatePermutations(String str, String ans, List<String> perms) {
        if (str.length() == 0) {
            perms.add(ans);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) + str.substring(i + 1);
            generatePermutations(ros, ans + ch, perms);
        }
    }
}
