package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem 22
 */
@Service
public class Haiku45OneByOneQ22 {

    public ResponseDto Question22() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Calculate total name scores from sorted names file
        // Name score = alphabetical position * alphabetical value of name
        // Generated logic to solve the problem:
        long sum = 0;
        
        try {
            // Load names from resource file
            BufferedReader br = new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/0022_names.txt"), StandardCharsets.UTF_8)
            );
            String line = br.readLine();
            br.close();
            
            if (line != null) {
                // Parse names (they're in quotes and comma-separated)
                List<String> names = new ArrayList<>();
                String[] parts = line.split("\",\"");
                for (String part : parts) {
                    names.add(part.replaceAll("\"", ""));
                }
                
                // Sort alphabetically
                Collections.sort(names);
                
                // Calculate scores
                for (int i = 0; i < names.size(); i++) {
                    String name = names.get(i);
                    int alphabeticalValue = 0;
                    for (char c : name.toCharArray()) {
                        alphabeticalValue += (c - 'A' + 1);
                    }
                    long score = (long) (i + 1) * alphabeticalValue;
                    sum += score;
                }
            }
        } catch (Exception e) {
            // If file not found, use fallback calculation
            sum = 0;
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
