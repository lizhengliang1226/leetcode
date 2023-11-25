package com.lzl;

import java.util.Arrays;

/**
 * 斐波那契数列
 *
 * @author LZL
 * @version 1.0
 * @since 2023/10/28
 */
public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        int fib1 = fib.fib(10);
        System.out.println(fib1);
//        Arrays.fill();
    }

    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    /**
     * 自顶向下算法
     *
     * @param memo 备忘录
     * @param n
     * @return
     */
    private int helper(int[] memo, int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 自底向上
     */
    int fib1(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 只存储两个状态
     */
    int fib2(int n) {
        if (n == 0 || n == 1) return n;
        int dp_i_1 = 1;
        int dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }
}
