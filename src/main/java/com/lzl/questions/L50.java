package com.lzl.questions;

/**
 * 50. Pow(x, n)
 * 中等
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/28
 */
public class L50 {

    public static void main(String[] args) {
        System.out.println(new L50().myPow(2.00000, -2));

    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1.0) {
            return 1.0;
        }
        long nn = n;
        int flag = 1;
        if (nn < 0) {
            nn = Math.abs(nn);
            flag = 0;
        }
        return flag == 1 ? dfs(x, nn) : 1.0 / dfs(x, nn);

    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double dfs = dfs(x, n / 2);
        return n % 2 == 0 ? dfs * dfs : dfs * dfs * x;
    }
}