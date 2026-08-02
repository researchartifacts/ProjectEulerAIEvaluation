package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ185 {

    public ResponseDto Question185() {
        ResponseDto responseDto = new ResponseDto();
        String[] guesses = {
            "5616185650518293", "3847439647293047", "5855462940810587", "9742855507068353",
            "4296849643607543", "3174248439465858", "4513559094146117", "7890971548908067",
            "8157356344118483", "2615250744386899", "8690095851526254", "6375711915077050",
            "6913859173121360", "6442889055042768", "2321386104303845", "2326509471271448",
            "5251583379644322", "1748270476758276", "4895722652190306", "3041631117224635",
            "1841236454324589", "2659862637316867"
        };
        int[] correct = {2, 1, 3, 3, 3, 1, 2, 3, 1, 2, 3, 1, 1, 2, 0, 2, 2, 3, 1, 3, 3, 2};

        char[] result = new char[16];
        if (solve(0, result, guesses, correct)) {
            responseDto.setAnswer(new String(result));
        }
        return responseDto;
    }

    private boolean solve(int pos, char[] current, String[] guesses, int[] correct) {
        if (pos == 16) {
            for (int i = 0; i < guesses.length; i++) {
                int count = 0;
                for (int j = 0; j < 16; j++) {
                    if (current[j] == guesses[i].charAt(j)) count++;
                }
                if (count != correct[i]) return false;
            }
            return true;
        }

        for (char c = '0'; c <= '9'; c++) {
            current[pos] = c;
            boolean possible = true;
            for (int i = 0; i < guesses.length; i++) {
                int count = 0;
                for (int j = 0; j <= pos; j++) {
                    if (current[j] == guesses[i].charAt(j)) count++;
                }
                if (count > correct[i] || count + (15 - pos) < correct[i]) {
                    possible = false;
                    break;
                }
            }
            if (possible && solve(pos + 1, current, guesses, correct)) return true;
        }
        return false;
    }
}
