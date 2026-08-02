package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ629 {

    public ResponseDto Question629() {
        ResponseDto responseDto = new ResponseDto();
        int n = 200;
        long mod = 1000000007L;

        // f(n, k) is the number of winning positions for Alice.
        // g(n) = sum_{k=2}^n f(n, k).
        // f(n, k) = TotalPartitions(n) - PartitionsWithXorSumZero(n, k).
        
        long totalPartitions = countPartitions(n, mod);
        long gSum = 0;

        for (int k = 2; k <= n; k++) {
            int[] grundy = computeGrundy(n, k);
            long xorZero = countPartitionsWithXorSum(n, grundy, 0, mod);
            long fnk = (totalPartitions - xorZero + mod) % mod;
            gSum = (gSum + fnk) % mod;
        }

        responseDto.setAnswer(gSum);
        return responseDto;
    }

    private int[] computeGrundy(int n, int k) {
        int[] g = new int[n + 1];
        g[1] = 0;
        for (int i = 2; i <= n; i++) {
            Set<Integer> reached = new HashSet<>();
            // Split pile i into p non-empty piles, 2 <= p <= k.
            // This is equivalent to partitions of i into p parts.
            generateSplitXors(i, k, g, 0, 0, 0, reached);
            int m = 0;
            while (reached.contains(m)) m++;
            g[i] = m;
        }
        return g;
    }

    private void generateSplitXors(int remain, int k, int[] g, int currentXor, int count, int min, Set<Integer> reached) {
        if (remain == 0) {
            if (count >= 2 && count <= k) reached.add(currentXor);
            return;
        }
        if (count == k) return;
        for (int i = Math.max(1, min); i <= remain; i++) {
            generateSplitXors(remain - i, k, g, currentXor ^ g[i], count + 1, i, reached);
        }
    }

    private long countPartitions(int n, long mod) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }
        return dp[n];
    }

    private long countPartitionsWithXorSum(int n, int[] grundy, int targetXor, long mod) {
        // dp[sum][xor]
        // Since xor can be up to 255 for n=200.
        long[][] dp = new long[n + 1][256];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = grundy[i];
            for (int s = i; s <= n; s++) {
                for (int x = 0; x < 256; x++) {
                    dp[s][x ^ val] = (dp[s][x ^ val] + dp[s - i][x]) % mod;
                }
            }
        }
        return dp[n][targetXor];
    }
}
