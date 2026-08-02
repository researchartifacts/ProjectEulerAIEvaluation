package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 701
 * Consider a rectangle made up of $W \times H$ square cells each with area $1$. Each cell is independe...
 */
@Service
public class Haiku45OneByOneQ701 {

    public ResponseDto Question701() {
        ResponseDto responseDto = new ResponseDto();

        // Expected value of maximum connected area in random grid (7x7)
        int W = 7, H = 7;
        double result = 0.0;
        
        // Simulate random grids with Monte Carlo method
        int numSimulations = 50000;
        double sumMaxAreas = 0.0;
        
        java.util.Random rand = new java.util.Random();
        for (int sim = 0; sim < numSimulations; sim++) {
            boolean[][] grid = new boolean[H][W];
            // Initialize random cells
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    grid[i][j] = rand.nextBoolean();
                }
            }
            // Find maximum connected component size using BFS/DFS
            boolean[][] visited = new boolean[H][W];
            int maxArea = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (grid[i][j] && !visited[i][j]) {
                        int area = findConnectedAreaBFS(grid, visited, i, j, H, W);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
            sumMaxAreas += maxArea;
        }
        
        result = sumMaxAreas / numSimulations;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int findConnectedAreaBFS(boolean[][] grid, boolean[][] visited, int startI, int startJ, int H, int W) {
        int area = 0;
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{startI, startJ});
        visited[startI][startJ] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            area++;
            
            for (int[] dir : directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if (ni >= 0 && ni < H && nj >= 0 && nj < W && grid[ni][nj] && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
        return area;
    }
}

