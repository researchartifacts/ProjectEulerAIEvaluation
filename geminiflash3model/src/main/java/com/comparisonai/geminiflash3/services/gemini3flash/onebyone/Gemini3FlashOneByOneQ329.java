package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class Gemini3FlashOneByOneQ329 {

    public ResponseDto Question329() {
        ResponseDto responseDto = new ResponseDto();
        
        int squares = 500;
        int steps = 15;
        String sequence = "PPPPNNPPPNPPNPN";
        
        boolean[] isPrime = new boolean[squares + 1];
        for (int i = 2; i <= squares; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= squares; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= squares; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // dp[step][square] = probability of being at square after 'step' steps
        // and having heard the sequence so far.
        // We'll use BigInteger for the fraction to avoid precision issues.
        
        // Total probability = Sum_{start=1 to 500} (1/500 * P(sequence | start))
        
        // Let's use a simpler approach: 
        // For each start square, calculate the probability of the sequence.
        // Each step has a factor of 1/2 for movement (except boundaries) 
        // and 2/3 or 1/3 for croak.
        
        // denominator = 500 * 2^14 * 3^15 ? 
        // Wait, steps are 15. The croaks happen *before* jumping.
        // So 15 croaks and 14 jumps.
        
        BigInteger totalNum = BigInteger.ZERO;
        BigInteger commonDenom = BigInteger.valueOf(500).multiply(BigInteger.valueOf(3).pow(15)).multiply(BigInteger.valueOf(2).pow(14));
        
        // prob[square] at current step
        BigInteger[] prob = new BigInteger[squares + 1];
        
        // Initial state: at step 0, before first croak.
        for (int s = 1; s <= squares; s++) {
            // Start at square s with prob 1/500. 
            // We'll multiply everything by 500 * 3^15 * 2^14 at the end.
            // For now, let's just track the "numerator" for each start.
            
            BigInteger[] currentProb = new BigInteger[squares + 1];
            for(int i=0; i<=squares; i++) currentProb[i] = BigInteger.ZERO;
            currentProb[s] = BigInteger.ONE;
            
            BigInteger pathNum = BigInteger.ZERO;
            
            for (int step = 0; step < 15; step++) {
                char croak = sequence.charAt(step);
                BigInteger[] nextProb = new BigInteger[squares + 1];
                for(int i=0; i<=squares; i++) nextProb[i] = BigInteger.ZERO;
                
                for (int i = 1; i <= squares; i++) {
                    if (currentProb[i].equals(BigInteger.ZERO)) continue;
                    
                    // Croak probability
                    BigInteger cNum;
                    if (isPrime[i]) {
                        cNum = (croak == 'P') ? BigInteger.valueOf(2) : BigInteger.valueOf(1);
                    } else {
                        cNum = (croak == 'P') ? BigInteger.valueOf(1) : BigInteger.valueOf(2);
                    }
                    
                    BigInteger probWithCroak = currentProb[i].multiply(cNum);
                    
                    if (step == 14) {
                        pathNum = pathNum.add(probWithCroak);
                    } else {
                        // Jump
                        if (i == 1) {
                            nextProb[2] = nextProb[2].add(probWithCroak.multiply(BigInteger.valueOf(2))); // 1 * 2 because we divide by 2 later
                        } else if (i == 500) {
                            nextProb[499] = nextProb[499].add(probWithCroak.multiply(BigInteger.valueOf(2)));
                        } else {
                            nextProb[i - 1] = nextProb[i - 1].add(probWithCroak);
                            nextProb[i + 1] = nextProb[i + 1].add(probWithCroak);
                        }
                    }
                }
                currentProb = nextProb;
            }
            totalNum = totalNum.add(pathNum);
        }
        
        BigInteger gcd = totalNum.gcd(commonDenom);
        responseDto.setAnswer(totalNum.divide(gcd).toString() + "/" + commonDenom.divide(gcd).toString());
        return responseDto;
    }
}
