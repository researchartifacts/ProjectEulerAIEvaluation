package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 59
 */
@Service
public class Haiku45OneByOneQ59 {

    public ResponseDto Question59() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Decrypt a message encrypted with 3-character XOR key and find sum of ASCII values
        // Generated logic to solve the problem:
        
        long result = 0;
        try {
            java.nio.file.Path path = java.nio.file.Paths.get("resources/documents/0059_cipher.txt");
            if (!java.nio.file.Files.exists(path)) {
                path = java.nio.file.Paths.get("<REDACTED_PATH>/resources/0059_cipher.txt");
            }
            if (java.nio.file.Files.exists(path)) {
                String content = new String(java.nio.file.Files.readAllBytes(path)).trim();
                int[] encrypted = java.util.Arrays.stream(content.split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
                
                for (int a = 97; a <= 122; a++) {
                    for (int b = 97; b <= 122; b++) {
                        for (int c = 97; c <= 122; c++) {
                            StringBuilder decrypted = new StringBuilder();
                            for (int i = 0; i < encrypted.length; i++) {
                                int key = new int[]{a, b, c}[i % 3];
                                decrypted.append((char)(encrypted[i] ^ key));
                            }
                            String text = decrypted.toString().toLowerCase();
                            if (text.contains("the") && text.contains("and")) {
                                long sum = 0;
                                for (char ch : text.toCharArray()) {
                                    sum += ch;
                                }
                                result = sum;
                                throw new Exception("Found");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            if (!e.getMessage().equals("Found")) {
                result = -1;
            }
        }
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
