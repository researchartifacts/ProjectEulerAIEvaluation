package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 17: Number letter counts
 */
@Service
public class Haiku45OneByOneQ17 {

    public ResponseDto Question17() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: How many letters are used when writing out all numbers 1-1000?
        // (excluding spaces and hyphens, following British usage with "and")
        
        long totalLetters = 0;
        
        for (int i = 1; i <= 1000; i++) {
            totalLetters += countLetters(i);
        }
        
        Object result = totalLetters;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int countLetters(int num) {
        if (num == 1000) {
            return 11; // "one thousand"
        }
        
        int count = 0;
        
        // Hundreds
        if (num >= 100) {
            int hundreds = num / 100;
            count += getOneDigitLetters(hundreds) + 7; // "hundred" has 7 letters
            
            if (num % 100 > 0) {
                count += 3; // "and" has 3 letters
            }
        }
        
        // Tens and ones
        int remainder = num % 100;
        if (remainder > 0) {
            if (remainder < 10) {
                count += getOneDigitLetters(remainder);
            } else if (remainder < 20) {
                count += getTeen(remainder);
            } else {
                int tens = remainder / 10;
                int ones = remainder % 10;
                count += getTensLetters(tens);
                if (ones > 0) {
                    count += getOneDigitLetters(ones);
                }
            }
        }
        
        return count;
    }
    
    private int getOneDigitLetters(int digit) {
        switch (digit) {
            case 1: return 3;  // "one"
            case 2: return 3;  // "two"
            case 3: return 5;  // "three"
            case 4: return 4;  // "four"
            case 5: return 4;  // "five"
            case 6: return 3;  // "six"
            case 7: return 5;  // "seven"
            case 8: return 5;  // "eight"
            case 9: return 4;  // "nine"
            default: return 0;
        }
    }
    
    private int getTensLetters(int tens) {
        switch (tens) {
            case 2: return 6;  // "twenty"
            case 3: return 6;  // "thirty"
            case 4: return 5;  // "forty"
            case 5: return 5;  // "fifty"
            case 6: return 5;  // "sixty"
            case 7: return 7;  // "seventy"
            case 8: return 6;  // "eighty"
            case 9: return 6;  // "ninety"
            default: return 0;
        }
    }
    
    private int getTeen(int num) {
        switch (num) {
            case 10: return 3;  // "ten"
            case 11: return 6;  // "eleven"
            case 12: return 6;  // "twelve"
            case 13: return 8;  // "thirteen"
            case 14: return 8;  // "fourteen"
            case 15: return 7;  // "fifteen"
            case 16: return 7;  // "sixteen"
            case 17: return 9;  // "seventeen"
            case 18: return 8;  // "eighteen"
            case 19: return 8;  // "nineteen"
            default: return 0;
        }
    }
}
