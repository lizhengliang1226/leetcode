package com.lzl.questions;

/**
 * 69. x 的平方根
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L69 {
    public static void main(String[] args) {
        System.out.println(new L69().mySqrt(9));
    }

    public int mySqrt(int x) {
        int ans = -1;
        int left = 0;
        int right = x;
        while (left <= right) {
            // (a+b)/2==a+(b-a)/2 是为了防止相加溢出
            int mid = left + (right - left) / 2;
            // 强转是怕整数相乘溢出
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
