package com.comparisonai.haiku45model.services.haiku45model.onebyone;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Haiku45OneByOneQ218 {

    public ResponseDto Question218() {
        ResponseDto responseDto = new ResponseDto();

        // Problem 218: Perfect right-angled triangles that are not super-perfect
        // Perfect: primitive, hypotenuse is perfect square
        // Super-perfect: perfect AND area divisible by 6 and 28
        // Find count where c <= 10^16

        long limit = 10000000000000000L; // 10^16
        long count = 0;

        // Use Pythagorean triple formula: a^2 + b^2 = c^2
        // For primitive triples: a = m^2 - n^2, b = 2mn, c = m^2 + n^2
        // where m > n > 0, gcd(m,n)=1, m-n is odd

        // c must be a perfect square
        for (long m = 2; m * m + 1 <= limit; m++) {
            for (long n = 1; n < m; n++) {
                if (gcd(m, n) != 1 || (m - n) % 2 == 0) continue;

                long cSquared = m * m + n * n;
                long c = (long) Math.sqrt(cSquared);

                // Check if c is perfect square
                if (c * c != cSquared || c > limit) continue;

                // Verify c is a perfect square (c = k^2 for some k)
                long k = (long) Math.sqrt(c);
                if (k * k != c) continue;

                // Generate triangle
                long a = m * m - n * n;
                long b = 2 * m * n;
                long area = a * b / 2;

                // Check if super-perfect (area divisible by 6 and 28)
                boolean isSuperPerfect = (area % 6 == 0) && (area % 28 == 0);

                if (!isSuperPerfect) {
                    count++;
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
