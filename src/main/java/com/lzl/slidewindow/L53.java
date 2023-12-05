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
        System.out.println(new L53().maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            int i = nums[0] + nums[1];
            if (i > nums[0] && i > nums[1]) {
                return i;
            }
            return Math.max(nums[0], nums[1]);
        }
        int maxVal = 0;
        for (int L = 1; L <= nums.length; L++) {
            for (int i = 0; i < nums.length; i++) {
                int j = L + i - 1;
                if(j>=nums.length)break;
                if (i == j) {
                    maxVal = Math.max(maxVal, nums[i]);
                    continue;
                }
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxVal = Math.max(maxVal, sum);

            }
        }
        return maxVal;
        // int left=0;
        // int right=0;
        // int winVal=0;
        // int maxVal=0;
        // while(right<nums.length){
        //     int num = nums[right];
        //     int t=winVal;
        //     winVal+=num;
        //     while(winVal<t){
        //          maxVal = Math.max(t, maxVal);
        //          winVal-=nums[left];
        //          t=winVal;
        //          left++;
        //     }
        //     right++;
        // }
        // return maxVal;
    }
}