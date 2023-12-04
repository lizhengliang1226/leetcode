package com.lzl.questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/04
 */
public class L32 {
    public int longestValidParentheses(String s) {
        // .....()  s[i]=')' and s[i-1]='('  then dp[i]=dp[i-2]+2
        //.....)) if s[i]=')' and s[i-1]=')'  and s[i-dp[i-1]-1]='(' then dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2
        // 代表每个下标字符结束的最长括号数
        stack(s);
        return max;
    }

    int max = 0;

    /**
     * 栈方法
     *
     * @param s
     * @return
     */
    private void stack(String s) {
        //
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(i - pop+1, max);
                }
            }
        }
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    private static int dp(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i - 1);
            if (c1 == ')') {
                if (c2 == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}