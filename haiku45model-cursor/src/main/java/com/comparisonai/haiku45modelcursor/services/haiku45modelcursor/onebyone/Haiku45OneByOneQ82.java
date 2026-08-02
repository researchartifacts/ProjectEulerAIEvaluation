package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 82
 */
@Service
public class Haiku45OneByOneQ82 {

    public ResponseDto Question82() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Minimal path sum from left column to right column (can move right, up, down)
        String filePath = "src/main/resources/0082_matrix.txt";
        int[][] matrix = readMatrix(filePath);
        int n = matrix.length;
        
        // Use Dijkstra-like approach for left to right
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        
        // Initialize first column (starting positions)
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }
        
        // Process each column
        for (int j = 0; j < n - 1; j++) {
            // Within column j: propagate up and down
            boolean changed = true;
            while (changed) {
                changed = false;
                for (int i = 0; i < n; i++) {
                    if (i > 0 && dp[i-1][j] + matrix[i][j] < dp[i][j]) {
                        dp[i][j] = dp[i-1][j] + matrix[i][j];
                        changed = true;
                    }
                    if (i < n - 1 && dp[i+1][j] + matrix[i][j] < dp[i][j]) {
                        dp[i][j] = dp[i+1][j] + matrix[i][j];
                        changed = true;
                    }
                }
            }
            
            // Move to column j+1
            for (int i = 0; i < n; i++) {
                dp[i][j+1] = dp[i][j] + matrix[i][j+1];
            }
        }
        
        // Minimize within last column
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n; i++) {
                if (i > 0 && dp[i-1][n-1] + matrix[i][n-1] < dp[i][n-1]) {
                    dp[i][n-1] = dp[i-1][n-1] + matrix[i][n-1];
                    changed = true;
                }
                if (i < n - 1 && dp[i+1][n-1] + matrix[i][n-1] < dp[i][n-1]) {
                    dp[i][n-1] = dp[i+1][n-1] + matrix[i][n-1];
                    changed = true;
                }
            }
        }
        
        // Find minimum in last column
        long minSum = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minSum = Math.min(minSum, dp[i][n-1]);
        }
        
        Object result = minSum;
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int[][] readMatrix(String filePath) {
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(filePath);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            int n = lines.size();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                String[] values = lines.get(i).split(",");
                for (int j = 0; j < values.length; j++) {
                    matrix[i][j] = Integer.parseInt(values[j].trim());
                }
            }
            return matrix;
        } catch (Exception e) {
            return new int[0][0];
        }
    }
}
