package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ212 {

    public ResponseDto Question212() {
        ResponseDto responseDto = new ResponseDto();
        int nCuboids = 50000;
        int[] S = new int[6 * nCuboids + 1];
        for (int k = 1; k <= 55; k++) {
            long val = (100003L - 200003L * k + 300007L * (long)k * k * k) % 1000000;
            if (val < 0) val += 1000000;
            S[k] = (int) val;
        }
        for (int k = 56; k <= 6 * nCuboids; k++) {
            S[k] = (S[k - 24] + S[k - 55]) % 1000000;
        }

        int[][] cuboids = new int[nCuboids][6];
        for (int i = 1; i <= nCuboids; i++) {
            cuboids[i - 1][0] = S[6 * i - 5] % 10000; // x0
            cuboids[i - 1][1] = S[6 * i - 4] % 10000; // y0
            cuboids[i - 1][2] = S[6 * i - 3] % 10000; // z0
            cuboids[i - 1][3] = 1 + (S[6 * i - 2] % 399); // dx
            cuboids[i - 1][4] = 1 + (S[6 * i - 1] % 399); // dy
            cuboids[i - 1][5] = 1 + (S[6 * i] % 399); // dz
        }

        long totalVolume = solve(cuboids);
        responseDto.setAnswer(totalVolume);
        return responseDto;
    }

    private long solve(int[][] cuboids) {
        // 3D Union Volume using Sweep-Line in X, then 2D in YZ
        int n = cuboids.length;
        int[][] xEvents = new int[2 * n][4]; // [x, type, index]
        for (int i = 0; i < n; i++) {
            xEvents[2 * i] = new int[]{cuboids[i][0], 1, i};
            xEvents[2 * i + 1] = new int[]{cuboids[i][0] + cuboids[i][3], -1, i};
        }
        Arrays.sort(xEvents, (a, b) -> Integer.compare(a[0], b[0]));

        long totalVol = 0;
        List<Integer> active = new ArrayList<>();
        for (int i = 0; i < xEvents.length - 1; i++) {
            if (xEvents[i][1] == 1) active.add(xEvents[i][2]);
            else active.remove((Integer) xEvents[i][2]);

            if (xEvents[i + 1][0] > xEvents[i][0]) {
                long dx = xEvents[i + 1][0] - xEvents[i][0];
                totalVol += dx * solve2D(active, cuboids);
            }
        }
        return totalVol;
    }

    private long solve2D(List<Integer> active, int[][] cuboids) {
        int n = active.size();
        if (n == 0) return 0;
        int[][] yEvents = new int[2 * n][3];
        for (int i = 0; i < n; i++) {
            int idx = active.get(i);
            yEvents[2 * i] = new int[]{cuboids[idx][1], 1, idx};
            yEvents[2 * i + 1] = new int[]{cuboids[idx][1] + cuboids[idx][4], -1, idx};
        }
        Arrays.sort(yEvents, (a, b) -> Integer.compare(a[0], b[0]));

        long area = 0;
        List<Integer> yActive = new ArrayList<>();
        for (int i = 0; i < yEvents.length - 1; i++) {
            if (yEvents[i][1] == 1) yActive.add(yEvents[i][2]);
            else yActive.remove((Integer) yEvents[i][2]);

            if (yEvents[i + 1][0] > yEvents[i][0]) {
                int dy = yEvents[i + 1][0] - yEvents[i][0];
                area += (long) dy * solve1D(yActive, cuboids);
            }
        }
        return area;
    }

    private int solve1D(List<Integer> active, int[][] cuboids) {
        int n = active.size();
        int[][] zEvents = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            int idx = active.get(i);
            zEvents[2 * i] = new int[]{cuboids[idx][2], 1};
            zEvents[2 * i + 1] = new int[]{cuboids[idx][2] + cuboids[idx][5], -1};
        }
        Arrays.sort(zEvents, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]); // process starts before ends
        });

        int length = 0;
        int count = 0;
        for (int i = 0; i < zEvents.length - 1; i++) {
            count += zEvents[i][1];
            if (count > 0) {
                length += zEvents[i + 1][0] - zEvents[i][0];
            }
        }
        return length;
    }
}
