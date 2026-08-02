package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 28
 */
@Service
public class Haiku45OneByOneQ28 {

    public ResponseDto Question28() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find sum of diagonals in 1001x1001 spiral
        // Generated logic to solve the problem:
        int gridSize = 1001;
        long sum = 1; // Starting number is 1
        
        int num = 1;
        int steps = 1;
        int direction = 0; // 0: right, 1: down, 2: left, 3: up
        
        // The spiral moves: right 1, down 1, left 2, up 2, right 3, down 3, etc.
        // We only track numbers on diagonals
        int x = (gridSize - 1) / 2;
        int y = (gridSize - 1) / 2;
        
        // Track diagonal positions
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int stepsInDirection = 1;
        int directionChanges = 0;
        
        while (num < gridSize * gridSize) {
            for (int i = 0; i < stepsInDirection && num < gridSize * gridSize; i++) {
                x += dx[direction];
                y += dy[direction];
                num++;
                
                // Check if on diagonal
                if ((x == y) || (x + y == gridSize - 1)) {
                    sum += num;
                }
            }
            
            direction = (direction + 1) % 4;
            directionChanges++;
            
            // Increase steps every 2 direction changes
            if (directionChanges % 2 == 0) {
                stepsInDirection++;
            }
        }
        
        Object result = sum;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
