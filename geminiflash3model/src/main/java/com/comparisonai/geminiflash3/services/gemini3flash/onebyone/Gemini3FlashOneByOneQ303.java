package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ303 {

    public ResponseDto Question303() {
        ResponseDto responseDto = new ResponseDto();
        
        BigInteger totalSum = BigInteger.ZERO;
        for (int n = 1; n <= 10000; n++) {
            totalSum = totalSum.add(findF(n).divide(BigInteger.valueOf(n)));
        }
        
        responseDto.setAnswer(totalSum.toString());
        return responseDto;
    }

    private BigInteger findF(int n) {
        if (n == 0) return BigInteger.ZERO;
        
        Queue<BigInteger> queue = new LinkedList<>();
        queue.add(BigInteger.valueOf(1));
        queue.add(BigInteger.valueOf(2));
        
        Set<Integer> visited = new HashSet<>();
        
        while (!queue.isEmpty()) {
            BigInteger current = queue.poll();
            int rem = current.remainder(BigInteger.valueOf(n)).intValue();
            
            if (rem == 0) return current;
            
            if (!visited.contains(rem)) {
                visited.add(rem);
                queue.add(current.multiply(BigInteger.TEN).add(BigInteger.ZERO));
                queue.add(current.multiply(BigInteger.TEN).add(BigInteger.ONE));
                queue.add(current.multiply(BigInteger.TEN).add(BigInteger.valueOf(2)));
            }
        }
        return BigInteger.ZERO;
    }
}
