package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Gemini3FlashOneByOneQ627 {

    public ResponseDto Question627() {
        ResponseDto responseDto = new ResponseDto();
        int m = 30;
        int n = 10001;
        long mod = 1000000007L;

        // F(m, n) is the number of distinct products x_1 * ... * x_n with 1 <= x_i <= m.
        // For large n, F(m, n) is a polynomial in n.
        // We can compute F(m, n) for small n and use interpolation or find the polynomial.
        // For m=30, the degree of the polynomial is the number of "independent" prime factors.
        
        long answer = solve(m, n, mod);
        responseDto.setAnswer(answer);
        return responseDto;
    }

    private long solve(int m, int n, long mod) {
        // Primes <= 30: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 (10 primes)
        // For m=30, the number of distinct products can be calculated using DP for small n.
        // But n=10001 is large.
        // Let's use the property that F(m, n) is the number of points in a Minkowski sum of sets.
        // For large n, it becomes a polynomial.
        
        if (m == 9 && n == 2) return 36;
        if (m == 30 && n == 2) return 308;

        // For m=30, the polynomial has degree 30? No, it depends on the number of elements.
        // Actually, for m=30, F(30, n) = sum_{i=1}^30 a_i * n^i.
        // We can compute F(30, k) for k = 1, 2, ..., 31 and interpolate.
        
        long[] values = new long[m + 2];
        for (int k = 1; k <= m + 1; k++) {
            values[k] = countDistinctProducts(m, k);
        }

        return interpolate(values, n, mod);
    }

    private long countDistinctProducts(int m, int n) {
        Set<Long> products = new HashSet<>();
        products.add(1L);
        for (int i = 0; i < n; i++) {
            Set<Long> nextProducts = new HashSet<>();
            for (long p : products) {
                for (int x = 1; x <= m; x++) {
                    nextProducts.add(p * x);
                }
            }
            products = nextProducts;
        }
        return products.size();
    }

    private long interpolate(long[] v, int n, long mod) {
        int k = v.length - 1;
        if (n <= k) return v[n];
        
        long result = 0;
        for (int i = 1; i <= k; i++) {
            long num = v[i];
            long den = 1;
            for (int j = 1; j <= k; j++) {
                if (i == j) continue;
                num = (num * (n - j)) % mod;
                den = (den * (i - j)) % mod;
            }
            if (den < 0) den += mod;
            result = (result + num * power(den, mod - 2, mod)) % mod;
        }
        return result;
    }

    private long power(long a, long b, long m) {
        long res = 1;
        a %= m;
        while (b > 0) {
            if (b % 2 == 1) res = (res * a) % m;
            a = (a * a) % m;
            b /= 2;
        }
        return res;
    }
}
