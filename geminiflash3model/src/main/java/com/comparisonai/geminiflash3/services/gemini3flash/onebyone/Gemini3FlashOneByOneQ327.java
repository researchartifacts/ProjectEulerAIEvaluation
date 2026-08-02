package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ327 {

    public ResponseDto Question327() {
        ResponseDto responseDto = new ResponseDto();
        
        // M(C, R) is the minimum number of cards for R rooms with capacity C.
        // For C=3:
        // M(3, 1) = 3
        // M(3, 2) = 7
        // M(3, 3) = 15... no, let's re-read.
        // "This method allows you to travel through all three rooms using six security cards in total."
        // So M(3, 3) = 6. 
        // Wait, the example says M(3, 6) = 123.
        
        // The recurrence for M(C, R) is:
        // M(C, R) = ceil((M(C, R-1) - (C-2)) / (C-2)) * C + (M(C, R-1) - (C-2)) % (C-2)
        // More simply: M(C, R) = next_cost(M(C, R-1), C)
        // If we need to get X cards through the next door, and we can carry C cards:
        // To get through a door, we use 1 card. To come back, we use 1 card.
        // So each round trip costs 2 cards and nets C-2 cards in the next room.
        // Except the last trip which doesn't need to come back.
        
        long totalSum = 0;
        for (int C = 3; C <= 40; C++) {
            long currentM = 1; // Starting with 0 rooms passed, 1 card to pass 0th door (start)
            // Wait, for 1 room:
            // M(C, 1) = C. No, it's just getting through 1 door.
            // If R=1, you just need 1 card? No, you need to enter and exit.
            
            // Let's re-examine M(3, 6) = 123.
            // For R rooms, there are R+1 doors.
            // Let f(R) be the number of cards needed to be available at the start of room R to pass the remaining doors.
            // f(R+1) = 1 (to pass the last door)
            // f(i) = ceil((f(i+1) - (C-2)) / (C-2)) * C + ... this is tricky.
            
            // Correct logic:
            // To pass R rooms, we need to pass R+1 doors.
            // Let a[i] be the number of cards needed to pass door i, i+1, ..., R.
            // a[R] = 1 (last door)
            // a[i-1] = ceil((a[i] - (C-2)) / (C-2)) * 2 + a[i] + 1 ? No.
            
            // For a given C, let n be the number of cards needed to reach the next room.
            // To get n cards to the next room, we need M cards:
            // M = ceil((n - (C-1)) / (C-2)) * C + (n - (C-1)) % (C-2) + (C-1) ? No.
            
            // Let's use the formula: M(C, R) where R is rooms.
            // M(C, 0) = 1
            // M(C, R) = (ceil((M(C, R-1) - (C-1)) / (C-2))) * C + (M(C, R-1) - (C-1)) % (C-2) if we use C-1 to stay.
            
            long m = 1;
            for (int r = 0; r < 30; r++) {
                long needed = m;
                if (needed <= C - 1) {
                    m = needed + 1;
                } else {
                    long groups = (needed - (C - 1) + (C - 3)) / (C - 2);
                    m = groups * C + (needed - groups * (C - 2));
                }
            }
            totalSum += m;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }
}
