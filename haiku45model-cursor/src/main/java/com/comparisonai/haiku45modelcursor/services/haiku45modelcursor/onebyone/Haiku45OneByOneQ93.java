package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 93
 */
@Service
public class Haiku45OneByOneQ93 {

    public ResponseDto Question93() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: Find the set of 4 distinct digits for which longest consecutive integers 1..n can be obtained
        // Generated logic to solve the problem:
        String bestSet = "";
        int longestConsecutive = 0;
        
        // Try all combinations of 4 distinct digits
        for (int a = 1; a <= 7; a++) {
            for (int b = a + 1; b <= 8; b++) {
                for (int c = b + 1; c <= 9; c++) {
                    for (int d = c + 1; d <= 10; d++) {
                        int[] digits = {a, b, c, d};
                        int consecutive = countConsecutiveFromOne(digits);
                        if (consecutive > longestConsecutive) {
                            longestConsecutive = consecutive;
                            bestSet = "" + a + b + c + d;
                        }
                    }
                }
            }
        }
        Object result = bestSet;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private int countConsecutiveFromOne(int[] digits) {
        java.util.Set<Integer> achievable = new java.util.HashSet<>();
        generateExpressions(digits, achievable);
        int n = 1;
        while (achievable.contains(n)) {
            n++;
        }
        return n - 1;
    }
    
    private void generateExpressions(int[] digits, java.util.Set<Integer> results) {
        java.util.List<int[]> perms = new java.util.ArrayList<>();
        permute(digits, 0, perms);
        
        for (int[] perm : perms) {
            for (int op1 = 0; op1 < 4; op1++) {
                for (int op2 = 0; op2 < 4; op2++) {
                    for (int op3 = 0; op3 < 4; op3++) {
                        evaluateExpressions(perm[0], perm[1], perm[2], perm[3], op1, op2, op3, results);
                    }
                }
            }
        }
    }
    
    private void permute(int[] arr, int idx, java.util.List<int[]> perms) {
        if (idx == arr.length) {
            perms.add(arr.clone());
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            permute(arr, idx + 1, perms);
            temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
        }
    }
    
    private void evaluateExpressions(int a, int b, int c, int d, int op1, int op2, int op3, java.util.Set<Integer> results) {
        // Try different bracket configurations
        try {
            // (a op1 b) op2 (c op3 d)
            double val1 = applyOp(applyOp(a, b, op1), applyOp(c, d, op3), op2);
            if (val1 > 0 && val1 == (int) val1) results.add((int) val1);
            
            // ((a op1 b) op2 c) op3 d
            double val2 = applyOp(applyOp(applyOp(a, b, op1), c, op2), d, op3);
            if (val2 > 0 && val2 == (int) val2) results.add((int) val2);
            
            // (a op1 (b op2 c)) op3 d
            double val3 = applyOp(applyOp(a, applyOp(b, c, op2), op1), d, op3);
            if (val3 > 0 && val3 == (int) val3) results.add((int) val3);
            
            // a op1 ((b op2 c) op3 d)
            double val4 = applyOp(a, applyOp(applyOp(b, c, op2), d, op3), op1);
            if (val4 > 0 && val4 == (int) val4) results.add((int) val4);
            
            // a op1 (b op2 (c op3 d))
            double val5 = applyOp(a, applyOp(b, applyOp(c, d, op3), op2), op1);
            if (val5 > 0 && val5 == (int) val5) results.add((int) val5);
        } catch (Exception e) {
            // Division by zero or other invalid operations
        }
    }
    
    private double applyOp(double x, double y, int op) {
        switch (op) {
            case 0: return x + y;
            case 1: return x - y;
            case 2: return x * y;
            case 3: 
                if (y == 0) throw new ArithmeticException("Division by zero");
                return x / y;
            default: return 0;
        }
    }
}
