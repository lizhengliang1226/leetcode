package com.lzl.slidewindow;

/**
 * 53. 最大子数组和
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/05
 */
public class L53 {
    public static void main(String[] args) {
        System.out.println(new L53().maxSubArray(new int[]{5, 4, -3, 9}));
    }

    public int maxSubArray(int[] nums) {
        // 状态转移方程：
        // f(i)=Math.max(f(i-1)+x,x);
        // pre永远是以i下标结尾的元素序列的最大和
        int maxVal = Integer.MIN_VALUE;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 每次都拿pre+num后比较，如果小了，说明i-1之前的值全加起来比自己还要小，则最大和直接取自己
            // 如果i-1之前的加上自己变得更大了，则取i-1的值加上自己，增大这个最大和
            pre = Math.max(pre + num, num);
            // 每次求完i的最大和就去更新全局最大和
            maxVal = Math.max(maxVal, pre);
        }
        return maxVal;
    }
}