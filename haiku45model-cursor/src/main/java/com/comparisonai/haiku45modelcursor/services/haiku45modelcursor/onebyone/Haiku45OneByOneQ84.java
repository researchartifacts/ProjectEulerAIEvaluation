package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 84
 */
@Service
public class Haiku45OneByOneQ84 {

    public ResponseDto Question84() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Monopoly simulation with 4-sided dice - find 3 most visited squares
        int numSquares = 40;
        long[] squareVisits = new long[numSquares];
        
        // Squares: 0=GO, 4=INCOME_TAX, 10=JAIL, 20=FREE_PARKING, 30=GO_TO_JAIL, 38=LUXURY_TAX
        // Chance squares: 7, 22, 36
        // Community Chest squares: 2, 17, 33
        
        int currentSquare = 0;
        int consecutiveDoubles = 0;
        int numSimulations = 1000000;
        
        for (int i = 0; i < numSimulations; i++) {
            // Roll two 4-sided dice
            int roll1 = (int)(Math.random() * 4) + 1;
            int roll2 = (int)(Math.random() * 4) + 1;
            boolean isDouble = (roll1 == roll2);
            
            if (isDouble) {
                consecutiveDoubles++;
            } else {
                consecutiveDoubles = 0;
            }
            
            // If three doubles, go to jail
            if (consecutiveDoubles == 3) {
                currentSquare = 10; // JAIL
                consecutiveDoubles = 0;
            } else {
                currentSquare = (currentSquare + roll1 + roll2) % numSquares;
                
                // Handle special squares
                if (currentSquare == 30) { // GO TO JAIL
                    currentSquare = 10;
                } else if (currentSquare == 2 || currentSquare == 17 || currentSquare == 33) { // Community Chest
                    int cardRoll = (int)(Math.random() * 16);
                    if (cardRoll == 0) currentSquare = 0; // GO
                    else if (cardRoll == 1) currentSquare = 10; // JAIL
                } else if (currentSquare == 7 || currentSquare == 22 || currentSquare == 36) { // Chance
                    int cardRoll = (int)(Math.random() * 16);
                    if (cardRoll == 0) currentSquare = 0; // GO
                    else if (cardRoll == 1) currentSquare = 10; // JAIL
                    else if (cardRoll == 2) currentSquare = 11; // C1
                    else if (cardRoll == 3) currentSquare = 24; // E3
                    else if (cardRoll == 4) currentSquare = 39; // H2
                    else if (cardRoll == 5) currentSquare = 5; // R1
                    else if (cardRoll == 6 || cardRoll == 7) currentSquare = nextRailway(currentSquare);
                    else if (cardRoll == 8) currentSquare = nextUtility(currentSquare);
                    else if (cardRoll == 9) currentSquare = (currentSquare - 3 + numSquares) % numSquares;
                }
            }
            
            squareVisits[currentSquare]++;
            
            if (!isDouble) {
                consecutiveDoubles = 0;
            }
        }
        
        // Find three most visited squares
        int[] mostVisited = new int[3];
        long[] mostVisitedCounts = new long[3];
        
        for (int i = 0; i < numSquares; i++) {
            if (squareVisits[i] > mostVisitedCounts[2]) {
                mostVisitedCounts[2] = squareVisits[i];
                mostVisited[2] = i;
                
                // Sort
                for (int j = 1; j >= 0; j--) {
                    if (mostVisitedCounts[j] < mostVisitedCounts[j+1]) {
                        long tempCnt = mostVisitedCounts[j];
                        int tempSq = mostVisited[j];
                        mostVisitedCounts[j] = mostVisitedCounts[j+1];
                        mostVisited[j] = mostVisited[j+1];
                        mostVisitedCounts[j+1] = tempCnt;
                        mostVisited[j+1] = tempSq;
                    }
                }
            }
        }
        
        String result = String.format("%02d%02d%02d", mostVisited[0], mostVisited[1], mostVisited[2]);
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int nextRailway(int current) {
        int[] railways = {5, 15, 25, 35};
        for (int r : railways) {
            if (r > current) return r;
        }
        return 5;
    }
    
    private int nextUtility(int current) {
        int[] utilities = {12, 28};
        for (int u : utilities) {
            if (u > current) return u;
        }
        return 12;
    }
}
