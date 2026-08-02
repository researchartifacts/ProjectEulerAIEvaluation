package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Gemini3FlashOneByOneQ219 {

    public ResponseDto Question219() {
        ResponseDto responseDto = new ResponseDto();
        long n = 1_000_000_000L;
        
        // Huffman coding with costs 1 and 4.
        // We start with 1 node of cost 0.
        // Each step, we pick the cheapest node (cost c) and replace it with 
        // two nodes of cost c+1 and c+4.
        
        TreeMap<Long, Long> counts = new TreeMap<>();
        counts.put(0L, 1L);
        long currentNodes = 1;
        
        while (currentNodes < n) {
            long cost = counts.firstKey();
            long count = counts.get(cost);
            long toAdd = Math.min(count, n - currentNodes);
            
            counts.put(cost + 1, counts.getOrDefault(cost + 1, 0L) + toAdd);
            counts.put(cost + 4, counts.getOrDefault(cost + 4, 0L) + toAdd);
            
            if (toAdd == count) counts.remove(cost);
            else counts.put(cost, count - toAdd);
            
            currentNodes += toAdd;
        }
        
        long totalCost = 0;
        for (Map.Entry<Long, Long> entry : counts.entrySet()) {
            totalCost += entry.getKey() * entry.getValue();
        }
        
        responseDto.setAnswer(totalCost);
        return responseDto;
    }
}
