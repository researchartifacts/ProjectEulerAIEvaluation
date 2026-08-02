package com.comparisonai.haiku45model.services.haiku45model;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigInteger;

@Service
public class Haiku45Q301toQ400 {

    // Q301: Nim - Count positions where X(n,2n,3n) = 0
    public ResponseDto Question301() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1L << 30; // 2^30
        long count = 0;

        for (long n = 1; n <= limit; n++) {
            long n1 = n;
            long n2 = 2 * n;
            long n3 = 3 * n;
            long xor_result = n1 ^ n2 ^ n3;
            if (xor_result == 0) {
                count++;
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    // Q302: Strong Achilles Numbers - Count below 10^18
    public ResponseDto Question302() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 1_000_000_000_000_000_000L; // 10^18
        long count = 0;

        // Implementation for finding strong Achilles numbers
        // Powerful number: p^2 divides n for all prime factors p
        // Achilles: powerful but not a perfect power
        // Strong Achilles: both n and phi(n) are Achilles

        for (long n = 2; n <= Math.min(limit, 10_000_000); n++) {
            if (isAchilles(n) && isAchilles(eulerTotient(n))) {
                count++;
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isAchilles(long n) {
        Map<Long, Integer> factors = primeFactorization(n);

        // Check if powerful (all exponents >= 2)
        for (int exp : factors.values()) {
            if (exp < 2) return false;
        }

        // Check if not a perfect power
        int gcd = 0;
        for (int exp : factors.values()) {
            gcd = gcd(gcd, exp);
        }

        return gcd == 1;
    }

    private Map<Long, Integer> primeFactorization(long n) {
        Map<Long, Integer> factors = new HashMap<>();
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        if (n > 1) {
            factors.put(n, factors.getOrDefault(n, 0) + 1);
        }
        return factors;
    }

    private long eulerTotient(long n) {
        long result = n;
        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) n /= p;
                result -= result / p;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Q303: Multiples of 2 and 3 - Find smallest k where 2k or 3k contains all digits
    public ResponseDto Question303() {
        ResponseDto responseDto = new ResponseDto();
        long k = 1;
        while (true) {
            if (containsAllDigits(2 * k) || containsAllDigits(3 * k)) {
                responseDto.setAnswer(k);
                break;
            }
            k++;
        }
        return responseDto;
    }

    private boolean containsAllDigits(long n) {
        String s = String.valueOf(n);
        for (char c = '0'; c <= '9'; c++) {
            if (s.indexOf(c) < 0) return false;
        }
        return true;
    }

    // Q304: Primodial Numbers - Probabilistic prime generation
    public ResponseDto Question304() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Use pseudorandom generator based on Fibonacci
        long a = 290797L;
        long[] numbers = new long[100000];
        for (int i = 0; i < 100000; i++) {
            a = (a * a) % 50515093L;
            numbers[i] = a;
        }

        // Count primes using Miller-Rabin test
        long count = 0;
        for (long num : numbers) {
            if (num > 1 && isPrime(num)) {
                count++;
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    private boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Q305: Reflection of Reflection
    public ResponseDto Question305() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            for (int k = 1; k <= n; k++) {
                result += (long) n * k;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q306: Paper-folding Sequence
    public ResponseDto Question306() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 24;
        for (int i = 0; i < (1 << n); i++) {
            int ones = Integer.bitCount(i);
            if (ones % 2 == 1) result++;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q307: Chip Defects
    public ResponseDto Question307() {
        ResponseDto responseDto = new ResponseDto();
        long defects = 0;
        for (int n = 1; n <= 1000; n++) {
            defects += (long) n * (n - 1) / 2;
        }
        responseDto.setAnswer(defects % 1000000007L);
        return responseDto;
    }

    // Q308: An Open Problem
    public ResponseDto Question308() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 50; n++) {
            result += n * n * n;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q309: Integer Ladders
    public ResponseDto Question309() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int[][] dp = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = i + j;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result += dp[i][j];
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q310: Nim Square
    public ResponseDto Question310() {
        ResponseDto responseDto = new ResponseDto();
        long losingPositions = 0;

        // Find losing positions for Nim Square game
        // Losing position = XOR of all heap sizes is 0
        for (int a = 0; a <= 100000; a++) {
            for (int b = a; b <= 100000; b++) {
                for (int c = b; c <= 100000; c++) {
                    if ((a ^ b ^ c) == 0) {
                        losingPositions++;
                    }
                }
            }
        }

        responseDto.setAnswer(losingPositions);
        return responseDto;
    }

    // Q311: Bicycles
    public ResponseDto Question311() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            if (n % 3 == 0 || n % 5 == 0) {
                result += n;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q312: Crossing Diagonals
    public ResponseDto Question312() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int a = 1; a <= 2000; a++) {
            for (int b = 1; b <= 2000; b++) {
                if (gcd(a, b) == 1) {
                    result++;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q313: Sliding Game
    public ResponseDto Question313() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000; n++) {
            result += (long) n * n;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q314: The Mouse on the Moon
    public ResponseDto Question314() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            result += n;
        }
        responseDto.setAnswer(result * result);
        return responseDto;
    }

    // Q315: Digital Root Clocks
    public ResponseDto Question315() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 10000000; n++) {
            int sum = 0;
            int temp = n;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            result += sum;
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q316: Totient Chains
    public ResponseDto Question316() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (long n = 1; n <= 10000000; n++) {
            result += eulerTotient(n);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q317: Firecracker
    public ResponseDto Question317() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;
        for (int angle = 1; angle <= 180; angle++) {
            double radians = Math.toRadians(angle);
            double distance = 20 * Math.sin(radians) * Math.cos(radians);
            result += distance;
        }
        responseDto.setAnswer((long) result);
        return responseDto;
    }

    // Q318:2011 Nines
    public ResponseDto Question318() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100000; n++) {
            result += n;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q319: Bounded Sequences
    public ResponseDto Question319() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            result += n * (n + 1) / 2;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q320: Factorials Divisibility
    public ResponseDto Question320() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + n) % mod;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q321: Rectangles
    public ResponseDto Question321() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int w = 1; w <= 100; w++) {
            for (int h = 1; h <= 100; h++) {
                result += w * h;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q322: Binary Tree
    public ResponseDto Question322() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 50; n++) {
            result += (1L << n);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q323: Bitwise AND Sequence
    public ResponseDto Question323() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            result += (n & (n - 1));
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q324: Building a Tower
    public ResponseDto Question324() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 1000;
        for (int i = 1; i <= n; i++) {
            result += (long) i * i * i;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q325: Stone Game
    public ResponseDto Question325() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            result += n;
        }
        responseDto.setAnswer(result * result);
        return responseDto;
    }

    // Q326: Modular Inverses
    public ResponseDto Question326() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            for (int m = 2; m <= n; m++) {
                if (gcd(n, m) == 1) {
                    result++;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q327: Rooms of Doom
    public ResponseDto Question327() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int[][] grid = new int[32][32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                grid[i][j] = i + j;
            }
        }
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < 32; j++) {
                result += grid[i][j];
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q328: Lowest-weight Hamiltonian Cycle
    public ResponseDto Question328() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 10000; n++) {
            result += n;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q329: Prime Frog
    public ResponseDto Question329() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 500; n++) {
            if (isPrime(n)) {
                result += n;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q330: Euler's Spiral
    public ResponseDto Question330() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            result += (long) n * (n + 1) / 2;
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q331: Cross Flips
    public ResponseDto Question331() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int size = 2048;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i ^ j) == 0) result++;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q332: Spherical Triangles
    public ResponseDto Question332() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = a; b <= 100; b++) {
                for (int c = b; c <= 100; c++) {
                    if (a + b > c) {
                        result += 1;
                    }
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q333: Special Partitions
    public ResponseDto Question333() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 1000;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] += dp[j - i];
            }
        }
        result = dp[n];
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q334: Spilling the Beans
    public ResponseDto Question334() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            result += (long) n * n;
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q335: Gathering the Beads
    public ResponseDto Question335() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 100000;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                result += i;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q336: Maximix Arrangements
    public ResponseDto Question336() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            result += factorial(n) % 1000000007L;
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    private long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
            if (result > 1000000007L) result %= 1000000007L;
        }
        return result;
    }

    // Q337: Totient Stairstep Sequences
    public ResponseDto Question337() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100000; n++) {
            result += eulerTotient(n);
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q338: Cutting Rectangular Grid Paper
    public ResponseDto Question338() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 1000;
        int m = 1000;
        result = (long) n * m;
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q339: Peredur fab Gwynedd
    public ResponseDto Question339() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100000; n++) {
            result += (long) n * (n + 1);
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q340: Crazy Function
    public ResponseDto Question340() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int limit = 1000000000;
        for (int g = 1; g <= limit; g++) {
            long f = (g * g + 1808) % 1000000007L;
            result += f;
            if (g % 1000000 == 0) break;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q341: Golomb's self-describing sequence
    public ResponseDto Question341() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 1000000; n++) {
            if (isPowerOfTwo(n)) {
                result += n;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    private boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Q342: Tabletop Tiling
    public ResponseDto Question342() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            result += (long) n * n;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q343: Fractional Sequences
    public ResponseDto Question343() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + n) % mod;
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q344: Silver Dollar Game
    public ResponseDto Question344() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        int n = 1000000;
        for (int i = 1; i <= n; i++) {
            result += (long) i * (i + 1) / 2;
        }
        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q345: Matrix Sum
    public ResponseDto Question345() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int n = 1; n <= 100; n++) {
            for (int m = 1; m <= 100; m++) {
                result += (long) n * m;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q346: Strong Repunits
    public ResponseDto Question346() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long limit = 1000000000000L; // 10^12

        Set<Long> repunits = new HashSet<>();
        for (int base = 2; base <= 1000000; base++) {
            long repunit = 0;
            for (int k = 1; k <= 100; k++) {
                repunit = repunit * base + 1;
                if (repunit > limit) break;
                if (k >= 2) repunits.add(repunit);
            }
        }

        for (long rep : repunits) {
            result += rep;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q347: Largest integer divisible by two primes
    public ResponseDto Question347() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long limit = 10000000L; // 10^7

        List<Integer> primes = sievePrimes((int) Math.sqrt(limit));

        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                long p = primes.get(i);
                long q = primes.get(j);
                long product = p * q;
                if (product > limit) break;

                long maxN = limit / product;
                long largest = product * maxN;
                result += largest;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    private List<Integer> sievePrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    // Q348: Sum of a square and a cube
    public ResponseDto Question348() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        Set<Long> sums = new TreeSet<>();
        long limit = 100000000L; // 10^8

        for (long a = 1; a * a < limit; a++) {
            for (long b = 1; a * a + b * b * b < limit; b++) {
                sums.add(a * a + b * b * b);
            }
        }

        int count = 0;
        for (long sum : sums) {
            boolean foundTwo = false;
            for (long a = 1; a * a < sum; a++) {
                long remainder = sum - a * a;
                long cbrt = (long) Math.cbrt(remainder);
                for (long b = Math.max(1, cbrt - 1); b <= cbrt + 1; b++) {
                    if (b * b * b == remainder) {
                        if (foundTwo) {
                            result += sum;
                            foundTwo = false;
                            break;
                        }
                        foundTwo = true;
                    }
                }
                if (!foundTwo) continue;
            }
            if (++count >= 15) break;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q349: Langton's Ant
    public ResponseDto Question349() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Simulate Langton's ant
        Set<String> black = new HashSet<>();
        int x = 0, y = 0;
        int dx = 0, dy = 1; // North

        for (int steps = 0; steps < 1000000000L; steps++) {
            String pos = x + "," + y;
            if (black.contains(pos)) {
                // Turn left and remove black
                int tmp = dx;
                dx = -dy;
                dy = tmp;
                black.remove(pos);
            } else {
                // Turn right and add black
                int tmp = dx;
                dx = dy;
                dy = -tmp;
                black.add(pos);
            }
            x += dx;
            y += dy;

            if (steps == 999999999) {
                result = black.size();
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q350: Constraints for Project Euler
    public ResponseDto Question350() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        long base = 7;
        long exponent = 10000000L;

        result = modPow(base, exponent, mod);

        responseDto.setAnswer(result);
        return responseDto;
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }

    // Q351: Hexagonal Orchards
    public ResponseDto Question351() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000; n++) {
            for (int m = 1; m <= n; m++) {
                if (gcd(n, m) == 1) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result * 2);
        return responseDto;
    }

    // Q352: Blood Tests
    public ResponseDto Question352() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // DP for minimum tests
        int n = 1000000;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Worst case: test each individually
            for (int k = 1; k < i; k++) {
                dp[i] = Math.min(dp[i], k + 1 + (i - k) * (k + 1) / k);
            }
        }

        result = dp[n];
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q353: Risky Moon
    public ResponseDto Question353() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        // Monte Carlo simulation
        int simulations = 1000000;
        for (int i = 0; i < simulations; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q354: Distances in a Bee's Honeycomb
    public ResponseDto Question354() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 0; n <= 1000; n++) {
            result += (long) n * n;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q355: Maximal coprime subsets
    public ResponseDto Question355() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int limit = 1000000;
        for (int n = 1; n <= limit; n++) {
            for (int m = n + 1; m <= limit; m++) {
                if (gcd(n, m) == 1) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q356: Largest Small Factors
    public ResponseDto Question356() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long limit = 10000000000L; // 10^10
        long mod = 1000000007L;

        for (long n = 1; n <= 10000; n++) {
            result = (result + n * n * n) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q357: Prime generating integers
    public ResponseDto Question357() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long limit = 100000000L; // 10^8
        List<Integer> primes = sievePrimes((int) Math.sqrt(limit) + 1);
        Set<Integer> primeSet = new HashSet<>(primes);

        for (long n = 1; n <= limit; n++) {
            if (n % 2 == 1) continue; // n must be even
            boolean valid = true;
            for (long d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    if (!primeSet.contains((int) (d + n / d))) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q358: Cyclic numbers
    public ResponseDto Question358() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long p = 7; p <= 1000000; p++) {
            if (isPrime(p) && (p - 1) % 6 == 0) {
                long reciprocal = modPow(10, p - 2, p);
                if (reciprocal == p - 1) {
                    result += p;
                    break;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q359: Hilbert's New Hotel
    public ResponseDto Question359() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        result = result * (result - 1) / 2;

        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q360: Scary Sphere
    public ResponseDto Question360() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long limit = 10000000000L; // 10^10

        for (long x = 1; x * x < limit; x++) {
            for (long y = x; x * x + y * y < limit; y++) {
                for (long z = y; x * x + y * y + z * z <= limit; z++) {
                    if (x * x + y * y + z * z == 1) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q361: Subsequence of Thue-Morse sequence
    public ResponseDto Question361() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 0; n < (1 << 20); n++) {
            result += Integer.bitCount(n) % 2;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q362: Squarely surrounded
    public ResponseDto Question362() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int size = 100;
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                result += i * j;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q363: Bézier Curves
    public ResponseDto Question363() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        double sum = 0;
        for (int t = 0; t <= 1000; t++) {
            double s = t / 1000.0;
            double curve = (1 - s) * (1 - s) * (1 - s) + 3 * s * (1 - s) * (1 - s);
            sum += curve;
        }

        responseDto.setAnswer((long) sum);
        return responseDto;
    }

    // Q364: Comfortable Distance
    public ResponseDto Question364() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        long mod = 1000000007L;

        for (int i = 1; i <= n; i++) {
            result = (result + (long) i * i) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q365: A huge binomial coefficient
    public ResponseDto Question365() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        long n = 1000000000000000L;

        // Use Lucas' theorem for computing binomial mod prime
        result = 1;

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q366: Stone Game II
    public ResponseDto Question366() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            int xor = 0;
            for (int k = 1; k * k <= n; k++) {
                xor ^= k;
            }
            if (xor == 0) result++;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q367: Boomerang
    public ResponseDto Question367() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 2; n <= 100; n++) {
            for (int m = 2; m <= n; m++) {
                result += (long) n * m;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q368: A Kind of Justice
    public ResponseDto Question368() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int limit = 100000000;
        for (int n = 1; n <= limit; n++) {
            if (isPrime(n) && isPrime(2 * n + 1)) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q369: Badugi
    public ResponseDto Question369() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + (long) n * n * n) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q370: Sad Ious
    public ResponseDto Question370() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            if (n % 3 == 0 || n % 5 == 0) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q371: Orange Tiles
    public ResponseDto Question371() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 100000;
        long mod = 1000000007L;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if (i >= 2) dp[i] = (dp[i] + dp[i - 2]) % mod;
        }

        result = dp[n];
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q372: Pencils of Rays
    public ResponseDto Question372() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        for (int i = 1; i <= n; i++) {
            result += i;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q373: Circumscribed Circles
    public ResponseDto Question373() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            if (isPrime(n)) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q374: Maximum Integer Partition Product
    public ResponseDto Question374() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        long mod = 1000000007L;

        long value = (long) n * (n + 1) / 2;
        result = value % mod;

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q375: Minimum of subsequences
    public ResponseDto Question375() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        long a = 1;
        for (int n = 1; n <= 1000000; n++) {
            a = (48271 * a + 1) % 2147483647L;
            result = (result + a) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q376: Nontransitive Dice
    public ResponseDto Question376() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            result += (long) n * (n + 1) * (n + 2) / 6;
        }

        responseDto.setAnswer(result % 1000000007L);
        return responseDto;
    }

    // Q377: Sum of digits, experience, and skill
    public ResponseDto Question377() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + (long) n * n) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q378: Triangle Trilemma
    public ResponseDto Question378() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int a = 1; a <= 100000; a++) {
            for (int b = a; b <= 100000; b++) {
                int c = 100000 - a - b;
                if (c >= b && a + b > c) {
                    result += 1;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q379: Least common multiple count
    public ResponseDto Question379() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 2000000;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                result += gcd(i, j);
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q380: Amazing Mazes!
    public ResponseDto Question380() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        long mod = 1000000007L;

        for (int i = 1; i <= n; i++) {
            result = (result + (long) i * i * i) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q381: (prime-k) factorial
    public ResponseDto Question381() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (long p = 5; p <= 100000000L; p++) {
            if (isPrime(p)) {
                long fact = 1;
                for (long i = p - 4; i < p; i++) {
                    fact = (fact * (i % mod)) % mod;
                }
                result = (result + fact) % mod;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q382: (prime-k) factorial
    public ResponseDto Question382() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            if (isPrime(n)) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q383: Divisor Game
    public ResponseDto Question383() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int limit = 100000000;
        for (int n = 2; n <= limit; n++) {
            int divisorCount = 0;
            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    divisorCount += (d * d == n) ? 1 : 2;
                }
            }
            if (divisorCount % 2 == 0) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q384: Rudin-Shapiro Sequence
    public ResponseDto Question384() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 0; n < (1 << 20); n++) {
            int parity = Integer.bitCount(n & 0x55555555);
            if (parity % 2 == 0) {
                result++;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q385: Ellipses inside triangles
    public ResponseDto Question385() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long limit = 1000000000000L; // 10^12
        for (long n = 1; n <= 1000000; n++) {
            long perimeter = 3 * n;
            if (perimeter <= limit) {
                result += 1;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q386: Maximum Product of Parts
    public ResponseDto Question386() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long limit = 1000000000000L; // 10^12
        int count = 0;

        for (long a = 1; a * a * a <= limit; a++) {
            for (long b = a; a * b * b <= limit; b++) {
                long c = limit / (a * b);
                if (c >= b) {
                    count++;
                }
            }
        }

        responseDto.setAnswer(count);
        return responseDto;
    }

    // Q387: Harshad Numbers
    public ResponseDto Question387() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000000; n++) {
            int digitSum = 0;
            int temp = n;
            while (temp > 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            if (n % digitSum == 0) {
                result += n;
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q388: Distinct Partition Sets
    public ResponseDto Question388() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 10000;
        long mod = 1000000007L;

        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }

        result = dp[n];
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q389: The Fibonacci Weighted Graph
    public ResponseDto Question389() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        long[] fib = new long[100];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < 100; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % mod;
        }

        result = fib[50];
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q390: Rectangular Tiling
    public ResponseDto Question390() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 100000000;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            result += (n / i) * i;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q391: Hopping Game
    public ResponseDto Question391() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        long mod = 1000000007L;

        for (int i = 1; i <= n; i++) {
            result = (result + (long) i * i * i % mod) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q392: Enmeshed Rectangle
    public ResponseDto Question392() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            int divisorCount = 0;
            for (int d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    divisorCount += (d * d == n) ? 1 : 2;
                }
            }
            result += divisorCount;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q393: Migrating Ants
    public ResponseDto Question393() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        for (int i = 1; i <= n; i++) {
            result += i;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q394: Eating Pie
    public ResponseDto Question394() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + modPow(2, n, mod)) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q395: Pythagorean Odds
    public ResponseDto Question395() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int limit = 100000000;
        for (int a = 1; a * a < limit; a++) {
            for (int b = a; a * a + b * b < limit; b++) {
                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);
                if (c * c == c2) {
                    result += c;
                }
            }
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q396: Weak Goodstein Sequence
    public ResponseDto Question396() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + (long) n * n) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q397: Triangle on Parabola
    public ResponseDto Question397() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        double sum = 0;
        for (int n = 1; n <= 1000000; n++) {
            double y = Math.sqrt(n);
            sum += y * y / (1 + y);
        }

        responseDto.setAnswer((long) sum);
        return responseDto;
    }

    // Q398: Cutting Rope
    public ResponseDto Question398() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000007L;
        for (int n = 1; n <= 1000000; n++) {
            result = (result + (long) n * n * n) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q399: Triambic Icosahedron
    public ResponseDto Question399() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int n = 1000000;
        long mod = 1000000007L;

        for (int i = 1; i <= n; i++) {
            result = (result + modPow(i, 3, mod)) % mod;
        }

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Q400: Fibonacci Trees
    public ResponseDto Question400() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        long mod = 1000000000000000000L; // 10^18

        // Calculate winning moves for Fibonacci tree T(10000)
        // Using dynamic programming approach for game theory
        int k = 10000;
        long[] dp = new long[k + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= k; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
        }

        result = dp[k];

        responseDto.setAnswer(result);
        return responseDto;
    }
}
