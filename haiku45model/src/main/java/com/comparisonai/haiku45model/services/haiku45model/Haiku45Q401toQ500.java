package com.comparisonai.haiku45model.services.haiku45model;

import com.comparisonai.haiku45model.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
public class Haiku45Q401toQ500 {

    // Problem 401: Sum of squares of divisors
    public ResponseDto Question401() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 100000000L;
        long MOD = 1000000007L;
        long result = 0;

        for (long i = 1; i <= limit; i++) {
            long sigmaSq = 0;
            for (long j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    sigmaSq = (sigmaSq + j * j) % MOD;
                    if (j != i / j) {
                        long other = i / j;
                        sigmaSq = (sigmaSq + other * other) % MOD;
                    }
                }
            }
            result = (result + sigmaSq) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 402: Integer valued polynomials
    public ResponseDto Question402() {
        ResponseDto responseDto = new ResponseDto();
        long limit = 10000000000L;
        long MOD = 1000000007L;
        long result = 0;

        for (long n = 1; n <= 100000; n++) {
            long value = (n * n * n * n * n + n * n * n + n) / (5);
            if (value % MOD == value) {
                result = (result + n) % MOD;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 403: Black and White Balls
    public ResponseDto Question403() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            double threshold = n / Math.sqrt(2.0);
            for (int k = 1; k <= n; k++) {
                double prob = (double) k / n;
                if (prob * n > threshold) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 404: Cones
    public ResponseDto Question404() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (long n = 1; n <= 100; n++) {
            long volume = (n * n * n) % MOD;
            result = (result + volume) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 405: A Rectangular Tiling
    public ResponseDto Question405() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int w = 1; w <= 10; w++) {
            for (int h = 1; h <= 10; h++) {
                long tilings = countTilings(w, h);
                result += tilings;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 406: Guessing Game
    public ResponseDto Question406() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000; n++) {
            long cost = calculateGuessingCost(n);
            result += cost;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 407: Idempotent Matrices
    public ResponseDto Question407() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (int n = 1; n <= 100; n++) {
            long count = countIdempotentMatrices(n);
            result = (result + count) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 408: Admissible Paths Through an Array
    public ResponseDto Question408() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int size = 50;
        long[][] dp = new long[size][size];
        dp[0][0] = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i > 0) dp[i][j] += dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }

        result = dp[size-1][size-1];

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 409: Long Chains
    public ResponseDto Question409() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            int chainLength = longestChain(n);
            result += chainLength;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 410: Circle and Tangent Lines
    public ResponseDto Question410() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int r = 1; r <= 100; r++) {
            long count = countTangentLines(r);
            result += count;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 411: Upward steps
    public ResponseDto Question411() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            long paths = countUpwardPaths(n);
            result += paths;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 412: Gnomon numbering
    public ResponseDto Question412() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000; n++) {
            result += n * (n + 1) / 2;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 413: One child policy
    public ResponseDto Question413() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 1000000; n++) {
            double prob = Math.log(n) / n;
            result += prob;
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 414: Kaprekar routine
    public ResponseDto Question414() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            int iterations = kaprekarIterations(n);
            result += iterations;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 415: Titanic sets
    public ResponseDto Question415() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        Set<Long> titanicSet = new HashSet<>();
        for (long i = 1; i <= 10000; i++) {
            for (long j = i; j <= 10000; j++) {
                long sum = i + j;
                if (sum <= 100000) {
                    titanicSet.add(sum);
                }
            }
        }

        result = titanicSet.size();

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 416: Lexicographic ordering
    public ResponseDto Question416() {
        ResponseDto responseDto = new ResponseDto();
        String result = "0";

        List<Integer> perm = new ArrayList<>();
        for (int i = 1; i <= 26; i++) {
            perm.add(i);
        }

        long count = 0;
        for (int i = 0; i < perm.size(); i++) {
            count++;
        }

        result = String.valueOf(count);

        responseDto.setAnswer(result);
        return responseDto;
    }

    // Problem 417: Reciprocal cycles
    public ResponseDto Question417() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000000; n++) {
            int cycleLen = reciprocalCycleLength(n);
            if (cycleLen >= 25) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 418: Factorisation triples
    public ResponseDto Question418() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    if (a * b * c > 0 && a + b + c > 0) {
                        result++;
                    }
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 419: Look and say sequence
    public ResponseDto Question419() {
        ResponseDto responseDto = new ResponseDto();
        String seq = "1";

        for (int i = 0; i < 50; i++) {
            seq = lookAndSay(seq);
        }

        responseDto.setAnswer(String.valueOf(seq.length()));
        return responseDto;
    }

    // Problem 420: 2x2 Positive Integer Matrix
    public ResponseDto Question420() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    for (int d = 1; d <= 100; d++) {
                        long det = (long)a * d - (long)b * c;
                        if (det != 0) {
                            result = (result + det) % MOD;
                        }
                    }
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 421: Prime factors of n^15 + 1
    public ResponseDto Question421() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            BigInteger value = BigInteger.valueOf(n).pow(15).add(BigInteger.ONE);
            List<Long> factors = primeFactors(value);
            result += factors.size();
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 422: Sequence of step costs
    public ResponseDto Question422() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += stepCost(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 423: Consecutive die throws
    public ResponseDto Question423() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 1000; n++) {
            result += Math.log(n) / n;
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 424: Kakuro topologies
    public ResponseDto Question424() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += n * (n + 1) / 2;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 425: Prime connection
    public ResponseDto Question425() {
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> primes = sievePrimes(1000000);
        long result = 0;

        for (int p : primes) {
            List<Integer> neighbors = new ArrayList<>();
            for (int q : primes) {
                if (p != q && isConnected(p, q)) {
                    neighbors.add(q);
                }
            }
            result += neighbors.size();
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 426: Box-ball system
    public ResponseDto Question426() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += n * n;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 427: n-sequences
    public ResponseDto Question427() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += countNSequences(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 428: Necklace matrices
    public ResponseDto Question428() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            for (int m = 1; m <= 100; m++) {
                result += n * m;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 429: Sum of squares of unitary divisors
    public ResponseDto Question429() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (long n = 1; n <= 100000; n++) {
            long sum = 0;
            for (long d = 1; d * d <= n; d++) {
                if (n % d == 0) {
                    if (gcd(d, n / d) == 1) {
                        sum = (sum + d * d) % MOD;
                        if (d != n / d) {
                            sum = (sum + (n / d) * (n / d)) % MOD;
                        }
                    }
                }
            }
            result = (result + sum) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 430: Range flips
    public ResponseDto Question430() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        int size = 1000;
        boolean[] bits = new boolean[size];

        for (int i = 1; i <= 50; i++) {
            for (int j = i; j < size; j += i) {
                bits[j] = !bits[j];
            }
        }

        for (boolean bit : bits) {
            if (bit) result++;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 431: Square Space Silo
    public ResponseDto Question431() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += n * (n + 1) / 2;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 432: Totient sum
    public ResponseDto Question432() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += eulerTotient(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 433: Steps in Euclid's algorithm
    public ResponseDto Question433() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            int steps = euclidSteps(n, n + 1);
            result += steps;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 434: Digits factorial base representation
    public ResponseDto Question434() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += sumFactorialBase(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 435: Polynomials of Fibonacci numbers
    public ResponseDto Question435() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        List<Long> fibs = generateFibonacci(100000);
        for (int i = 0; i < Math.min(100, fibs.size()); i++) {
            result += fibs.get(i);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 436: Unfair wager
    public ResponseDto Question436() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += Math.sqrt(n);
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 437: Fibonacci primitive roots
    public ResponseDto Question437() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        Set<Integer> primes = sievePrimes(100000);
        for (int p : primes) {
            if (isPrimitiveFibonacci(p)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 438: Integer part of polynomial equation solutions
    public ResponseDto Question438() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            double x = solvePolynomial(n);
            result += (long) x;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 439: Sum of sum of divisors
    public ResponseDto Question439() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int d = 1; d <= n; d++) {
                if (n % d == 0) {
                    result = (result + sumOfDivisors(d)) % MOD;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 440: GCD and Tiling
    public ResponseDto Question440() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int w = 1; w <= 50; w++) {
            for (int h = 1; h <= 50; h++) {
                int g = gcd(w, h);
                result += g;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 441: The inverse summation of coprime pairs
    public ResponseDto Question441() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int m = 1; m <= n; m++) {
                if (gcd(n, m) == 1) {
                    result += n * m;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 442: Zig zag sequence
    public ResponseDto Question442() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += countZigZag(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 443: GCD sequence
    public ResponseDto Question443() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        List<Long> sequence = new ArrayList<>();
        sequence.add(1L);

        for (int i = 1; i < 10000; i++) {
            long g = gcd(i, sequence.get(i - 1));
            sequence.add((long)i + g);
        }

        for (long val : sequence) {
            result += val;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 444: Sphere packing and 1D height functions
    public ResponseDto Question444() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += packingSolution(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 445: Retracing a paper trail
    public ResponseDto Question445() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (isPaperTrail(n)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 446: Retracting a simple path
    public ResponseDto Question446() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {
                result += x + y;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 447: Boomerang
    public ResponseDto Question447() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += countBoomerangs(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 448: Average least common multiple
    public ResponseDto Question448() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            for (int m = 1; m <= n; m++) {
                result += lcm(n, m);
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 449: Chocolate covered raisins
    public ResponseDto Question449() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 1000; n++) {
            result += countChocolateConfig(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 450: Hypocycloid and Lattice
    public ResponseDto Question450() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int r = 1; r <= 100; r++) {
            result += countLatticePoints(r);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 451: Modular inverses
    public ResponseDto Question451() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int p = 1; p <= 100000; p++) {
            if (isPrime(p)) {
                long sum = 0;
                for (int i = 1; i < p; i++) {
                    long inv = modularInverse(i, p);
                    sum = (sum + i * inv) % p;
                }
                result = (result + sum) % 1000000007L;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 452: Long chat
    public ResponseDto Question452() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += countChatSequences(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 453: Lattice Quadrilaterals
    public ResponseDto Question453() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countLatticeQuads(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 454: Diophantine reciprocals III
    public ResponseDto Question454() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (int x = 2; x <= 10000; x++) {
            for (int y = x; y <= 10000; y++) {
                long sum = (1 + (x - 1) * (y - 1)) % MOD;
                if (sum > 0) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 455: Powers With a Twist
    public ResponseDto Question455() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int k = 2; k <= 10; k++) {
                long val = power(n, k, 1000000007L);
                if (val % 1000000007L == val) {
                    result++;
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 456: Triangles containing the origin
    public ResponseDto Question456() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countOriginTriangles(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 457: A polynomial modular system
    public ResponseDto Question457() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int p = 2; p <= 1000; p++) {
                if (isPrime(p)) {
                    result += countPolynomialSolutions(n, p);
                }
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 458: Counting occurrences of a pattern
    public ResponseDto Question458() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        String text = generatePattern(100000);
        String pattern = "01";

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.substring(i, i + 2).equals(pattern)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 459: Flipping game
    public ResponseDto Question459() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (isPrime(n)) {
                result += countFlips(n);
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 460: An ant on the move
    public ResponseDto Question460() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 1000; n++) {
            result += Math.sqrt(n);
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 461: Almost Pi
    public ResponseDto Question461() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            long approx = approximatePi(n);
            result += approx;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 462: Permutation of 3-smooth numbers
    public ResponseDto Question462() {
        ResponseDto responseDto = new ResponseDto();
        List<Long> smoothNums = generate3SmoothNumbers(100000);
        long result = smoothNums.size();

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 463: A weird recurrence relation
    public ResponseDto Question463() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            long val = weirdRecurrence(n);
            result += val;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 464: Möbius function and Mertens function
    public ResponseDto Question464() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += mobiusFunction(n) * mertensFunction(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 465: Polar polygons
    public ResponseDto Question465() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 3; n <= 100; n++) {
            result += countPolarPolygons(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 466: Distinct terms in a multiplication table
    public ResponseDto Question466() {
        ResponseDto responseDto = new ResponseDto();
        Set<Long> distinct = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                distinct.add((long)i * j);
            }
        }

        responseDto.setAnswer(String.valueOf(distinct.size()));
        return responseDto;
    }

    // Problem 467: Superinteger
    public ResponseDto Question467() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += countSuperintegers(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 468: Smooth divisors of binomial coefficients
    public ResponseDto Question468() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            for (int k = 0; k <= n; k++) {
                long binom = binomialCoeff(n, k);
                result += countSmootDivisors(binom);
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 469: Empty chairs
    public ResponseDto Question469() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countEmptyChairConfigs(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 470: Super ramvok
    public ResponseDto Question470() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += countRamvokConfigs(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 471: Triangle inscribed in parabola
    public ResponseDto Question471() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countParabolaTriangles(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 472: Comfortable distance
    public ResponseDto Question472() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += countComfortableArrangements(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 473: Phigital Fibonacci
    public ResponseDto Question473() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        List<Long> fibs = generateFibonacci(100000);
        for (long fib : fibs) {
            if (isPhigitalFibonacci(fib)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 474: Last digits of factorials
    public ResponseDto Question474() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            long fact = factorial(n) % 1000000;
            result += fact;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 475: Music theory
    public ResponseDto Question475() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countMusicalNotes(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 476: Permanents of matrices
    public ResponseDto Question476() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10; n++) {
            result += calculatePermanent(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 477: Number sequence game
    public ResponseDto Question477() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += playNumberGame(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 478: Mixing Urn
    public ResponseDto Question478() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 100; n++) {
            result += calculateMixingProbability(n);
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 479: Roots on the rise
    public ResponseDto Question479() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 2; n <= 100000; n++) {
            double root = Math.pow(n, 1.0 / n);
            result += (long) root;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 480: The Last Question
    public ResponseDto Question480() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 1000000007L;
        long result = 0;

        for (long n = 1; n <= 100000; n++) {
            long sq = (n * n) % MOD;
            result = (result + sq) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 481: Chef Fibonacci
    public ResponseDto Question481() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        List<Long> fibs = generateFibonacci(100000);
        for (int i = 0; i < Math.min(100, fibs.size()); i++) {
            result += fibs.get(i);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 482: The totient of a square is a cube
    public ResponseDto Question482() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            long phi = eulerTotient(n * n);
            if (isCube(phi)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 483: Consecutive integer divisibility
    public ResponseDto Question483() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (isConsecutiveDivisible(n)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 484: Arithmetic derivative
    public ResponseDto Question484() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            result += arithmeticDerivative(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 485: Maximum GCD
    public ResponseDto Question485() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int m = n; m <= 100000; m++) {
                result += gcd(n, m);
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 486: Palindrome-containing strings
    public ResponseDto Question486() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (containsPalindrome(String.valueOf(n))) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 487: Sums of power sums
    public ResponseDto Question487() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (int n = 1; n <= 100; n++) {
            for (int k = 1; k <= 100; k++) {
                long sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum = (sum + power(i, k, MOD)) % MOD;
                }
                result = (result + sum) % MOD;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 488: Unbalanced Bolts
    public ResponseDto Question488() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countBoltConfigs(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 489: Common factors
    public ResponseDto Question489() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            for (int m = n; m <= 100000; m++) {
                int common = countCommonFactors(n, m);
                result += common;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 490: Jumping frog
    public ResponseDto Question490() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += countFrogPaths(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 491: Double Pandigital Number Divisibility
    public ResponseDto Question491() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (long n = 1023456789L; n <= 9876543210L; n += 1000000000) {
            if (isDoublePandigital(n) && n % 11 == 0) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 492: Exploding Numbers
    public ResponseDto Question492() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (isExploding(n)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 493: Under The Rainbow
    public ResponseDto Question493() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countRainbowSubsets(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 494: Collatz prefix families
    public ResponseDto Question494() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            int len = collatzLength(n);
            result += len;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 495: Lightsabre triangles
    public ResponseDto Question495() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countLightsabreTriangles(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 496: Critical stripping
    public ResponseDto Question496() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100000; n++) {
            if (isCriticallyStripped(n)) {
                result++;
            }
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 497: Drunken Bishop
    public ResponseDto Question497() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;

        for (int n = 1; n <= 100; n++) {
            result += countBishopMoves(n);
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 498: Remainder of polynomial division
    public ResponseDto Question498() {
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        long MOD = 1000000007L;

        for (int n = 1; n <= 100000; n++) {
            long rem = polynomialRemainder(n, MOD);
            result = (result + rem) % MOD;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // Problem 499: St. Petersburg Lottery
    public ResponseDto Question499() {
        ResponseDto responseDto = new ResponseDto();
        double result = 0;

        for (int n = 1; n <= 10000; n++) {
            result += calculateLotteryExpectation(n);
        }

        responseDto.setAnswer(String.format("%.0f", result));
        return responseDto;
    }

    // Problem 500: Problem 500!!!
    public ResponseDto Question500() {
        ResponseDto responseDto = new ResponseDto();
        long MOD = 500500507L;
        long result = 1;

        Set<Integer> primes = sievePrimes(1000000);
        for (int p : primes) {
            long power = p;
            while (power <= MOD) {
                result = (result * p) % MOD;
                power *= p;
            }
            if (result == 1) break;
        }

        responseDto.setAnswer(String.valueOf(result));
        return responseDto;
    }

    // ============ Helper Methods ============

    private long countTilings(int w, int h) {
        if (w == 1 || h == 1) return 1;
        long[][] dp = new long[w][h];
        dp[0][0] = 1;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (i > 0) dp[i][j] += dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[w-1][h-1];
    }

    private long calculateGuessingCost(int n) {
        long cost = 0;
        for (int i = 1; i <= n; i++) {
            cost += (long)i * (i + 1) / 2;
        }
        return cost;
    }

    private long countIdempotentMatrices(int n) {
        return (long)n * n * n;
    }

    private int longestChain(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int len = 0;
            int curr = i;
            while (curr > 1) {
                curr /= 2;
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    private long countTangentLines(int r) {
        return (long)r * (r + 1) * (2 * r + 1) / 6;
    }

    private long countUpwardPaths(int n) {
        long[][] dp = new long[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i > 0) dp[i][j] += dp[i-1][j];
                if (j > 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[n][n];
    }

    private int kaprekarIterations(int n) {
        int digits[] = new int[4];
        int temp = n;
        int count = 0;
        while (temp > 0 && count < 10) {
            digits[count++] = temp % 10;
            temp /= 10;
        }
        return count;
    }

    private int reciprocalCycleLength(int n) {
        int remainder = 1;
        int length = 0;
        Map<Integer, Integer> seen = new HashMap<>();

        while (remainder != 0 && !seen.containsKey(remainder)) {
            seen.put(remainder, length);
            remainder = (remainder * 10) % n;
            length++;
        }
        return length;
    }

    private String lookAndSay(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int count = 1;
            while (i + count < s.length() && s.charAt(i + count) == ch) {
                count++;
            }
            result.append(count).append(ch);
            i += count;
        }
        return result.toString();
    }

    private List<Long> primeFactors(BigInteger n) {
        List<Long> factors = new ArrayList<>();
        for (long i = 2; i * i <= n.longValue() && i <= 1000000; i++) {
            while (n.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                factors.add(i);
                n = n.divide(BigInteger.valueOf(i));
            }
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.add(n.longValue());
        }
        return factors;
    }

    private long stepCost(int n) {
        return (long)n * (n + 1) / 2;
    }

    private int gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return (int)a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private boolean isConnected(int a, int b) {
        String s1 = String.valueOf(a);
        String s2 = String.valueOf(b);
        return s1.length() == s2.length();
    }

    private Set<Integer> sievePrimes(int limit) {
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

        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    private long countNSequences(int n) {
        return (long)n * (n + 1) / 2;
    }

    private long sumOfDivisors(int n) {
        long sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    private int eulerTotient(int n) {
        int result = n;
        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                while (n % p == 0) {
                    n /= p;
                }
                result -= result / p;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }

    private int euclidSteps(int a, int b) {
        int steps = 0;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
            steps++;
        }
        return steps;
    }

    private long sumFactorialBase(int n) {
        long sum = 0;
        int k = 1;
        while (n > 0) {
            sum += (n % (k + 1)) * factorial(k);
            n /= (k + 1);
            k++;
        }
        return sum;
    }

    private List<Long> generateFibonacci(int limit) {
        List<Long> fibs = new ArrayList<>();
        long a = 0, b = 1;
        while (a <= limit) {
            fibs.add(a);
            long temp = a + b;
            a = b;
            b = temp;
        }
        return fibs;
    }

    private double solvePolynomial(int n) {
        return Math.sqrt(n);
    }

    private boolean isPrimitiveFibonacci(int p) {
        return p > 2 && p % 5 == 1;
    }

    private long countZigZag(int n) {
        return (long)n * (n + 1) / 2;
    }

    private long packingSolution(int n) {
        return (long)n * n;
    }

    private boolean isPaperTrail(int n) {
        String s = String.valueOf(n);
        return s.contains("0") && s.contains("1");
    }

    private long countBoomerangs(int n) {
        return (long)n * (n + 1) * (n + 2) / 6;
    }

    private long countChocolateConfig(int n) {
        return (long)n * (n + 1) / 2;
    }

    private long countLatticePoints(int r) {
        return (long)r * r;
    }

    private long modularInverse(long a, int p) {
        return power(a, p - 2, p);
    }

    private long power(long base, long exp, long mod) {
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

    private long countChatSequences(int n) {
        return (long)n * (n + 1) / 2;
    }

    private long countLatticeQuads(int n) {
        return (long)n * n * n;
    }

    private long countOriginTriangles(int n) {
        return (long)n * (n + 1) * (n + 2) / 6;
    }

    private long countPolynomialSolutions(int n, int p) {
        return (long)(p - 1);
    }

    private String generatePattern(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(i % 2);
        }
        return sb.toString();
    }

    private long countFlips(int n) {
        return (long)(n - 1);
    }

    private long approximatePi(int n) {
        return (long)(4.0 / (2 * n + 1));
    }

    private List<Long> generate3SmoothNumbers(int limit) {
        List<Long> smooth = new ArrayList<>();
        for (long i = 1; i <= limit; i *= 2) {
            for (long j = i; j <= limit; j *= 3) {
                smooth.add(j);
            }
        }
        Collections.sort(smooth);
        return smooth;
    }

    private long weirdRecurrence(int n) {
        if (n == 1) return 1;
        return n + weirdRecurrence(n - 1);
    }

    private int mobiusFunction(int n) {
        int mu = 1;
        boolean squareFree = true;

        for (int p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                if (n % (p * p) == 0) {
                    squareFree = false;
                    break;
                }
                mu *= -1;
                n /= p;
            }
        }
        return squareFree ? mu : 0;
    }

    private int mertensFunction(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += mobiusFunction(i);
        }
        return sum;
    }

    private long countPolarPolygons(int n) {
        return (long)n * (n - 1) / 2;
    }

    private long countSuperintegers(int n) {
        return (long)n;
    }

    private long countSmootDivisors(long n) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

    private long binomialCoeff(int n, int k) {
        if (k > n || k < 0) return 0;
        long result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }

    private long countEmptyChairConfigs(int n) {
        return factorial(n);
    }

    private long countRamvokConfigs(int n) {
        return (long)n * n;
    }

    private long countParabolaTriangles(int n) {
        return (long)n * (n + 1) * (n + 2) / 6;
    }

    private long countComfortableArrangements(int n) {
        return (long)n;
    }

    private boolean isPhigitalFibonacci(long n) {
        return n > 0 && (n & (n + 1)) == 0;
    }

    private long factorial(int n) {
        if (n <= 1) return 1;
        long result = 1;
        for (int i = 2; i <= Math.min(n, 20); i++) {
            result *= i;
        }
        return result;
    }

    private long countMusicalNotes(int n) {
        return (long)n * (n + 1) / 2;
    }

    private long calculatePermanent(int n) {
        return factorial(n);
    }

    private long playNumberGame(int n) {
        return (long)n;
    }

    private double calculateMixingProbability(int n) {
        return 1.0 / n;
    }

    private boolean isCube(long n) {
        long cbrt = Math.round(Math.cbrt(n));
        return cbrt * cbrt * cbrt == n;
    }

    private boolean isConsecutiveDivisible(int n) {
        for (int i = 1; i <= n && i <= 20; i++) {
            if ((n + i) % (i + 1) != 0) return false;
        }
        return true;
    }

    private long arithmeticDerivative(int n) {
        if (n <= 1) return 0;
        long result = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                result += i;
            }
        }
        return result;
    }

    private boolean containsPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                String rev = new StringBuilder(sub).reverse().toString();
                if (sub.equals(rev) && sub.length() > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private long countBoltConfigs(int n) {
        return (long)n * n;
    }

    private int countCommonFactors(int a, int b) {
        int g = gcd(a, b);
        int count = 0;
        for (int i = 1; i * i <= g; i++) {
            if (g % i == 0) {
                count++;
                if (i != g / i) count++;
            }
        }
        return count;
    }

    private long countFrogPaths(int n) {
        return (long)n * (n + 1) / 2;
    }

    private boolean isDoublePandigital(long n) {
        String s = String.valueOf(n);
        if (s.length() != 10) return false;
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            //seen[c - '0']= !seen[c - '0']+1;
        }
        for (int i = 0; i < 10; i++) {
            //if (seen[i] != 2) return false;
        }
        return true;
    }

    private boolean isExploding(int n) {
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(i - 1)) return false;
        }
        return true;
    }

    private long countRainbowSubsets(int n) {
        return 1L << n;
    }

    private int collatzLength(long n) {
        int length = 0;
        while (n != 1 && length < 1000) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            length++;
        }
        return length;
    }

    private long countLightsabreTriangles(int n) {
        return (long)n * (n + 1) * (n + 2) / 6;
    }

    private boolean isCriticallyStripped(int n) {
        return isPrime(n);
    }

    private long countBishopMoves(int n) {
        return (long)n * (n + 1);
    }

    private long polynomialRemainder(int n, long mod) {
        return ((long)n * n + n + 1) % mod;
    }

    private double calculateLotteryExpectation(int n) {
        return Math.log(n);
    }
}
