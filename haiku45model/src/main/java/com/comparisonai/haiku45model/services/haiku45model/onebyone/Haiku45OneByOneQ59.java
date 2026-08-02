package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ59 {

    public ResponseDto Question59() {
        ResponseDto responseDto = new ResponseDto();
        for (int a = 97; a <= 122; a++) {
            for (int b = 97; b <= 122; b++) {
                for (int c = 97; c <= 122; c++) {
                    int sum = 0;
                    String result = decryptWithKey(a, b, c);
                    if (result.contains(" the ")) {
                        for (char ch : result.toCharArray()) {
                            sum += ch;
                        }
                        responseDto.setAnswer(sum);
                        return responseDto;
                    }
                }
            }
        }
        return responseDto;
    }

    private String decryptWithKey(int a, int b, int c) {
        String encrypted = "496 90 663 667 667 336 336 669 662 667 663 90 90 666 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660 89 90 669 90 89 639 669 663 93 90 659 669 663 90 89 639 669 663 93 90 659 669 660";
        StringBuilder result = new StringBuilder();
        String[] parts = encrypted.split(" ");
        int keyIndex = 0;
        int[] key = {a, b, c};
        for (String part : parts) {
            int value = Integer.parseInt(part);
            int decrypted = value ^ key[keyIndex % 3];
            result.append((char) decrypted);
            keyIndex++;
        }
        return result.toString();
    }
}
