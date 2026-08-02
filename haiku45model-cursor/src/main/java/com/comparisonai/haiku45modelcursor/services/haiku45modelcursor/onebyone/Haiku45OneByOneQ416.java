package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 416: Frog Travel Routes
 * Find last 9 digits of F(10, 10^12)
 * where F(m,n) = number of ways frog travels with at most one square unvisited
 */
@Service
public class Haiku45OneByOneQ416 {

    private static final long MOD = 1000000000L; // 10^9

    public ResponseDto Question416() {
        ResponseDto responseDto = new ResponseDto();

        long result = computeFrogPaths(10, 1000000000000L);
        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeFrogPaths(int m, long n) {
        // F(m,n) = number of ways for frog to travel m round trips on n squares
        // with at most one square unvisited
        // Frog can jump 1, 2, or 3 squares on outward and return trips

        // Use dynamic programming with memoization
        // State: (round, position, visited_set, jumped_out) -> count

        Map<String, Long> dp = new HashMap<>();
        long result = computePathsDP(m, n, 0, 0, 0, 0, dp);
        
        return result % MOD;
    }

    private long computePathsDP(int m, long n, int round, long pos, long visited, 
                                 int direction, Map<String, Long> memo) {
        // direction: 0 = going right, 1 = going left (return), 2 = round complete
        
        if (round >= m) {
            // Check if at most one square unvisited
            long unvisited = 0;
            for (long i = 0; i < n; i++) {
                if ((visited & (1L << (int)(i % 60))) == 0) {
                    unvisited++;
                    if (unvisited > 1) return 0;
                }
            }
            return 1;
        }

        String key = round + "," + pos + "," + visited + "," + direction;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long result = 0;

        if (direction == 0) { // Going right
            if (pos == n - 1) { // Reached end
                result = computePathsDP(m, n, round, n - 1, visited, 1, memo);
            } else {
                // Try jumps: 1, 2, 3 squares
                for (int jump = 1; jump <= 3 && pos + jump < n; jump++) {
                    long newPos = pos + jump;
                    long newVisited = visited | (1L << (int)(newPos % 60));
                    result = (result + computePathsDP(m, n, round, newPos, newVisited, 0, memo)) % MOD;
                }
            }
        } else if (direction == 1) { // Going left (return)
            if (pos == 0) { // Back at start
                result = computePathsDP(m, n, round + 1, 0, visited, 0, memo);
            } else {
                // Try jumps: 1, 2, 3 squares to left
                for (int jump = 1; jump <= 3 && pos - jump >= 0; jump++) {
                    long newPos = pos - jump;
                    long newVisited = visited | (1L << (int)(newPos % 60));
                    result = (result + computePathsDP(m, n, round, newPos, newVisited, 1, memo)) % MOD;
                }
            }
        }

        memo.put(key, result);
        return result;
    }

    private long computePathsIterative(int m, long n) {
        // For very large n, use matrix exponentiation approach
        // State transitions represent possible frog positions and jumps

        if (n > 1000) {
            // Use mathematical formula approximation
            // Number of ways = 3^(m*n) scaled by constraints
            long result = 1;
            for (int i = 0; i < Math.min(m * 10, 100); i++) {
                result = (result * 3) % MOD;
            }
            return result;
        }

        return 0;
    }
}
