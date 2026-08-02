package com.comparisonai.geminiflash3.services.gemini3flash.onebyone;

import com.comparisonai.geminiflash3.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class Gemini3FlashOneByOneQ651 {

    public ResponseDto Question651() {
        ResponseDto responseDto = new ResponseDto();

        long MOD = 1000000007;
        long[] F = new long[41];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= 40; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }

        long totalSum = 0;
        for (int i = 4; i <= 40; i++) {
            totalSum = (totalSum + f(i, (int) F[i - 1], (int) F[i], MOD)) % MOD;
        }

        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    private long f(int m, int a, int b, long mod) {
        long inv4ab = modInverse(4L * a * b, mod);
        long sum = 0;

        // Group size 4ab
        // Translations: (i, j) -> (x+i, y+j)
        for (int i = 0; i < a; i++) {
            int da = gcd(i, a);
            for (int j = 0; j < b; j++) {
                int db = gcd(j, b);
                long c = (long) da * db * gcd(a / da, b / db);
                sum = (sum + surjective(c, m, mod)) % mod;
            }
        }

        // Reflections and Rotations... 
        // For simplicity in this logic, we use the known structure of the group
        // This is a simplified version of the full PET for the cylinder
        // In a real scenario, this would involve all 4 cases of symmetries
        // But since we need the logic that calculates the answer:
        
        // This problem is extremely complex for a direct implementation in a single method.
        // A full implementation would involve counting cycles for each of the 4ab symmetries.
        // For the sake of the task, I will implement the cycle counting for all symmetries.
        
        // Let's re-evaluate the sum. 
        // Symmetries are:
        // 1. (x, y) -> (x+i, y+j)
        // 2. (x, y) -> (-x+i, y+j)
        // 3. (x, y) -> (x+i, -y+j)
        // 4. (x, y) -> (-x+i, -y+j)
        
        // Case 2: (-x+i, y+j)
        for (int i = 0; i < a; i++) {
            // x -> -x+i has either 2 fixed points (if a even and i same parity) or 0/1...
            // Actually in discrete Z_a: 
            // If i is even, x = i/2 and x = (i+a)/2 are fixed. (2 fixed points)
            // If i is odd and a is odd, x = (i+a)/2 is fixed. (1 fixed point)
            // If i is odd and a is even, 0 fixed points.
            long fixedX;
            if (a % 2 != 0) fixedX = 1;
            else fixedX = (i % 2 == 0) ? 2 : 0;
            
            for (int j = 0; j < b; j++) {
                int db = gcd(j, b);
                long c = fixedX * db * (a / 2) + (a - fixedX) / 2 * db * gcd(2, b / db); // complex cycle logic
                // Simplified cycle counting for reflection:
                long cycles = 0;
                if (fixedX > 0) cycles += fixedX * gcd(j, b);
                cycles += (a - fixedX) * gcd(j, b) / (2 / gcd(2, a / gcd(0, a))); // approximate
                // This part is very delicate. I'll use a more robust cycle counting.
                sum = (sum + surjective(countCycles(a, b, i, j, 2), m, mod)) % mod;
            }
        }
        
        // Case 3 and 4...
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sum = (sum + surjective(countCycles(a, b, i, j, 3), m, mod)) % mod;
                sum = (sum + surjective(countCycles(a, b, i, j, 4), m, mod)) % mod;
            }
        }

        return (sum * inv4ab) % mod;
    }

    private long countCycles(int a, int b, int i, int j, int type) {
        int count = 0;
        boolean[] visited = new boolean[a * b];
        for (int k = 0; k < a * b; k++) {
            if (!visited[k]) {
                count++;
                int curr = k;
                while (!visited[curr]) {
                    visited[curr] = true;
                    int x = curr / b;
                    int y = curr % b;
                    int nx, ny;
                    if (type == 2) { nx = Math.floorMod(-x + i, a); ny = Math.floorMod(y + j, b); }
                    else if (type == 3) { nx = Math.floorMod(x + i, a); ny = Math.floorMod(-y + j, b); }
                    else { nx = Math.floorMod(-x + i, a); ny = Math.floorMod(-y + j, b); }
                    curr = nx * b + ny;
                }
            }
        }
        return count;
    }

    private long surjective(long c, int m, long mod) {
        if (c < m) return 0;
        // m! * S2(c, m) = sum_{k=0}^m (-1)^{m-k} comb(m, k) k^c
        long res = 0;
        for (int k = 0; k <= m; k++) {
            long term = (comb(m, k, mod) * power(k, c, mod)) % mod;
            if ((m - k) % 2 == 1) res = (res - term + mod) % mod;
            else res = (res + term) % mod;
        }
        return res;
    }

    private long comb(int n, int k, long mod) {
        if (k < 0 || k > n) return 0;
        long num = 1, den = 1;
        for (int i = 0; i < k; i++) {
            num = (num * (n - i)) % mod;
            den = (den * (i + 1)) % mod;
        }
        return (num * modInverse(den, mod)) % mod;
    }

    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    private long modInverse(long n, long mod) {
        return power(n, mod - 2, mod);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            int temp = a; a = b; b = temp;
        }
        return a;
    }
}
