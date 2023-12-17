package com.lzl.dp;

/**
 * 746. 使用最小花费爬楼梯
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L746 {
    public static void main(String[] args) {
        System.out.println(new L746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(new L746().minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(new L746().minCostClimbingStairs(new int[]{10}));
    }

    /**
     * 动态规划，滚动数组
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp_0 = 0;
        int dp_1 = 0;
        for (int i = 2; i <= n; i++) {
            int dp_i = Math.min(dp_0 + cost[i - 2], dp_1 + cost[i - 1]);
            dp_0 = dp_1;
            dp_1 = dp_i;
        }
        return dp_1;
    }

    /**
     * 动态规划
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
