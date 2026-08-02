package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Problem 411: Power Station Routing
 * Find sum of S(k^5) for 1 <= k <= 30
 * where S(n) is the maximum number of stations on a monotonic path
 */
@Service
public class Haiku45OneByOneQ411 {

    public ResponseDto Question411() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;
        for (int k = 1; k <= 30; k++) {
            long n = k;
            for (int i = 1; i < 5; i++) {
                n *= k;
            }
            result += computeS(n);
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long computeS(long n) {
        // Generate all distinct stations
        Set<String> stations = new HashSet<>();
        Map<String, Integer> stationPriority = new HashMap<>();
        int priority = 0;

        for (int i = 0; i <= 2 * n; i++) {
            long x = modPower(2, i, n);
            long y = modPower(3, i, n);
            String key = x + "," + y;
            if (!stations.contains(key)) {
                stations.add(key);
                stationPriority.put(key, priority++);
            }
        }

        // Find longest monotonic path from (0,0) to (n,n)
        List<String> stationList = new ArrayList<>(stations);
        stationList.sort((a, b) -> {
            String[] aParts = a.split(",");
            String[] bParts = b.split(",");
            long ax = Long.parseLong(aParts[0]);
            long ay = Long.parseLong(aParts[1]);
            long bx = Long.parseLong(bParts[0]);
            long by = Long.parseLong(bParts[1]);
            if (ax != bx) return Long.compare(ax, bx);
            return Long.compare(ay, by);
        });

        // DP: longest path ending at each station
        Map<String, Integer> dp = new HashMap<>();
        int maxPath = 0;

        for (String station : stationList) {
            String[] parts = station.split(",");
            long x = Long.parseLong(parts[0]);
            long y = Long.parseLong(parts[1]);

            int currentPath = 1;
            for (String prevStation : stationList) {
                String[] prevParts = prevStation.split(",");
                long px = Long.parseLong(prevParts[0]);
                long py = Long.parseLong(prevParts[1]);

                if (px <= x && py <= y && (px < x || py < y)) {
                    currentPath = Math.max(currentPath, dp.getOrDefault(prevStation, 0) + 1);
                }
            }

            dp.put(station, currentPath);
            if (x <= n && y <= n) {
                maxPath = Math.max(maxPath, currentPath);
            }
        }

        return maxPath;
    }

    private long modPower(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
