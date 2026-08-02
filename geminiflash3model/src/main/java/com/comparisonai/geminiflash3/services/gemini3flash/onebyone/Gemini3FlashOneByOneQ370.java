package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ370 {

    public ResponseDto Question370() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 25000000000000L;
        
        long count = countGeometricTriangles(limit);
        
        responseDto.setAnswer(count);
        return responseDto;
    }

    private long countGeometricTriangles(long limit) {
        // a=uk^2, b=ukm, c=um^2, gcd(k,m)=1, k<=m<k*phi
        // u(k^2+km+m^2) <= limit
        long count = 0;
        double phi = (1 + Math.sqrt(5)) / 2;
        for (long k = 1; ; k++) {
            long k2 = k * k;
            if (k2 + k + 1 > limit) break;
            for (long m = k; m < k * phi; m++) {
                if (gcd(k, m) != 1) continue;
                long perim = k2 + k * m + m * m;
                if (perim > limit) break;
                count += limit / perim;
            }
        }
        return count;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            a %= b;
            long temp = a; a = b; b = temp;
        }
        return a;
    }
}
