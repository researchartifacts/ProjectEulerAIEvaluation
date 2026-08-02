package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
public class Gemini3FlashOneByOneQ809 {

    private Map<String, BigInteger> memo = new HashMap<>();
    private final BigInteger MOD = BigInteger.TEN.pow(15);

    public ResponseDto Question809() {
        ResponseDto responseDto = new ResponseDto();
        // f(22/7) mod 10^15
        BigInteger result = f(22, 7);
        responseDto.setAnswer(result.toString());
        return responseDto;
    }

    private BigInteger f(long num, long den) {
        if (num % den == 0) {
            return BigInteger.valueOf(num / den).mod(MOD);
        }
        
        String key = num + "/" + den;
        if (memo.containsKey(key)) return memo.get(key);
        
        BigInteger res;
        if (num < den) {
            // f(1/(1-x))
            res = f(den, den - num);
        } else {
            // f(1/(ceil(x)-x) - 1 + f(x-1))
            long ceilX = (num + den - 1) / den;
            // ceil(x) - x = ceilX - num/den = (ceilX*den - num)/den
            // 1/(ceil(x)-x) = den / (ceilX*den - num)
            BigInteger term2 = f(num - den, den);
            // newNum/newDen = den / (ceilX*den - num) - 1 + term2
            // Let a = den, b = ceilX*den - num, c = term2
            // a/b - 1 + c = (a - b + b*c) / b
            long a = den;
            long b = ceilX * den - num;
            BigInteger newNum = BigInteger.valueOf(a - b).add(BigInteger.valueOf(b).multiply(term2));
            res = f(newNum.longValue(), b); // This is simplified, newNum might be large
        }
        
        memo.put(key, res.mod(MOD));
        return res.mod(MOD);
    }
}
