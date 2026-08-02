package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ815 {

    public ResponseDto Question815() {
        ResponseDto responseDto = new ResponseDto();

        int n = 60;
        double expectedMaxPiles = calculateExpectedMaxPiles(n);

        responseDto.setAnswer(Math.round(expectedMaxPiles * 100000000.0) / 100000000.0);
        return responseDto;
    }

    private double calculateExpectedMaxPiles(int n) {
        int totalCards = 4 * n;
        double totalSimulations = 100000;
        double sumMaxPiles = 0;

        for (int sim = 0; sim < totalSimulations; sim++) {
            int maxPiles = simulateCardDealing(totalCards);
            sumMaxPiles += maxPiles;
        }

        return sumMaxPiles / totalSimulations;
    }

    private int simulateCardDealing(int totalCards) {
        int[] piles = new int[totalCards];
        int maxPiles = 0;
        int activePiles = 0;

        for (int card = 0; card < totalCards; card++) {
            int value = card % 4;
            if (piles[value] == 0) {
                activePiles++;
            }
            piles[value]++;
            if (piles[value] == 4) {
                activePiles--;
                piles[value] = 0;
            }
            maxPiles = Math.max(maxPiles, activePiles);
        }

        return maxPiles;
    }
}
