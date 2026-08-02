package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ17 {

    public ResponseDto Question17() {
        ResponseDto responseDto = new ResponseDto();
        long count = 0;
        for (int i = 1; i <= 1000; i++) {
            count += numberToWords(i).length();
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    private String numberToWords(int n) {
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n == 0) return "";
        if (n < 10) return units[n];
        if (n < 20) return teens[n - 10];
        if (n < 100) return tens[n / 10] + (n % 10 > 0 ? units[n % 10] : "");
        if (n < 1000) return units[n / 100] + "hundred" + numberToWords(n % 100);
        return units[n / 1000] + "thousand" + numberToWords(n % 1000);
    }
}
