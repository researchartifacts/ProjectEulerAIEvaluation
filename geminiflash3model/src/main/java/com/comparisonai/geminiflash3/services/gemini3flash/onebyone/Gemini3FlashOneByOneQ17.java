package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ17 {

    public ResponseDto Question17() {
        ResponseDto responseDto = new ResponseDto();
        int totalLetters = 0;
        for (int i = 1; i <= 1000; i++) {
            totalLetters += countLetters(i);
        }
        responseDto.setAnswer(totalLetters);
        return responseDto;
    }

    private int countLetters(int n) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n == 1000) return "onethousand".length();
        int letters = 0;
        if (n >= 100) {
            letters += ones[n / 100].length() + "hundred".length();
            if (n % 100 != 0) letters += "and".length();
        }
        n %= 100;
        if (n < 20) letters += ones[n].length();
        else {
            letters += tens[n / 10].length() + ones[n % 10].length();
        }
        return letters;
    }
}
