package com.comparisonai.gpt54minimodel.services.gpt54mini.onebyone;

import com.comparisonai.gpt54minimodel.dto.ResponseDto;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.*;

public abstract class GPT54MiniOneByOneBase {

    protected long gcd(long a, long b) {
        while (b > 0) {
            a %= b;
            long tmp = a;
            a = b;
            b = tmp;
        }
        return a;
    }

    protected boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    protected int countDivisors(long n) {
        int count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) count++;
                else count += 2;
            }
        }
        return count;
    }

    protected int countLetters(int n) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n == 1000) return "onethousand".length();
        int count = 0;
        if (n >= 100) {
            count += ones[n / 100].length() + "hundred".length();
            if (n % 100 != 0) count += "and".length();
        }
        n %= 100;
        if (n < 20) {
            count += ones[n].length();
        } else {
            count += tens[n / 10].length() + ones[n % 10].length();
        }
        return count;
    }

    protected int daysInMonth(int month, int year) {
        if (month == 4 || month == 6 || month == 9 || month == 11) return 30;
        if (month == 2) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) return 29;
            return 28;
        }
        return 31;
    }

    protected int sumDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i * i != n) sum += n / i;
            }
        }
        return sum;
    }

    protected void nextPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i >= 0) {
            int j = a.length - 1;
            while (a[j] <= a[i]) j--;
            swap(a, i, j);
        }
        reverse(a, i + 1, a.length - 1);
    }

    protected void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected void reverse(int[] a, int i, int j) {
        while (i < j) swap(a, i++, j--);
    }

    protected int getCycleLength(int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int rem = 1;
        int pos = 0;
        while (rem != 0 && !map.containsKey(rem)) {
            map.put(rem, pos++);
            rem = (rem * 10) % d;
        }
        return rem == 0 ? 0 : pos - map.get(rem);
    }

    protected int sumOfFifthPowers(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += (int) Math.pow(d, 5);
            n /= 10;
        }
        return sum;
    }

    protected boolean isPandigital(String s) {
        if (s.length() != 9) return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars).equals("123456789");
    }

    protected boolean isCircularPrime(int n) {
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (!isPrime(Integer.parseInt(s))) return false;
            s = s.substring(1) + s.charAt(0);
        }
        return true;
    }

    protected boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    protected boolean isTruncatablePrime(int n) {
        if (!isPrime(n)) return false;
        String s = String.valueOf(n);
        for (int i = 1; i < s.length(); i++) {
            if (!isPrime(Integer.parseInt(s.substring(i)))) return false;
            if (!isPrime(Integer.parseInt(s.substring(0, s.length() - i)))) return false;
        }
        return true;
    }

    protected boolean prevPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] <= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] >= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    protected boolean nextPermutationWithBool(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return false;
        int j = a.length - 1;
        while (a[j] <= a[i]) j--;
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    protected boolean isPentagonal(long n) {
        double val = (Math.sqrt(24 * n + 1) + 1) / 6.0;
        return val == (int) val;
    }

    protected int countPrimeFactors(int n) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) factors.add(n);
        return factors.size();
    }

    protected boolean isPermutation(int a, int b) {
        char[] s1 = String.valueOf(a).toCharArray();
        char[] s2 = String.valueOf(b).toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    protected boolean nCrExceeds(int n, int r, int limit) {
        if (r < 0 || r > n) return false;
        if (r == 0 || r == n) return 1 > limit;
        if (r > n / 2) r = n - r;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - i + 1) / i;
            if (res > limit) return true;
        }
        return false;
    }

    protected boolean isLychrel(long n) {
        BigInteger bi = BigInteger.valueOf(n);
        for (int i = 0; i < 50; i++) {
            bi = bi.add(new BigInteger(new StringBuilder(bi.toString()).reverse().toString()));
            if (isPalindrome(bi.toString())) return false;
        }
        return true;
    }

    protected BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) <= 0) a = mid.add(BigInteger.ONE);
            else b = mid.subtract(BigInteger.ONE);
        }
        return a.subtract(BigInteger.ONE);
    }

    protected void findProductSum(int start, int prod, int sum, int count, int[] minN) {
        int k = prod - sum + count;
        if (k < minN.length) {
            if (prod < minN[k]) minN[k] = prod;
        }
        for (int i = start; prod * i < 2 * minN.length; i++) {
            findProductSum(i, prod * i, sum + i, count + 1, minN);
        }
    }

    protected void searchQuestion93(int depth, int[] digits, boolean[] used, int[] bestCount, String[] bestDigits) {
        if (depth == 4) {
            List<Integer> values = new ArrayList<>();
            for (int d : digits) values.add(d);
            Set<Integer> results = new HashSet<>();
            permuteAndEvaluate93(values, 0, results);
            int consecutive = 1;
            while (results.contains(consecutive)) consecutive++;
            consecutive--;
            StringBuilder sb = new StringBuilder();
            for (int d : digits) sb.append(d);
            if (consecutive > bestCount[0] || (consecutive == bestCount[0] && sb.toString().compareTo(bestDigits[0]) > 0)) {
                bestCount[0] = consecutive;
                bestDigits[0] = sb.toString();
            }
            return;
        }
        for (int d = depth == 0 ? 0 : digits[depth - 1] + 1; d <= 9; d++) {
            if (!used[d]) {
                used[d] = true;
                digits[depth] = d;
                searchQuestion93(depth + 1, digits, used, bestCount, bestDigits);
                used[d] = false;
            }
        }
    }

    protected void permuteAndEvaluate93(List<Integer> values, int idx, Set<Integer> results) {
        if (idx == values.size()) {
            evaluateAllExpressions93(values, results);
            return;
        }
        for (int i = idx; i < values.size(); i++) {
            Collections.swap(values, idx, i);
            permuteAndEvaluate93(values, idx + 1, results);
            Collections.swap(values, idx, i);
        }
    }

    protected void evaluateAllExpressions93(List<Integer> values, Set<Integer> results) {
        List<Double> nums = new ArrayList<>();
        for (int v : values) nums.add((double) v);
        evaluateExpressions93(nums, results);
    }

    protected void evaluateExpressions93(List<Double> nums, Set<Integer> results) {
        if (nums.size() == 1) {
            double v = nums.get(0);
            if (v > 0 && Math.abs(v - Math.round(v)) < 1e-9) {
                results.add((int) Math.round(v));
            }
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) continue;
                List<Double> rest = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) rest.add(nums.get(k));
                }
                double a = nums.get(i);
                double b = nums.get(j);
                double[] candidates = {a + b, a - b, b - a, a * b};
                for (double candidate : candidates) {
                    rest.add(candidate);
                    evaluateExpressions93(rest, results);
                    rest.remove(rest.size() - 1);
                }
                if (Math.abs(b) > 1e-9) {
                    rest.add(a / b);
                    evaluateExpressions93(rest, results);
                    rest.remove(rest.size() - 1);
                }
                if (Math.abs(a) > 1e-9) {
                    rest.add(b / a);
                    evaluateExpressions93(rest, results);
                    rest.remove(rest.size() - 1);
                }
            }
        }
    }

}
