package com.lzl.questions;

import java.util.Arrays;

/**
 * 66. 加一
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/07
 */
public class L66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L66().plusOne(new int[]{9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {
        return dfs(digits, digits.length, digits.length - 1, 1);
    }

    private int[] dfs(int[] digits, int length, int bit, int add) {
        int num = digits[bit] + add;
        if (num < 10) {
            digits[bit] += add;
            return digits;
        } else {
            int a = num - 10;
            digits[bit] = a;
            if (bit == 0) {
                int[] newArray = new int[length + 1];
                newArray[0] = 1;
                System.arraycopy(digits, 0, newArray, 1, length);
                return newArray;
            }
            digits = dfs(digits, digits.length, bit - 1, 1);
        }
        return digits;
    }
}