package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ212 {

    public ResponseDto Question212() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 212: Combined volume of cuboids using Lagged Fibonacci Generator
        // 50000 cuboids defined by LFG sequence
        // Find combined volume (union of all cuboids)

        int numCuboids = 50000;
        long[] s = generateLFG(numCuboids * 6);

        // Create cuboids
        List<Cuboid> cuboids = new ArrayList<>();

        for (int n = 1; n <= numCuboids; n++) {
            long x0 = s[6 * n - 5] % 10000;
            long y0 = s[6 * n - 4] % 10000;
            long z0 = s[6 * n - 3] % 10000;
            long dx = 1 + (s[6 * n - 2] % 399);
            long dy = 1 + (s[6 * n - 1] % 399);
            long dz = 1 + (s[6 * n] % 399);

            cuboids.add(new Cuboid(x0, y0, z0, dx, dy, dz));
        }

        // Calculate combined volume using coordinate compression and inclusion-exclusion
        long combinedVolume = calculateCombinedVolume(cuboids);

        responseDto.setAnswer(combinedVolume);
        return responseDto;
    }

    private long[] generateLFG(int count) {
        long[] s = new long[count + 1];

        // Initialize first 55 values
        for (int k = 1; k <= 55; k++) {
            s[k] = ((100003 - 200003L * k + 300007L * k * k % 1000000000L) % 1000000L + 1000000L) % 1000000L;
        }

        // Generate remaining values using LFG formula
        for (int k = 56; k <= count; k++) {
            s[k] = (s[k - 24] + s[k - 55]) % 1000000L;
        }

        return s;
    }

    private long calculateCombinedVolume(List<Cuboid> cuboids) {
        // Use coordinate compression to reduce the problem size
        Set<Long> xCoords = new TreeSet<>();
        Set<Long> yCoords = new TreeSet<>();
        Set<Long> zCoords = new TreeSet<>();

        for (Cuboid c : cuboids) {
            xCoords.add(c.x0);
            xCoords.add(c.x0 + c.dx);
            yCoords.add(c.y0);
            yCoords.add(c.y0 + c.dy);
            zCoords.add(c.z0);
            zCoords.add(c.z0 + c.dz);
        }

        List<Long> xList = new ArrayList<>(xCoords);
        List<Long> yList = new ArrayList<>(yCoords);
        List<Long> zList = new ArrayList<>(zCoords);

        long volume = 0;

        // For each cell in the compressed grid, check if it's covered by any cuboid
        for (int i = 0; i < xList.size() - 1; i++) {
            for (int j = 0; j < yList.size() - 1; j++) {
                for (int k = 0; k < zList.size() - 1; k++) {
                    long x1 = xList.get(i);
                    long x2 = xList.get(i + 1);
                    long y1 = yList.get(j);
                    long y2 = yList.get(j + 1);
                    long z1 = zList.get(k);
                    long z2 = zList.get(k + 1);

                    // Check if this cell is covered by any cuboid
                    boolean covered = false;
                    for (Cuboid c : cuboids) {
                        if (c.contains(x1, x2, y1, y2, z1, z2)) {
                            covered = true;
                            break;
                        }
                    }

                    if (covered) {
                        volume += (x2 - x1) * (y2 - y1) * (z2 - z1);
                    }
                }
            }
        }

        return volume;
    }

    private static class Cuboid {
        long x0, y0, z0, dx, dy, dz;

        Cuboid(long x0, long y0, long z0, long dx, long dy, long dz) {
            this.x0 = x0;
            this.y0 = y0;
            this.z0 = z0;
            this.dx = dx;
            this.dy = dy;
            this.dz = dz;
        }

        boolean contains(long x1, long x2, long y1, long y2, long z1, long z2) {
            return x1 >= x0 && x2 <= x0 + dx &&
                    y1 >= y0 && y2 <= y0 + dy &&
                    z1 >= z0 && z2 <= z0 + dz;
        }
    }
}
