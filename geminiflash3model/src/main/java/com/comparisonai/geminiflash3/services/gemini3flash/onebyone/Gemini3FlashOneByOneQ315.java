package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ315 {

    private static final int[][] segments = {
        {1, 1, 1, 0, 1, 1, 1}, // 0
        {0, 0, 1, 0, 0, 1, 0}, // 1
        {1, 0, 1, 1, 1, 0, 1}, // 2
        {1, 0, 1, 1, 0, 1, 1}, // 3
        {0, 1, 1, 1, 0, 1, 0}, // 4
        {1, 1, 0, 1, 0, 1, 1}, // 5
        {1, 1, 0, 1, 1, 1, 1}, // 6
        {1, 1, 1, 0, 0, 1, 0}, // 7
        {1, 1, 1, 1, 1, 1, 1}, // 8
        {1, 1, 1, 1, 0, 1, 1}  // 9
    };

    public ResponseDto Question315() {
        ResponseDto responseDto = new ResponseDto();
        
        long diff = 0;
        int A = 10000000;
        int B = 20000000;
        
        boolean[] isPrime = new boolean[B];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < B; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < B; j += i) isPrime[j] = false;
            }
        }
        
        for (int p = A; p < B; p++) {
            if (isPrime[p]) {
                diff += calculateDiff(p);
            }
        }
        
        responseDto.setAnswer(diff);
        return responseDto;
    }

    private long calculateDiff(int n) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(n);
        while (n >= 10) {
            int next = 0;
            int temp = n;
            while (temp > 0) {
                next += temp % 10;
                temp /= 10;
            }
            n = next;
            sequence.add(n);
        }
        
        long samTransitions = 0;
        long maxTransitions = 0;
        
        for (int i = 0; i < sequence.size(); i++) {
            samTransitions += countSegments(sequence.get(i)) * 2;
        }
        
        // Max's transitions
        maxTransitions += countSegments(sequence.get(0)); // turn on
        for (int i = 0; i < sequence.size() - 1; i++) {
            maxTransitions += transitionsBetween(sequence.get(i), sequence.get(i + 1));
        }
        maxTransitions += countSegments(sequence.get(sequence.size() - 1)); // turn off
        
        return samTransitions - maxTransitions;
    }

    private int countSegments(int n) {
        int count = 0;
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            int d = c - '0';
            for (int b : segments[d]) count += b;
        }
        return count;
    }

    private int transitionsBetween(int n1, int n2) {
        String s1 = String.valueOf(n1);
        String s2 = String.valueOf(n2);
        int t = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int d1 = (i < len1) ? s1.charAt(len1 - 1 - i) - '0' : -1;
            int d2 = (i < len2) ? s2.charAt(len2 - 1 - i) - '0' : -1;
            
            if (d1 == -1) {
                for (int b : segments[d2]) t += b;
            } else if (d2 == -1) {
                for (int b : segments[d1]) t += b;
            } else {
                for (int j = 0; j < 7; j++) {
                    if (segments[d1][j] != segments[d2][j]) t++;
                }
            }
        }
        return t;
    }
}
