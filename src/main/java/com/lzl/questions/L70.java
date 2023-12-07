package com.lzl.questions;

/**
 * 70. 爬楼梯
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L70 {
    public static void main(String[] args) {
        System.out.println(new L70().climbStairs(4));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // 到达第i级有多少种方法？那就看i-1和i-2，i-1代表到底第i-1阶有多少种方法，此时再走一步到达i，所以i-1有多少种其实就是i有多少种，i-2的同理，由于有这两种方式可以到达i，所以种数
        // f(x)=f(x-1)+f(x-2) (即到达x台阶等于到达x-1阶和x-2阶的方法之和)
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
