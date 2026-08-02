package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ376 {

    public ResponseDto Question376() {
        ResponseDto responseDto = new ResponseDto();
        int N = 30;
        int sides = 6;
        
        List<int[]> allDice = new ArrayList<>();
        int[] currentDie = new int[sides];
        generateDice(1, N, 0, currentDie, allDice);
        
        int count = 0;
        int numDice = allDice.size();
        
        for (int i = 0; i < numDice; i++) {
            for (int j = i + 1; j < numDice; j++) {
                int winIJ = countWins(allDice.get(i), allDice.get(j));
                int winJI = countWins(allDice.get(j), allDice.get(i));
                
                if (winIJ <= 18 && winJI <= 18) continue;
                
                for (int k = j + 1; k < numDice; k++) {
                    int winIK = countWins(allDice.get(i), allDice.get(k));
                    int winKI = countWins(allDice.get(k), allDice.get(i));
                    int winJK = countWins(allDice.get(j), allDice.get(k));
                    int winKJ = countWins(allDice.get(k), allDice.get(j));
                    
                    if (isNontransitive(winIJ, winJI, winJK, winKJ, winKI, winIK)) {
                        count++;
                    }
                }
            }
        }
        
        responseDto.setAnswer(count);
        return responseDto;
    }

    private void generateDice(int start, int end, int index, int[] currentDie, List<int[]> allDice) {
        if (index == 6) {
            allDice.add(currentDie.clone());
            return;
        }
        for (int i = start; i <= end; i++) {
            currentDie[index] = i;
            generateDice(i, end, index + 1, currentDie, allDice);
        }
    }

    private int countWins(int[] die1, int[] die2) {
        int wins = 0;
        for (int a : die1) {
            for (int b : die2) {
                if (a > b) wins++;
            }
        }
        return wins;
    }

    private boolean isNontransitive(int winAB, int winBA, int winBC, int winCB, int winCA, int winAC) {
        if (winBA > 18 && winCB > 18 && winAC > 18) return true;
        if (winAB > 18 && winBC > 18 && winCA > 18) return true;
        return false;
    }
}
