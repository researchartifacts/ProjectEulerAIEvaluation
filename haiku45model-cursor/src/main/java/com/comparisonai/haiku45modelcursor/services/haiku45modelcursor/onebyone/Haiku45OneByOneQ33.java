package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor.onebyone;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Problem 33
 */
@Service
public class Haiku45OneByOneQ33 {

    public ResponseDto Question33() {
        ResponseDto responseDto = new ResponseDto();

        // Problem: The fraction 49/98 is a curious fraction, where 49/98 = 4/8 by cancelling the 9s (which is correct).
        // Find the denominator when the product of the four non-trivial two-digit fractions less than 1 is reduced to lowest terms.
        // Generated logic to solve the problem:
        
        java.util.List<int[]> fractions = new java.util.ArrayList<>();
        
        // Find all two-digit fractions less than 1 with interesting cancelling properties
        for (int num = 10; num < 100; num++) {
            for (int den = num + 1; den < 100; den++) {
                // Check if not a trivial fraction (where both end in 0)
                if (num % 10 == 0 && den % 10 == 0) {
                    continue;
                }
                
                // Try cancelling each digit
                String numStr = String.valueOf(num);
                String denStr = String.valueOf(den);
                
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (numStr.charAt(i) == denStr.charAt(j)) {
                            char common = numStr.charAt(i);
                            String newNum = numStr.substring(1 - i);
                            String newDen = denStr.substring(1 - j);
                            
                            if (newNum.isEmpty() || newDen.isEmpty() || newDen.charAt(0) == '0') {
                                continue;
                            }
                            
                            int n1 = Integer.parseInt(newNum);
                            int d1 = Integer.parseInt(newDen);
                            
                            // Check if the fraction equals after cancelling
                            if (num * d1 == den * n1) {
                                fractions.add(new int[]{num, den});
                                i = 2; j = 2; // Break both loops
                            }
                        }
                    }
                }
            }
        }
        
        // Calculate GCD of all numerators and all denominators
        long numProduct = 1, denProduct = 1;
        for (int[] frac : fractions) {
            numProduct *= frac[0];
            denProduct *= frac[1];
        }
        
        long gcd = gcd(numProduct, denProduct);
        Object result = denProduct / gcd;
        
        responseDto.setAnswer(result);
        return responseDto;
    }
    
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
