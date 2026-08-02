package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ215 {

    public ResponseDto Question215() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 215: Crack-free walls
        // Calculate W(32,10): number of ways to build 32x10 crack-free wall
        // using 2x1 and 3x1 bricks (horizontal x vertical)

        int width = 32;
        int height = 10;

        long result = countCrackFreeWalls(width, height);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countCrackFreeWalls(int width, int height) {
        // Use dynamic programming
        // For each layer, track which positions have bricks ending
        // to prevent cracks between layers

        // Represent each layer as a bitmask of positions
        // where gaps exist (positions where bricks can start/end)

        Map<Set<Integer>, Long> dp = new HashMap<>();

        // Initial state: first layer can be tiled in multiple ways
        Set<Set<Integer>> validLayers = generateValidLayers(width);

        for (Set<Integer> layer : validLayers) {
            dp.put(layer, 1L);
        }

        // For each additional layer
        for (int h = 1; h < height; h++) {
            Map<Set<Integer>, Long> nextDP = new HashMap<>();

            for (Map.Entry<Set<Integer>, Long> entry : dp.entrySet()) {
                Set<Integer> currentLayer = entry.getKey();
                long count = entry.getValue();

                // For each valid next layer that doesn't create running cracks
                for (Set<Integer> nextLayer : validLayers) {
                    if (!hasCracks(currentLayer, nextLayer)) {
                        nextDP.put(nextLayer, nextDP.getOrDefault(nextLayer, 0L) + count);
                    }
                }
            }

            dp = nextDP;
        }

        long result = 0;
        for (long count : dp.values()) {
            result += count;
        }

        return result;
    }

    private Set<Set<Integer>> generateValidLayers(int width) {
        // Generate all valid tilings of a single layer
        Set<Set<Integer>> layers = new HashSet<>();

        generateTilings(width, new HashSet<>(), layers);

        return layers;
    }

    private void generateTilings(int remaining, Set<Integer> gaps, Set<Set<Integer>> result) {
        if (remaining == 0) {
            result.add(new HashSet<>(gaps));
            return;
        }

        if (remaining >= 2) {
            gaps.add(gaps.size() + 2);
            generateTilings(remaining - 2, gaps, result);
            gaps.remove(gaps.size() + 2);
        }

        if (remaining >= 3) {
            gaps.add(gaps.size() + 3);
            generateTilings(remaining - 3, gaps, result);
            gaps.remove(gaps.size() + 3);
        }
    }

    private boolean hasCracks(Set<Integer> layer1, Set<Integer> layer2) {
        // Check if there are running cracks (same gap positions in consecutive layers)
        Set<Integer> common = new HashSet<>(layer1);
        common.retainAll(layer2);

        return !common.isEmpty();
    }
}
