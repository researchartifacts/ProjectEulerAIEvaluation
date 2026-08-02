package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ184 {

    public ResponseDto Question184() {
        ResponseDto responseDto = new ResponseDto();
        int r = 105;
        List<Point> points = new ArrayList<>();
        for (int x = -r + 1; x < r; x++) {
            for (int y = -r + 1; y < r; y++) {
                if (x * x + y * y < r * r) {
                    if (x == 0 && y == 0) continue;
                    points.add(new Point(x, y));
                }
            }
        }

        List<Double> angles = new ArrayList<>();
        for (Point p : points) {
            angles.add(Math.atan2(p.y, p.x));
        }
        Collections.sort(angles);

        long n = angles.size();
        long totalTriangles = n * (n - 1) * (n - 2) / 6;
        long nonOriginTriangles = 0;

        int j = 0;
        for (int i = 0; i < n; i++) {
            double target = angles.get(i) + Math.PI;
            while (j < n + i && (angles.get(j % (int) n) + (j >= n ? 2 * Math.PI : 0)) <= target + 1e-15) {
                j++;
            }
            long count = j - i - 1;
            nonOriginTriangles += count * (count - 1) / 2;
        }

        responseDto.setAnswer(String.valueOf(totalTriangles - nonOriginTriangles));
        return responseDto;
    }

    private static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}
