package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45OneByOneQ49 {

    public ResponseDto Question49() {
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int p1 = primes.get(i);
                int p2 = primes.get(j);
                int p3 = 2 * p2 - p1;
                if (p3 < 10000 && isPrime(p3) && arePermutations(p1, p2, p3)) {
                    if (p1 != 1487) {
                        responseDto.setAnswer(Long.parseLong(p1 + "" + p2 + "" + p3));
                        return responseDto;
                    }
                }
            }
        }
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private boolean arePermutations(int a, int b, int c) {
        char[] aChars = String.valueOf(a).toCharArray();
        char[] bChars = String.valueOf(b).toCharArray();
        char[] cChars = String.valueOf(c).toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        Arrays.sort(cChars);
        return Arrays.equals(aChars, bChars) && Arrays.equals(bChars, cChars);
    }
}
