package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ411 {

    public ResponseDto Question411() {
        ResponseDto responseDto = new ResponseDto();
        long totalS = 0;
        for (int k = 1; k <= 30; k++) {
            long n = (long) Math.pow(k, 5);
            totalS += solveS(n);
        }
        responseDto.setAnswer(totalS);
        return responseDto;
    }

    private long solveS(long n) {
        Set<Point> stationsSet = new HashSet<>();
        long x = 1, y = 1;
        stationsSet.add(new Point(1, 1));
        for (long i = 1; i <= 2 * n; i++) {
            x = (x * 2) % n;
            y = (y * 3) % n;
            stationsSet.add(new Point(x, y));
        }
        List<Point> stations = new ArrayList<>(stationsSet);
        Collections.sort(stations, (p1, p2) -> {
            if (p1.x != p2.x) return Long.compare(p1.x, p2.x);
            return Long.compare(p1.y, p2.y);
        });

        List<Long> lis = new ArrayList<>();
        for (Point p : stations) {
            long val = p.y;
            int pos = Collections.binarySearch(lis, val);
            if (pos < 0) pos = -(pos + 1);
            else {
                // To allow non-decreasing, we need to find the rightmost position
                while (pos < lis.size() && lis.get(pos) == val) pos++;
            }
            if (pos < lis.size()) lis.set(pos, val);
            else lis.add(val);
        }
        return lis.size();
    }

    static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
        @Override
        public boolean equals(Object o) {
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        @Override
        public int hashCode() { return Objects.hash(x, y); }
    }
}
