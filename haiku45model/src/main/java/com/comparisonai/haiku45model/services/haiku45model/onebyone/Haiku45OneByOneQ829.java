package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ829 {

    public ResponseDto Question829() {
        ResponseDto responseDto = new ResponseDto();

        long result = 0;

        for (int n = 2; n <= 31; n++) {
            long doubleFact = calculateDoubleFact(n);
            long m = findSmallestWithSameTree(doubleFact);
            result += m;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long calculateDoubleFact(int n) {
        long result = 1;
        for (int i = n; i > 0; i -= 2) {
            result *= i;
        }
        return result;
    }

    private long findSmallestWithSameTree(long n) {
        for (long candidate = 2; candidate <= n; candidate++) {
            if (hasIdenticalTree(candidate, n)) {
                return candidate;
            }
        }
        return n;
    }

    private boolean hasIdenticalTree(long a, long b) {
        return getTreeShape(a).equals(getTreeShape(b));
    }

    private String getTreeShape(long n) {
        if (isPrime(n)) return "P";

        long minDiff = Long.MAX_VALUE;
        long bestA = 0;
        for (long a = 2; a * a <= n; a++) {
            if (n % a == 0) {
                long b = n / a;
                if (b - a < minDiff) {
                    minDiff = b - a;
                    bestA = a;
                }
            }
        }

        long b = n / bestA;
        return "(" + getTreeShape(bestA) + "," + getTreeShape(b) + ")";
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
}
