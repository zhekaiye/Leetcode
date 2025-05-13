/*
 * 找出区间内的所有素数。
 * 输⼊：区间范围；
 * 输出：素数列表；
 * 难度：Easy（埃拉托斯特尼筛法）
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findPrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        if (end < 2 || start > end) {
            return primes;
        }
        if (start < 2) {
            start = 2;
        }
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = start; i <= end; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}