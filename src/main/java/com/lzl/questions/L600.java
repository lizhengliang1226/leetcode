package com.lzl.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 600. 不含连续1的非负整数
 * 困难
 * 相关标签
 * 相关企业
 * 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5
 * 输出: 5
 * 解释:
 * 下面列出范围在 [0, 5] 的非负整数与其对应的二进制表示：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数 3 违反规则（有两个连续的 1 ），其他 5 个满足规则。
 * 示例 2:
 * <p>
 * 输入: n = 1
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: n = 2
 * 输出: 3
 *
 * @author LZL
 * @version 1.0
 * @since 2024/08/05
 */
public class L600 {
   Map<Integer,Integer> m=new HashMap<>();
    public static void main(String[] args) {
        int n = 80982165;
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            boolean b = (i & (i >> 1)) != 0;
            if (!b) {
                count++;

                // System.out.println(i + "--" + Integer.toBinaryString(i) + (b ? "有" : ""));
            }
            if (i % 100 == 0) {
                System.out.println();
            }
        }
        System.out.println(count);
        // System.out.println(new L600().findIntegers(n));
    }

    public int findIntegers(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        // int[] dp = new int[n + 1];
        // dp[0] = 1;
        // dp[1] = 2;
        int dp_i_1 = 2;
        int dp_i = 0;
        for (int i = 2; i <= n; i++) {
            dp_i = dp_i_1 + cur(i);
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    private int cur(int n) {
        boolean a = (n & (n >> 1)) != 0;
        return a ? 0 : 1;
    }
}