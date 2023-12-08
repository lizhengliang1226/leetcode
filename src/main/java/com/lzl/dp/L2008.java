package com.lzl.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 2008. 出租车的最大盈利
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
 * <p>
 * 乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
 * <p>
 * 每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
 * <p>
 * 给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
 * <p>
 * 注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/08
 */
public class L2008 {
    public static void main(String[] args) {
        System.out.println(new L2008().maxTaxiEarnings(20,
                                                       new int[][]{new int[]{1, 6, 1}, new int[]{3, 10, 2}, new int[]{10, 12, 3}, new int[]{11, 12, 2}, new int[]{12, 15, 2}, new int[]{13, 18, 1}}));
    }

    /**
     * 动态规划，dp[i]代表从1-i这条路可以赚的最多钱
     * 对于给的的旅行按终点分组，计算每次旅行可以赚的钱 key：end坐标 value数组：v0-起始点，v1-赚的钱
     * dp[0]=0,dp[1]=0，从2开始才能赚钱，之前的为0，就是base case
     * dp[i]在i这个位置可以有两个选择，
     * 1.没人上车或者不搭这人，那就不赚钱dp[i]=dp[i-1]
     * 2.有人在这里下车，那就遍历可以在这下车的人，也就是上面分组后的rides，分组的key是end坐标，当end=i，代表i此处所有可以下车的人
     * dp[i]=dp[i-1](初始化时为这个，先假设这里没人或者不搭那个人)
     * 然后dp[i]=Math.max(dp[i](这个就是上面初始化的值),dp[v0]+v1)
     * v0是按end分组后，value中保存的起始点v0，以及从起始到这个end赚的钱v1，
     * dp[v0]代表去找以当前这个起始点为结束点的前面的路程能赚的最多钱，再加上当前在这搭车能赚的钱v0就得到了第二种情况赚的钱
     * 取两种情况的最大值即可
     *
     * @param n
     * @param rides
     * @return
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        List<int[]>[] grid = new List[n + 1];
        for (int i = 0; i < rides.length; i++) {
            int start = rides[i][0];
            int end = rides[i][1];
            int tip = rides[i][2];
            if (grid[end] == null) {
                grid[end] = new ArrayList<>();
            }
            // 先按end分组得到在end下车能赚钱的所有旅行
            grid[end].add(new int[]{start, end - start + tip});
        }
        // 初始化dp，默认为0
        long[] dp = new long[n + 1];
        // 从2-n遍历，得到以i为终点能赚的最多钱
        for (int i = 2; i <= n; i++) {
            // 默认当前这个点不上人，或者没有人
            dp[i] = dp[i - 1];
            // 说明在这个地方有人可以下车
            if (grid[i] != null) {
                // 那就遍历可以在这下车的人，取最大的那个
                for (int[] ints : grid[i]) {
                    // dp[ints[0]]代表以当前这个下车点的那个开始点为下车点的前面的最大盈利
                    // ints[1]是当前这个人的盈利
                    dp[i] = Math.max(dp[i], dp[ints[0]] + ints[1]);
                }
            }
        }
        // 返回在n点下车的最大盈利
        return dp[n];
    }
}