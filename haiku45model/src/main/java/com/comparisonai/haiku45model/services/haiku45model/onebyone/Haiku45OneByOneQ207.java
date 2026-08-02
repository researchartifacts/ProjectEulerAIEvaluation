package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ207 {

    public ResponseDto Question207() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 207: Partitions of the form 4^t = 2^t + k
        // Find smallest m where P(m) < 1/12345
        // P(m) = proportion of partitions with k <= m that are perfect

        long result = 0;
        int threshold = 12345;

        // For 4^t = 2^t + k, we have k = 4^t - 2^t = 2^t(2^t - 1)
        // k is perfect when t is an integer

        // Generate k values: k = 2^t(2^t - 1) for non-integer t values
        // Find perfect partitions (where t is integer)

        long perfectCount = 0;
        long totalCount = 0;

        // We need to find k values and classify them
        // For each m, count how many valid k <= m exist
        // and how many of those correspond to perfect (integer t) partitions

        // k values for perfect partitions: t = 1,2,3,...
        // k = 2^1(2^1-1) = 2
        // k = 2^2(2^2-1) = 12
        // k = 2^3(2^3-1) = 56
        // k = 2^4(2^4-1) = 240
        // ...

        long m = 0;
        perfectCount = 0;
        totalCount = 0;

        // Iterate through m values to find when P(m) < 1/12345
        for (m = 1; m < Long.MAX_VALUE; m++) {
            // Count perfect partitions with k <= m
            // Perfect partitions have k = 2^t(2^t - 1) for integer t

            long tempPerfect = 0;
            long t = 1;
            while (true) {
                long k = (1L << t) * ((1L << t) - 1);
                if (k > m) break;
                tempPerfect++;
                t++;
            }

            // Count all partitions with k <= m
            // Need to find how many k values satisfy 4^s = 2^s + k for some real s
            // and k <= m

            long tempTotal = tempPerfect;

            // For non-integer t: 4^t = 2^t + k means 2^t(2^t - 1) = k
            // This means 2^(2t) - 2^t - k = 0
            // Using quadratic formula: 2^t = (1 + sqrt(1 + 4k)) / 2
            // This gives valid k values up to m

            for (long k = 1; k <= m; k++) {
                double discriminant = 1 + 4.0 * k;
                if (discriminant >= 0) {
                    double twoToT = (1 + Math.sqrt(discriminant)) / 2;
                    if (twoToT > 1 && Math.log(twoToT) / Math.log(2) > 0) {
                        tempTotal++;
                    }
                }
            }

            if (tempTotal > 0 && tempPerfect * threshold < tempTotal) {
                result = m;
                break;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }
}
