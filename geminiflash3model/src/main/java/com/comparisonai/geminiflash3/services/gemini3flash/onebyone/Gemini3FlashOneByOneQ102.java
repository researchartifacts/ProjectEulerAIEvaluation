package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class Gemini3FlashOneByOneQ102 {

    public ResponseDto Question102() {
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("helloworld-api/problems/101to200/0102_triangles.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x1 = Integer.parseInt(parts[0]);
                int y1 = Integer.parseInt(parts[1]);
                int x2 = Integer.parseInt(parts[2]);
                int y2 = Integer.parseInt(parts[3]);
                int x3 = Integer.parseInt(parts[4]);
                int y3 = Integer.parseInt(parts[5]);

                if (containsOrigin(x1, y1, x2, y2, x3, y3)) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        responseDto.setAnswer(String.valueOf(count));
        return responseDto;
    }

    private boolean containsOrigin(int x1, int y1, int x2, int y2, int x3, int y3) {
        double d1 = side(0, 0, x1, y1, x2, y2);
        double d2 = side(0, 0, x2, y2, x3, y3);
        double d3 = side(0, 0, x3, y3, x1, y1);

        boolean hasNeg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        boolean hasPos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(hasNeg && hasPos);
    }

    private double side(int x, int y, int x1, int y1, int x2, int y2) {
        return (x - x2) * (y1 - y2) - (x1 - x2) * (y - y2);
    }
}
