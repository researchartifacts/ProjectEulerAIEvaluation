package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 81
 */
@Service
public class Haiku45OneByOneQ81 {

    public ResponseDto Question81() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Minimal path sum from top-left to bottom-right, moving only right and down
        // Read the 80x80 matrix from file and find minimum path sum using dynamic programming
        String filePath = "src/main/resources/0081_matrix.txt";
        int[][] matrix = readMatrix(filePath);
        int n = matrix.length;
        
        // DP approach: dp[i][j] = minimum path sum to reach cell (i,j)
        long[][] dp = new long[n][n];
        dp[0][0] = matrix[0][0];
        
        // Fill first row (can only move right)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }
        
        // Fill first column (can only move down)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        
        // Fill the rest of the table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        Object result = dp[n-1][n-1];
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
