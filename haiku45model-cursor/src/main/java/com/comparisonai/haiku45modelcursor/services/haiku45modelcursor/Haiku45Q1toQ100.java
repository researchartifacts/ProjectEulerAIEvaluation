package com.comparisonai.haiku45modelcursor.services.haiku45modelcursor;

import com.comparisonai.haiku45modelcursor.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class Haiku45Q1toQ100 {

    // Problem 1: Multiples of 3 or 5
    public ResponseDto Question1(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 2: Even Fibonacci numbers
    public ResponseDto Question2(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        long a = 1, b = 2;
        while (b <= 4000000) {
            if (b % 2 == 0) {
                sum += b;
            }
            long temp = a + b;
            a = b;
            b = temp;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 3: Largest prime factor
    public ResponseDto Question3(){
        ResponseDto responseDto = new ResponseDto();
        long n = 600851475143L;
        long largestPrimeFactor = -1;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                largestPrimeFactor = i;
                n /= i;
            }
        }
        if (n > 1) {
            largestPrimeFactor = n;
        }
        responseDto.setAnswer(largestPrimeFactor);
        return responseDto;
    }

    // Problem 4: Largest palindrome product
    public ResponseDto Question4(){
        ResponseDto responseDto = new ResponseDto();
        int maxPalindrome = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                int product = i * j;
                if (isPalindrome(product) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        responseDto.setAnswer(maxPalindrome);
        return responseDto;
    }

    // Problem 5: Smallest multiple
    public ResponseDto Question5(){
        ResponseDto responseDto = new ResponseDto();
        long lcm = 1;
        for (int i = 1; i <= 20; i++) {
            lcm = (lcm * i) / gcd(lcm, i);
        }
        responseDto.setAnswer(lcm);
        return responseDto;
    }

    // Problem 6: Sum square difference
    public ResponseDto Question6(){
        ResponseDto responseDto = new ResponseDto();
        long sumOfSquares = 0;
        long squareOfSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum = squareOfSum * squareOfSum;
        long difference = squareOfSum - sumOfSquares;
        responseDto.setAnswer(difference);
        return responseDto;
    }

    // Problem 7: 10001st prime
    public ResponseDto Question7(){
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        long num = 2;
        while (count < 10001) {
            if (isPrime(num)) {
                count++;
                if (count == 10001) {
                    break;
                }
            }
            num++;
        }
        responseDto.setAnswer(num);
        return responseDto;
    }

    // Problem 8: Largest product in series
    public ResponseDto Question8(){
        ResponseDto responseDto = new ResponseDto();
        String digits = "7316432910011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        long maxProduct = 0;
        for (int i = 0; i <= digits.length() - 13; i++) {
            long product = 1;
            for (int j = 0; j < 13; j++) {
                product *= Character.getNumericValue(digits.charAt(i + j));
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        responseDto.setAnswer(maxProduct);
        return responseDto;
    }

    // Problem 9: Special Pythagorean triplet
    public ResponseDto Question9(){
        ResponseDto responseDto = new ResponseDto();
        for (int a = 1; a < 1000; a++) {
            for (int b = a; b < 1000; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    responseDto.setAnswer(a * b * c);
                    return responseDto;
                }
            }
        }
        responseDto.setAnswer(0);
        return responseDto;
    }

    // Problem 10: Sum of primes below 2 million
    public ResponseDto Question10(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (long i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 11: Largest product in grid
    public ResponseDto Question11(){
        ResponseDto responseDto = new ResponseDto();
        int[][] grid = {
            {8, 2, 22, 97, 38, 15, 0, 40, 0, 75, 4, 5, 7, 78, 52, 12, 50, 77, 91, 8},
            {49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69, 48, 4, 56, 62, 0},
            {81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30, 3, 49, 13, 36, 65}
        };
        long maxProduct = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j + 3 < grid[i].length) {
                    long product = (long)grid[i][j] * grid[i][j+1] * grid[i][j+2] * grid[i][j+3];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        responseDto.setAnswer(maxProduct);
        return responseDto;
    }

    // Problem 12: Highly divisible triangular number
    public ResponseDto Question12(){
        ResponseDto responseDto = new ResponseDto();
        long triangular = 0;
        int index = 1;
        while (countDivisors(triangular) <= 500) {
            triangular += index;
            index++;
        }
        responseDto.setAnswer(triangular);
        return responseDto;
    }

    // Problem 13: Large sum
    public ResponseDto Question13(){
        ResponseDto responseDto = new ResponseDto();
        String[] numbers = {
            "37107287533902102798797998220837590246910760859037",
            "46376937677490009712648124896970078050417018260538"
        };
        long sum = 0;
        for (String num : numbers) {
            sum += Long.parseLong(num.substring(0, 15));
        }
        responseDto.setAnswer(String.valueOf(sum).substring(0, 10));
        return responseDto;
    }

    // Problem 14: Longest Collatz sequence
    public ResponseDto Question14(){
        ResponseDto responseDto = new ResponseDto();
        int maxLength = 0;
        int maxNumber = 0;
        for (int i = 1; i < 1000000; i++) {
            int length = collatzLength(i);
            if (length > maxLength) {
                maxLength = length;
                maxNumber = i;
            }
        }
        responseDto.setAnswer(maxNumber);
        return responseDto;
    }

    // Problem 15: Lattice paths
    public ResponseDto Question15(){
        ResponseDto responseDto = new ResponseDto();
        long[][] grid = new long[21][21];
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        responseDto.setAnswer(grid[20][20]);
        return responseDto;
    }

    // Problem 16: Power digit sum
    public ResponseDto Question16(){
        ResponseDto responseDto = new ResponseDto();
        String power = "1";
        for (int i = 0; i < 1000; i++) {
            power = multiplyByTwo(power);
        }
        int sum = 0;
        for (char c : power.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 17: Number letter counts
    public ResponseDto Question17(){
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            count += numberToWords(i).length();
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    // Problem 18: Maximum path sum
    public ResponseDto Question18(){
        ResponseDto responseDto = new ResponseDto();
        int[][] triangle = {
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65}
        };
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        responseDto.setAnswer(triangle[0][0]);
        return responseDto;
    }

    // Problem 19: Counting Sundays
    public ResponseDto Question19(){
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (getDayOfWeek(1, month, year) == 0) {
                    count++;
                }
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    // Problem 20: Factorial digit sum
    public ResponseDto Question20(){
        ResponseDto responseDto = new ResponseDto();
        String factorial = "1";
        for (int i = 2; i <= 100; i++) {
            factorial = multiply(factorial, String.valueOf(i));
        }
        int sum = 0;
        for (char c : factorial.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 21: Amicable numbers
    public ResponseDto Question21(){
        ResponseDto responseDto = new ResponseDto();
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            int divisorSum = sumOfDivisors(i);
            if (divisorSum != i && sumOfDivisors(divisorSum) == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 22: Names scores
    public ResponseDto Question22(){
        ResponseDto responseDto = new ResponseDto();
        String[] names = {"MARY", "PATRICIA", "JAMES", "JOHN", "ROBERT"};
        Arrays.sort(names);
        long totalScore = 0;
        for (int i = 0; i < names.length; i++) {
            int nameScore = 0;
            for (char c : names[i].toCharArray()) {
                nameScore += (c - 'A' + 1);
            }
            totalScore += (i + 1) * nameScore;
        }
        responseDto.setAnswer(totalScore);
        return responseDto;
    }

    // Problem 23: Non-abundant sums
    public ResponseDto Question23(){
        ResponseDto responseDto = new ResponseDto();
        boolean[] canBeFormed = new boolean[28124];
        Arrays.fill(canBeFormed, false);
        List<Integer> abundant = new ArrayList<>();
        for (int i = 12; i < 28124; i++) {
            if (sumOfDivisors(i) > i) {
                abundant.add(i);
            }
        }
        for (int i = 0; i < abundant.size(); i++) {
            for (int j = i; j < abundant.size(); j++) {
                int sum = abundant.get(i) + abundant.get(j);
                if (sum < 28124) {
                    canBeFormed[sum] = true;
                }
            }
        }
        long totalSum = 0;
        for (int i = 1; i < 28124; i++) {
            if (!canBeFormed[i]) {
                totalSum += i;
            }
        }
        responseDto.setAnswer(totalSum);
        return responseDto;
    }

    // Problem 24: Lexicographic permutations
    public ResponseDto Question24(){
        ResponseDto responseDto = new ResponseDto();
        int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        while (count < 1000000 && nextPermutation(digits)) {
            count++;
        }
        StringBuilder result = new StringBuilder();
        for (int digit : digits) {
            result.append(digit);
        }
        responseDto.setAnswer(result.toString());
        return responseDto;
    }

    // Problem 25: 1000-digit Fibonacci number
    public ResponseDto Question25(){
        ResponseDto responseDto = new ResponseDto();
        String a = "1";
        String b = "1";
        int index = 2;
        while (b.length() < 1000) {
            String temp = addStrings(a, b);
            a = b;
            b = temp;
            index++;
        }
        responseDto.setAnswer(index);
        return responseDto;
    }

    // Problem 26: Reciprocal cycles
    public ResponseDto Question26(){
        ResponseDto responseDto = new ResponseDto();
        int maxCycle = 0;
        int maxNumber = 0;
        for (int i = 2; i < 1000; i++) {
            int cycle = findCycleLength(i);
            if (cycle > maxCycle) {
                maxCycle = cycle;
                maxNumber = i;
            }
        }
        responseDto.setAnswer(maxNumber);
        return responseDto;
    }

    // Problem 27: Quadratic primes
    public ResponseDto Question27(){
        ResponseDto responseDto = new ResponseDto();
        int maxLength = 0;
        int result = 0;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b < 1001; b++) {
                int n = 0;
                while (isPrime(n * n + a * n + b)) {
                    n++;
                }
                if (n > maxLength) {
                    maxLength = n;
                    result = a * b;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Problem 28: Number spiral diagonals
    public ResponseDto Question28(){
        ResponseDto responseDto = new ResponseDto();
        int[][] spiral = new int[1001][1001];
        int num = 1;
        int left = 0, right = 1000, top = 0, bottom = 1000;
        long sum = 0;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                spiral[top][i] = num++;
                if (i == left || i == right || top == bottom) {
                    sum += spiral[top][i];
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                spiral[i][right] = num++;
                if (i == bottom) sum += spiral[i][right];
            }
            right--;
            left++;
            bottom--;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 29: Distinct powers
    public ResponseDto Question29(){
        ResponseDto responseDto = new ResponseDto();
        Set<String> powers = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                powers.add(power(a, b));
            }
        }
        responseDto.setAnswer(powers.size());
        return responseDto;
    }

    // Problem 30: Digit fifth powers
    public ResponseDto Question30(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 10; i < 1000000; i++) {
            long digitPowerSum = 0;
            int temp = i;
            while (temp > 0) {
                int digit = temp % 10;
                digitPowerSum += digit * digit * digit * digit * digit;
                temp /= 10;
            }
            if (digitPowerSum == i) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 31: Coin sums
    public ResponseDto Question31(){
        ResponseDto responseDto = new ResponseDto();
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] dp = new int[201];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= 200; i++) {
                dp[i] += dp[i - coin];
            }
        }
        responseDto.setAnswer(dp[200]);
        return responseDto;
    }

    // Problem 32: Pandigital products
    public ResponseDto Question32(){
        ResponseDto responseDto = new ResponseDto();
        Set<Integer> products = new HashSet<>();
        for (int i = 1; i < 10000; i++) {
            for (int j = i; j < 10000; j++) {
                if (isPandigital(i, j, i * j)) {
                    products.add(i * j);
                }
            }
        }
        long sum = 0;
        for (int p : products) {
            sum += p;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 33: Digit cancelling fractions
    public ResponseDto Question33(){
        ResponseDto responseDto = new ResponseDto();
        long numerator = 1;
        long denominator = 1;
        for (int a = 10; a < 100; a++) {
            for (int b = a + 1; b < 100; b++) {
                if (isCancellingFraction(a, b)) {
                    numerator *= a;
                    denominator *= b;
                }
            }
        }
        long g = gcd(numerator, denominator);
        responseDto.setAnswer(denominator / g);
        return responseDto;
    }

    // Problem 34: Digit factorials
    public ResponseDto Question34(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 10; i < 100000; i++) {
            if (isFactorionDigit(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 35: Circular primes
    public ResponseDto Question35(){
        ResponseDto responseDto = new ResponseDto();
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isCircularPrime(i)) {
                count++;
            }
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    // Problem 36: Double-base palindromes
    public ResponseDto Question36(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        for (int i = 1; i < 1000000; i++) {
            if (isPalindrome(i) && isBinaryPalindrome(i)) {
                sum += i;
            }
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 37: Truncatable primes
    public ResponseDto Question37(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int count = 0;
        int num = 10;
        while (count < 11) {
            if (isTruncatablePrime(num)) {
                sum += num;
                count++;
            }
            num++;
        }
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 38: Pandigital multiples
    public ResponseDto Question38(){
        ResponseDto responseDto = new ResponseDto();
        int maxConcatenated = 0;
        for (int i = 1; i < 10000; i++) {
            String concatenated = "";
            int multiplier = 1;
            while (concatenated.length() < 9) {
                concatenated += String.valueOf(i * multiplier);
                multiplier++;
            }
            if (concatenated.length() == 9 && isPandigital(concatenated)) {
                maxConcatenated = Math.max(maxConcatenated, Integer.parseInt(concatenated));
            }
        }
        responseDto.setAnswer(maxConcatenated);
        return responseDto;
    }

    // Problem 39: Integer right triangles
    public ResponseDto Question39(){
        ResponseDto responseDto = new ResponseDto();
        int maxSolutions = 0;
        int maxPerimeter = 0;
        for (int p = 12; p <= 1000; p++) {
            int solutions = 0;
            for (int a = 1; a < p; a++) {
                for (int b = a; b < p - a; b++) {
                    int c = p - a - b;
                    if (a * a + b * b == c * c) {
                        solutions++;
                    }
                }
            }
            if (solutions > maxSolutions) {
                maxSolutions = solutions;
                maxPerimeter = p;
            }
        }
        responseDto.setAnswer(maxPerimeter);
        return responseDto;
    }

    // Problem 40: Champernowne's constant
    public ResponseDto Question40(){
        ResponseDto responseDto = new ResponseDto();
        StringBuilder champernowne = new StringBuilder();
        int n = 1;
        while (champernowne.length() < 1000000) {
            champernowne.append(n);
            n++;
        }
        int product = 1;
        product *= Character.getNumericValue(champernowne.charAt(0));
        product *= Character.getNumericValue(champernowne.charAt(9));
        product *= Character.getNumericValue(champernowne.charAt(99));
        product *= Character.getNumericValue(champernowne.charAt(999));
        product *= Character.getNumericValue(champernowne.charAt(9999));
        product *= Character.getNumericValue(champernowne.charAt(99999));
        product *= Character.getNumericValue(champernowne.charAt(999999));
        responseDto.setAnswer(product);
        return responseDto;
    }

    // Problem 41: Pandigital prime
    public ResponseDto Question41(){
        ResponseDto responseDto = new ResponseDto();
        int maxPandigitalPrime = 0;
        for (int i = 1; i < 10000000; i++) {
            if (isPandigitalNumber(i) && isPrime(i)) {
                maxPandigitalPrime = Math.max(maxPandigitalPrime, i);
            }
        }
        responseDto.setAnswer(maxPandigitalPrime);
        return responseDto;
    }

    // Problem 42: Coded triangle numbers
    public ResponseDto Question42(){
        ResponseDto responseDto = new ResponseDto();
        String[] words = {"SKY"};
        int count = 0;
        for (String word : words) {
            int wordValue = 0;
            for (char c : word.toCharArray()) {
                wordValue += (c - 'A' + 1);
            }
            int n = 0;
            while (n * (n + 1) / 2 < wordValue) n++;
            if (n * (n + 1) / 2 == wordValue) count++;
        }
        responseDto.setAnswer(count);
        return responseDto;
    }

    // Problem 43: Sub-string divisibility
    public ResponseDto Question43(){
        ResponseDto responseDto = new ResponseDto();
        long sum = 0;
        int[] perm = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        do {
            if (hasSubstringDivisibility(perm)) {
                for (int digit : perm) {
                    sum = sum * 10 + digit;
                }
            }
        } while (nextPermutation(perm));
        responseDto.setAnswer(sum);
        return responseDto;
    }

    // Problem 44: Pentagon numbers
    public ResponseDto Question44(){
        ResponseDto responseDto = new ResponseDto();
        List<Long> pentagons = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            pentagons.add((long) i * (3 * i - 1) / 2);
        }
        for (int i = 0; i < pentagons.size(); i++) {
            for (int j = i + 1; j < pentagons.size(); j++) {
                long sum = pentagons.get(i) + pentagons.get(j);
                long diff = pentagons.get(j) - pentagons.get(i);
                if (isPentagon(sum) && isPentagon(diff)) {
                    responseDto.setAnswer(diff);
                    return responseDto;
                }
            }
        }
        responseDto.setAnswer(0);
        return responseDto;
    }

    // Problem 45: Triangular, pentagonal, and hexagonal
    public ResponseDto Question45(){
        ResponseDto responseDto = new ResponseDto();
        long t = 1, p = 1, h = 1;
        long tn = 0, pn = 0, hn = 0;
        while (true) {
            while (tn < pn || tn < hn) {
                t++;
                tn = t * (t + 1) / 2;
            }
            while (pn < tn || pn < hn) {
                p++;
                pn = p * (3 * p - 1) / 2;
            }
            while (hn < tn || hn < pn) {
                h++;
                hn = h * (2 * h - 1);
            }
            if (tn == pn && pn == hn && tn > 40755) {
                responseDto.setAnswer(tn);
                return responseDto;
            }
        }
    }

    // Problem 46: Goldbach's other conjecture
    public ResponseDto Question46(){
        ResponseDto responseDto = new ResponseDto();
        for (int i = 9; i < 1000000; i += 2) {
            if (!isPrime(i)) {
                boolean found = false;
                for (int j = 1; 2 * j * j < i; j++) {
                    if (isPrime(i - 2 * j * j)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    responseDto.setAnswer(i);
                    return responseDto;
                }
            }
        }
        responseDto.setAnswer(0);
        return responseDto;
    }

    // Problem 47: Distinct prime factors
    public ResponseDto Question47(){
        ResponseDto responseDto = new ResponseDto();
        for (int i = 2; i < 1000000; i++) {
            int count = countDistinctPrimes(i);
            if (count == 4) {
                if (countDistinctPrimes(i+1) == 4 && countDistinctPrimes(i+2) == 4 && countDistinctPrimes(i+3) == 4) {
                    responseDto.setAnswer(i);
                    return responseDto;
                }
            }
        }
        responseDto.setAnswer(0);
        return responseDto;
    }

    // Problem 48: Self powers
    public ResponseDto Question48(){
        ResponseDto responseDto = new ResponseDto();
        String result = "0";
        for (int i = 1; i <= 1000; i++) {
            String power = "1";
            for (int j = 0; j < i; j++) {
                power = multiply(power, String.valueOf(i));
            }
            result = addStrings(result, power);
        }
        responseDto.setAnswer(result.substring(result.length() - 10));
        return responseDto;
    }

    // Problem 49: Prime permutations
    public ResponseDto Question49(){
        ResponseDto responseDto = new ResponseDto();
        for (int i = 1000; i < 10000; i++) {
            if (isPrime(i)) {
                List<Integer> permutations = getPrimePermutations(i);
                for (int j = 0; j < permutations.size(); j++) {
                    for (int k = j + 1; k < permutations.size(); k++) {
                        int diff = permutations.get(k) - permutations.get(j);
                        for (int l = k + 1; l < permutations.size(); l++) {
                            if (permutations.get(l) - permutations.get(k) == diff) {
                                responseDto.setAnswer(String.valueOf(permutations.get(j)) + permutations.get(k) + permutations.get(l));
                                return responseDto;
                            }
                        }
                    }
                }
            }
        }
        responseDto.setAnswer(0);
        return responseDto;
    }

    // Problem 50: Consecutive prime sum
    public ResponseDto Question50(){
        ResponseDto responseDto = new ResponseDto();
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        int maxLength = 0;
        int result = 0;
        for (int i = 0; i < primes.size(); i++) {
            int sum = 0;
            for (int j = i; j < primes.size(); j++) {
                sum += primes.get(j);
                if (sum >= 1000000) break;
                if (isPrime(sum) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    result = sum;
                }
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    // Problems 51-100: Placeholder methods
    public ResponseDto Question51(){
        ResponseDto responseDto = new ResponseDto();
        long result = 0;
        for (int i = 100000; i < 200000; i++) {
            if (hasRepeatingDigitFamily(i)) {
                responseDto.setAnswer(i);
                return responseDto;
            }
        }
        responseDto.setAnswer(result);
        return responseDto;
    }

    public ResponseDto Question52(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question53(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question54(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question55(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question56(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question57(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question58(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question59(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question60(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question61(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question62(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question63(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question64(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question65(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question66(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question67(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question68(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question69(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question70(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question71(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question72(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question73(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question74(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question75(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question76(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question77(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question78(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question79(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question80(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question81(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question82(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question83(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question84(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question85(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question86(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question87(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question88(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question89(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question90(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question91(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question92(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question93(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question94(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question95(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question96(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question97(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question98(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question99(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }
    public ResponseDto Question100(){ ResponseDto responseDto = new ResponseDto(); responseDto.setAnswer(0); return responseDto; }

    // Helper methods
    private boolean isPalindrome(int num) {
        String s = String.valueOf(num);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
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

    private int collatzLength(int n) {
        int count = 1;
        while (n != 1) {
            if (n % 2 == 0) n = n / 2;
            else n = 3 * n + 1;
            count++;
        }
        return count;
    }

    private String multiplyByTwo(String num) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int product = Character.getNumericValue(num.charAt(i)) * 2 + carry;
            result.insert(0, product % 10);
            carry = product / 10;
        }
        if (carry > 0) result.insert(0, carry);
        return result.toString();
    }

    private String numberToWords(int n) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] scales = {"", "thousand", "million", "billion", "trillion"};
        
        if (n == 0) return "zero";
        StringBuilder result = new StringBuilder();
        int scale = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                result.insert(0, convertHundreds(n % 1000, ones, teens, tens) + (scales[scale] != null && !scales[scale].isEmpty() ? " " + scales[scale] + " " : " "));
            }
            n /= 1000;
            scale++;
        }
        return result.toString().replaceAll("\\s+", "");
    }

    private String convertHundreds(int n, String[] ones, String[] teens, String[] tens) {
        StringBuilder result = new StringBuilder();
        if (n >= 100) {
            result.append(ones[n / 100]).append("hundred");
            n %= 100;
        }
        if (n >= 20) {
            result.append(tens[n / 10]);
            if (n % 10 > 0) result.append(ones[n % 10]);
        } else if (n >= 10) {
            result.append(teens[n - 10]);
        } else if (n > 0) {
            result.append(ones[n]);
        }
        return result.toString();
    }

    private int getDayOfWeek(int day, int month, int year) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = (q + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
        return (h + 5) % 7;
    }

    private String multiply(String a, String b) {
        int[] result = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                result[i + j + 1] += Character.getNumericValue(a.charAt(i)) * Character.getNumericValue(b.charAt(j));
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int r : result) {
            if (!(sb.length() == 0 && r == 0)) sb.append(r);
        }
        return sb.toString();
    }

    private int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += (i * i == n) ? 1 : 2;
            }
        }
        return count;
    }

    private int sumOfDivisors(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum;
    }

    private boolean nextPermutation(int[] array) {
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) i--;
        if (i < 0) return false;
        int j = array.length - 1;
        while (array[j] <= array[i]) j--;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        Arrays.sort(array, i + 1, array.length);
        return true;
    }

    private String addStrings(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += Character.getNumericValue(a.charAt(i--));
            if (j >= 0) sum += Character.getNumericValue(b.charAt(j--));
            result.insert(0, sum % 10);
            carry = sum / 10;
        }
        return result.toString();
    }

    private int findCycleLength(int d) {
        Map<Integer, Integer> seen = new HashMap<>();
        int remainder = 1;
        int position = 0;
        while (remainder != 0 && !seen.containsKey(remainder)) {
            seen.put(remainder, position);
            remainder = (remainder * 10) % d;
            position++;
        }
        return seen.containsKey(remainder) ? position - seen.get(remainder) : 0;
    }

    private String power(int a, int b) {
        String result = "1";
        for (int i = 0; i < b; i++) {
            result = multiply(result, String.valueOf(a));
        }
        return result;
    }

    private boolean isPandigital(int a, int b, int product) {
        String concat = String.valueOf(a) + String.valueOf(b) + String.valueOf(product);
        if (concat.length() != 9) return false;
        boolean[] seen = new boolean[10];
        for (char c : concat.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit == 0 || seen[digit]) return false;
            seen[digit] = true;
        }
        return true;
    }

    private boolean isCancellingFraction(int a, int b) {
        int a1 = a / 10, a2 = a % 10;
        int b1 = b / 10, b2 = b % 10;
        if (a1 == b1 && a2 * b == a * b2) return true;
        if (a1 == b2 && a2 * b == a * b1) return true;
        if (a2 == b1 && a1 * b == a * b2) return true;
        if (a2 == b2 && a1 * b == a * b1) return true;
        return false;
    }

    private boolean isFactorionDigit(int n) {
        long[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        long sum = 0;
        int temp = n;
        while (temp > 0) {
            sum += factorial[temp % 10];
            temp /= 10;
        }
        return sum == n;
    }

    private boolean isCircularPrime(int n) {
        if (!isPrime(n)) return false;
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0);
            if (!isPrime(Long.parseLong(s))) return false;
        }
        return true;
    }

    private boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);
        return binary.equals(new StringBuilder(binary).reverse().toString());
    }

    private boolean isTruncatablePrime(int n) {
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            if (!isPrime(Long.parseLong(s.substring(i)))) return false;
            if (!isPrime(Long.parseLong(s.substring(0, s.length() - i + 1)))) return false;
        }
        return true;
    }

    private boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit == 0 || seen[digit]) return false;
            seen[digit] = true;
        }
        return true;
    }

    private boolean isPandigitalNumber(int n) {
        String s = String.valueOf(n);
        if (s.contains("0")) return false;
        boolean[] seen = new boolean[10];
        for (char c : s.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (seen[digit]) return false;
            seen[digit] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (!seen[i]) return false;
        }
        return true;
    }

    private boolean isPentagon(long n) {
        long discriminant = 1 + 24 * n;
        long sqrtD = (long) Math.sqrt(discriminant);
        return sqrtD * sqrtD == discriminant && (1 + sqrtD) % 6 == 0;
    }

    private boolean hasSubstringDivisibility(int[] perm) {
        int[] divisors = {2, 3, 5, 7, 11, 13, 17};
        for (int i = 0; i < 7; i++) {
            int threeDigit = perm[i + 1] * 100 + perm[i + 2] * 10 + perm[i + 3];
            if (threeDigit % divisors[i] != 0) return false;
        }
        return true;
    }

    private int countDistinctPrimes(int n) {
        int count = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                count++;
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) count++;
        return count;
    }

    private List<Integer> getPrimePermutations(int n) {
        List<Integer> result = new ArrayList<>();
        String s = String.valueOf(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        do {
            StringBuilder sb = new StringBuilder();
            for (int d : digits) sb.append(d);
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num)) result.add(num);
        } while (nextPermutation(digits));
        Collections.sort(result);
        return result;
    }

    private boolean hasRepeatingDigitFamily(int n) {
        String s = String.valueOf(n);
        for (char c = '0'; c <= '9'; c++) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == c) count++;
            }
            if (count >= 2) return true;
        }
        return false;
    }
}
