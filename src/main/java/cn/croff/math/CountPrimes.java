package cn.croff.math;

/**
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        // 维护一个是否是素数的boolean数组，需要注意的是从下标为1开始生效
        boolean[] notPrime = new boolean[n];
        // 素数计数器
        int count = 0;
        // 从2开始遍历，因为1不是素数
        for (int i = 2; i < n; i++) {
            // 不是素数就跳过
            if (notPrime[i]) continue;
            // 是素数就更新计数器
            count++;
            // 然后筛掉它的所有倍数
            for (int j = 2; i * j < n; j++) notPrime[i * j] = true;
        }
        return count;
    }

    /**
     * 判断是否为素数的最有效方法
     *
     * @param num 正整数
     * @return 是否为素数
     */
    private boolean isPrime(int num) {
        // 小于5的素数有2和3
        if (num == 2 || num == 3) return true;

        // 不在6的倍数两侧的一定不是素数
        if (num % 6 != 1 && num % 6 != 5) return false;

        int sqrt = (int) Math.sqrt(num);
        // 大于等于5的素数一定和6的倍数相邻
        for (int i = 5; i <= sqrt; i += 6) {
            // 在6的倍数两侧的也可能不是素数
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }

        return true;
    }
}
