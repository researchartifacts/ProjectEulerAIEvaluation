package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ701 {

    public ResponseDto Question701() {
        ResponseDto responseDto = new ResponseDto();
        int W = 7;
        int H = 7;
        responseDto.setAnswer(getE(W, H));
        return responseDto;
    }

    private double getE(int W, int H) {
        int totalStates = 1 << (W * H);
        double totalMaxArea = 0;
        for (int i = 0; i < totalStates; i++) {
            boolean[][] grid = new boolean[H][W];
            for (int j = 0; j < W * H; j++) {
                if ((i & (1 << j)) != 0) {
                    grid[j / W][j % W] = true;
                }
            }
            totalMaxArea += getMaxArea(grid, W, H);
        }
        return totalMaxArea / totalStates;
    }

    private int getMaxArea(boolean[][] grid, int W, int H) {
        boolean[][] visited = new boolean[H][W];
        int maxArea = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (grid[r][c] && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, r, c, W, H));
                }
            }
        }
        return maxArea;
    }

    private int dfs(boolean[][] grid, boolean[][] visited, int r, int c, int W, int H) {
        if (r < 0 || r >= H || c < 0 || c >= W || !grid[r][c] || visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        int area = 1;
        area += dfs(grid, visited, r + 1, c, W, H);
        area += dfs(grid, visited, r - 1, c, W, H);
        area += dfs(grid, visited, r, c + 1, W, H);
        area += dfs(grid, visited, r, c - 1, W, H);
        return area;
    }
}
