package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ213 {

    public ResponseDto Question213() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 213: Fleas on 30x30 grid
        // 900 fleas, one per square initially
        // Each bell ring: fleas jump to adjacent random square
        // Find expected unoccupied squares after 50 rings

        int gridSize = 30;
        int rings = 50;

        // Use Markov chain approach
        // For each square, calculate probability that it's occupied after n rings

        // Probability that a flea initially at (i,j) reaches (x,y) after n steps
        // is approximately distributed based on random walk theory

        // For large n, this approaches uniform distribution

        double emptySquares = 0.0;

        // Calculate for each square
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                // Probability this square is empty = (1 - prob_occupied)^fleas
                // Initially 1 flea per square

                // Use transition matrix or simulation
                double probOccupied = calculateOccupancyProbability(i, j, gridSize, rings);
                double probEmpty = 1.0 - probOccupied;
                emptySquares += probEmpty;
            }
        }

        String result = String.format("%.6f", emptySquares);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private double calculateOccupancyProbability(int x, int y, int gridSize, int rings) {
        // Calculate probability that at least one flea is at (x,y) after 'rings' rings

        // For a random walk on a 2D grid, the probability of reaching a position
        // depends on the number of paths and symmetry

        // After many steps, probability approaches 1/gridSize^2 for interior squares
        // adjusted for boundary effects

        double totalProb = 0.0;

        // Probability any of the 900 fleas ends up at this square
        // Using inclusion-exclusion: P(at least one) = 1 - P(none)

        // For each starting position, calculate probability of reaching (x,y)
        for (int si = 0; si < gridSize; si++) {
            for (int sj = 0; sj < gridSize; sj++) {
                double prob = randomWalkProbability(si, sj, x, y, gridSize, rings);
                totalProb += prob;
            }
        }

        // Probability at least one flea reaches this square
        double probNone = Math.pow(1.0 - totalProb / (gridSize * gridSize), 1);
        return 1.0 - probNone;
    }

    private double randomWalkProbability(int startX, int startY, int endX, int endY, int gridSize, int steps) {
        // Approximate probability using Manhattan distance and time
        // For random walk, variance grows with time

        int distance = Math.abs(startX - endX) + Math.abs(startY - endY);

        // After 'steps', expected distance covered is roughly sqrt(steps)
        if (distance > steps) return 0.0;

        // Approximate using normal distribution
        double variance = steps / 2.0;
        double expected = Math.exp(-distance * distance / (2 * variance)) / (2 * Math.PI * variance);

        return expected;
    }
}
