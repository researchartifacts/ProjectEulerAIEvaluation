package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 91
 */
@Service
public class Haiku45OneByOneQ91 {

    public ResponseDto Question91() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Count right triangles formed by O(0,0), P(x1,y1), Q(x2,y2) with 0 <= xi,yi <= 50
        // Generated logic to solve the problem:
        int count = 0;
        for (int x1 = 0; x1 <= 50; x1++) {
            for (int y1 = 0; y1 <= 50; y1++) {
                for (int x2 = 0; x2 <= 50; x2++) {
                    for (int y2 = 0; y2 <= 50; y2++) {
                        if (x1 == 0 && y1 == 0) continue; // P can't be origin
                        if (x2 == 0 && y2 == 0) continue; // Q can't be origin
                        if (x1 == x2 && y1 == y2) continue; // P and Q must be different
                        
                        // Check for right angle at O: OP · OQ = 0
                        long dotO = (long) x1 * x2 + (long) y1 * y2;
                        if (dotO == 0) {
                            count++;
                            continue;
                        }
                        
                        // Check for right angle at P: PO · PQ = 0
                        long dotP = (long) (-x1) * (x2 - x1) + (long) (-y1) * (y2 - y1);
                        if (dotP == 0) {
                            count++;
                            continue;
                        }
                        
                        // Check for right angle at Q: QO · QP = 0
                        long dotQ = (long) (-x2) * (x1 - x2) + (long) (-y2) * (y1 - y2);
                        if (dotQ == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        count /= 2; // Each triangle counted twice (P,Q) and (Q,P)
        Object result = count;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
}
