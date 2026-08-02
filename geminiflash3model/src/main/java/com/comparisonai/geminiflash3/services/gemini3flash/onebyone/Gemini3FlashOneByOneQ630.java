package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ630 {

    public ResponseDto Question630() {
        ResponseDto responseDto = new ResponseDto();
        int n = 2500;
        
        List<Point> points = generatePoints(n);
        Map<Slope, Integer> slopeCounts = new HashMap<>();
        
        int uniqueLines = 0;
        Set<Line> seenLines = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Line line = new Line(points.get(i), points.get(j));
                if (seenLines.add(line)) {
                    uniqueLines++;
                    slopeCounts.put(line.slope, slopeCounts.getOrDefault(line.slope, 0) + 1);
                }
            }
        }
        
        long sL = 0;
        long mTotal = uniqueLines;
        for (int count : slopeCounts.values()) {
            sL += (long) count * (mTotal - count);
        }
        
        responseDto.setAnswer(sL);
        return responseDto;
    }

    private List<Point> generatePoints(int n) {
        List<Point> points = new ArrayList<>();
        long s = 290797;
        for (int k = 1; k <= n; k++) {
            s = (s * s) % 50515093;
            long tx = (s % 2000) - 1000;
            s = (s * s) % 50515093;
            long ty = (s % 2000) - 1000;
            points.add(new Point(tx, ty));
        }
        return points;
    }

    private static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    private static class Slope {
        long dx, dy;
        Slope(long dx, long dy) {
            long g = gcd(Math.abs(dx), Math.abs(dy));
            this.dx = dx / g;
            this.dy = dy / g;
            if (this.dx < 0 || (this.dx == 0 && this.dy < 0)) {
                this.dx = -this.dx;
                this.dy = -this.dy;
            }
        }
        private long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
        @Override
        public boolean equals(Object o) {
            Slope s = (Slope) o;
            return dx == s.dx && dy == s.dy;
        }
        @Override
        public int hashCode() { return Objects.hash(dx, dy); }
    }

    private static class Line {
        Slope slope;
        long interceptNum; // Using (y * dx - x * dy) as a unique identifier for parallel lines
        Line(Point p1, Point p2) {
            slope = new Slope(p2.x - p1.x, p2.y - p1.y);
            interceptNum = p1.y * slope.dx - p1.x * slope.dy;
        }
        @Override
        public boolean equals(Object o) {
            Line l = (Line) o;
            return slope.equals(l.slope) && interceptNum == l.interceptNum;
        }
        @Override
        public int hashCode() { return Objects.hash(slope, interceptNum); }
    }
}
