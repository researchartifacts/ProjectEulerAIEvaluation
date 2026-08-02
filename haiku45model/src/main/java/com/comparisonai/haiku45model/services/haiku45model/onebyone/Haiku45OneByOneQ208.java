package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ208 {

    public ResponseDto Question208() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 208: Robot paths with 72-degree arcs
        // Robot makes 70 arcs, each 72 degrees (1/5 of circle) clockwise or counterclockwise
        // Find number of closed paths returning to starting position

        int numArcs = 70;
        long result = countClosedPaths(numArcs);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long countClosedPaths(int numArcs) {
        // Each arc rotates the direction by 72 degrees (or -72 degrees)
        // After all arcs, we need to return to the starting position
        // This means the total rotation must be a multiple of 360 degrees

        // Since each arc is 72 degrees = 360/5 degrees
        // We need: sum of turns ≡ 0 (mod 5)

        // We also need to track position in 2D space
        // Using complex numbers or coordinates

        // State: (arc_index, direction, x_pos, y_pos)
        // direction: 0=North, 1=NE, 2=E, 3=SE, 4=S, 5=SW, 6=W, 7=NW (8 directions)

        Map<String, Long> dp = new HashMap<>();
        long paths = countPaths(0, 0, 0, 0, numArcs, dp);

        return paths;
    }

    private long countPaths(int arc, int direction, int x, int y, int total, Map<String, Long> memo) {
        // Base case: completed all arcs
        if (arc == total) {
            // Check if we're back at starting position and facing North
            if (x == 0 && y == 0 && direction == 0) {
                return 1;
            }
            return 0;
        }

        // Memoization key
        String key = arc + "," + direction + "," + x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long count = 0;

        // Try clockwise turn (72 degrees right)
        int newDirCW = (direction + 1) % 8;
        int newXCW = x + getXDelta(newDirCW);
        int newYCW = y + getYDelta(newDirCW);
        count += countPaths(arc + 1, newDirCW, newXCW, newYCW, total, memo);

        // Try counterclockwise turn (72 degrees left)
        int newDirCCW = (direction - 1 + 8) % 8;
        int newXCCW = x + getXDelta(newDirCCW);
        int newYCCW = y + getYDelta(newDirCCW);
        count += countPaths(arc + 1, newDirCCW, newXCCW, newYCCW, total, memo);

        memo.put(key, count);
        return count;
    }

    private int getXDelta(int direction) {
        // 8 directions: N, NE, E, SE, S, SW, W, NW
        int[] xDeltas = {0, 1, 1, 1, 0, -1, -1, -1};
        return xDeltas[direction];
    }

    private int getYDelta(int direction) {
        // 8 directions: N, NE, E, SE, S, SW, W, NW
        int[] yDeltas = {1, 1, 0, -1, -1, -1, 0, 1};
        return yDeltas[direction];
    }
}
