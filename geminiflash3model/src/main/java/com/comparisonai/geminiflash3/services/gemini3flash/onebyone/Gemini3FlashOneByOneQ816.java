package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Comparator;

@Service
public class Gemini3FlashOneByOneQ816 {

    public ResponseDto Question816() {
        ResponseDto responseDto = new ResponseDto();
        int k = 2000000;
        Point[] points = new Point[k];
        long s = 290797;
        for (int i = 0; i < k; i++) {
            long s1 = (s * s) % 50515093;
            long s2 = (s1 * s1) % 50515093;
            points[i] = new Point(s1, s2);
            s = s2;
        }

        double minDistance = closestPair(points);
        responseDto.setAnswer(String.format("%.9f", minDistance));
        return responseDto;
    }

    private static class Point {
        long x, y;
        Point(long x, long y) { this.x = x; this.y = y; }
    }

    private double closestPair(Point[] points) {
        Arrays.sort(points, Comparator.comparingLong(p -> p.x));
        return closestPairRecursive(points, 0, points.length);
    }

    private double closestPairRecursive(Point[] points, int start, int end) {
        if (end - start <= 3) {
            double min = Double.MAX_VALUE;
            for (int i = start; i < end; i++) {
                for (int j = i + 1; j < end; j++) {
                    min = Math.min(min, dist(points[i], points[j]));
                }
            }
            return min;
        }

        int mid = start + (end - start) / 2;
        double d1 = closestPairRecursive(points, start, mid);
        double d2 = closestPairRecursive(points, mid, end);
        double d = Math.min(d1, d2);

        Point[] strip = new Point[end - start];
        int stripSize = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(points[i].x - points[mid].x) < d) {
                strip[stripSize++] = points[i];
            }
        }

        Arrays.sort(strip, 0, stripSize, Comparator.comparingLong(p -> p.y));
        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (strip[j].y - strip[i].y) < d; j++) {
                d = Math.min(d, dist(strip[i], strip[j]));
            }
        }
        return d;
    }

    private double dist(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
