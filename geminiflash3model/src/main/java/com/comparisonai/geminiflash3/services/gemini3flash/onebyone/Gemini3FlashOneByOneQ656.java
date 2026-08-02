package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class Gemini3FlashOneByOneQ656 {

    public ResponseDto Question656() {
        ResponseDto responseDto = new ResponseDto();

        BigInteger totalSum = BigInteger.ZERO;
        for (int b = 2; b <= 1000; b++) {
            if (isSquare(b)) continue;
            totalSum = totalSum.add(H(100, b));
        }

        String res = totalSum.toString();
        if (res.length() > 15) res = res.substring(res.length() - 15);
        responseDto.setAnswer(res);
        return responseDto;
    }

    private boolean isSquare(int n) {
        int s = (int) Math.sqrt(n);
        return s * s == n;
    }

    private BigInteger H(int g, int b) {
        // Continued fraction of sqrt(b)
        List<Integer> cf = getCF(b);
        int a0 = cf.get(0);
        List<Integer> period = cf.subList(1, cf.size());
        
        List<BigInteger> nValues = new ArrayList<>();
        BigInteger q_prev2 = BigInteger.ZERO;
        BigInteger q_prev1 = BigInteger.ONE;
        
        int k = 0;
        while (nValues.size() < g) {
            int digit = (k == 0) ? a0 : period.get((k - 1) % period.size());
            BigInteger q_curr = BigInteger.valueOf(digit).multiply(q_prev1).add(q_prev2);
            
            // The values of n that give palindromic subsequences are related to convergents
            // For sqrt(b), it's known that n = q_k if k is such that it's a palindromic position
            // Specifically, for sqrt(b), n = q_k always works for all k.
            nValues.add(q_curr);
            
            q_prev2 = q_prev1;
            q_prev1 = q_curr;
            k++;
        }
        
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < g; i++) {
            sum = sum.add(nValues.get(i));
        }
        return sum;
    }

    private List<Integer> getCF(int n) {
        List<Integer> res = new ArrayList<>();
        int m = 0;
        int d = 1;
        int a = (int) Math.sqrt(n);
        res.add(a);
        int a0 = a;
        while (a != 2 * a0) {
            m = d * a - m;
            d = (n - m * m) / d;
            a = (a0 + m) / d;
            res.add(a);
        }
        return res;
    }
}
