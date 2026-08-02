package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 89
 */
@Service
public class Haiku45OneByOneQ89 {

    public ResponseDto Question89() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Read Roman numerals from file and count saved characters by using minimal form
        String filePath = "src/main/resources/0089_roman.txt";
        
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(filePath);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            
            long totalSaved = 0;
            
            for (String roman : lines) {
                roman = roman.trim();
                if (roman.isEmpty()) continue;
                
                // Convert to integer then back to minimal form
                int value = romanToInt(roman);
                String minimal = intToRoman(value);
                
                totalSaved += roman.length() - minimal.length();
            }
            
            Object result = totalSaved;
            responseDto.setAnswer(result);
        } catch (Exception e) {
            responseDto.setAnswer(0L);
        }
        
        return responseDto;
    }
    
    private int romanToInt(String s) {
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int curr = map.get(s.charAt(i));
            int next = (i + 1 < s.length()) ? map.get(s.charAt(i + 1)) : 0;
            
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        return result;
    }
    
    private String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(numerals[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }
}
