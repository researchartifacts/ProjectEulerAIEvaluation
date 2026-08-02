package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 83
 */
@Service
public class Haiku45OneByOneQ83 {

    public ResponseDto Question83() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Minimal path sum moving in all directions (left, right, up, down)
        // Use Dijkstra's algorithm
        String filePath = "src/main/resources/0083_matrix.txt";
        int[][] matrix = readMatrix(filePath);
        int n = matrix.length;
        
        long[][] dist = new long[n][n];
        boolean[][] visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Long.MAX_VALUE;
            }
        }
        dist[0][0] = matrix[0][0];
        
        // Dijkstra's algorithm
        for (int count = 0; count < n * n; count++) {
            // Find unvisited cell with minimum distance
            long minDist = Long.MAX_VALUE;
            int minI = -1, minJ = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && dist[i][j] < minDist) {
                        minDist = dist[i][j];
                        minI = i;
                        minJ = j;
                    }
                }
            }
            
            if (minI == -1) break;
            visited[minI][minJ] = true;
            
            // Update neighbors
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int ni = minI + dir[0];
                int nj = minJ + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && !visited[ni][nj]) {
                    long newDist = dist[minI][minJ] + matrix[ni][nj];
                    if (newDist < dist[ni][nj]) {
                        dist[ni][nj] = newDist;
                    }
                }
            }
        }
        
        Object result = dist[n-1][n-1];
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
