package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ353 {

    public ResponseDto Question353() {
        ResponseDto responseDto = new ResponseDto();
        double totalRisk = 0;
        for (int n = 1; n <= 15; n++) {
            totalRisk += M((long) Math.pow(2, n) - 1);
        }
        responseDto.setAnswer(String.format("%.10f", totalRisk));
        return responseDto;
    }

    private double M(long r) {
        List<Point> stations = findStations(r);
        int n = stations.size();
        double[] minRisk = new double[n];
        Arrays.fill(minRisk, Double.MAX_VALUE);
        
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stations.get(i).x == 0 && stations.get(i).y == 0) {
                if (stations.get(i).z == r) startIdx = i;
                if (stations.get(i).z == -r) endIdx = i;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.risk));
        minRisk[startIdx] = 0;
        pq.add(new Node(startIdx, 0));
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.risk > minRisk[curr.idx]) continue;
            if (curr.idx == endIdx) return curr.risk;
            
            for (int nextIdx = 0; nextIdx < n; nextIdx++) {
                if (curr.idx == nextIdx) continue;
                double risk = risk(stations.get(curr.idx), stations.get(nextIdx), r);
                if (minRisk[curr.idx] + risk < minRisk[nextIdx]) {
                    minRisk[nextIdx] = minRisk[curr.idx] + risk;
                    pq.add(new Node(nextIdx, minRisk[nextIdx]));
                }
            }
        }
        return minRisk[endIdx];
    }

    private List<Point> findStations(long r) {
        List<Point> points = new ArrayList<>();
        long r2 = r * r;
        for (long x = -r; x <= r; x++) {
            long x2 = x * x;
            for (long y = -r; y <= r; y++) {
                long y2 = y * y;
                long z2 = r2 - x2 - y2;
                if (z2 >= 0) {
                    long z = (long) Math.sqrt(z2);
                    if (z * z == z2) {
                        points.add(new Point(x, y, z));
                        if (z > 0) points.add(new Point(x, y, -z));
                    }
                }
            }
        }
        return points;
    }

    private double risk(Point p1, Point p2, long r) {
        double dot = (double) p1.x * p2.x + (double) p1.y * p2.y + (double) p1.z * p2.z;
        double angle = Math.acos(dot / (r * r));
        return Math.pow(angle / Math.PI, 2);
    }

    private static class Point {
        long x, y, z;
        Point(long x, long y, long z) { this.x = x; this.y = y; this.z = z; }
    }

    private static class Node {
        int idx;
        double risk;
        Node(int idx, double risk) { this.idx = idx; this.risk = risk; }
    }
}
