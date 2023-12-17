package com.lzl.questions;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/17
 */
public class L238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new L238().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        // 先求前缀积
        int[] preMul = new int[nums.length + 1];
        preMul[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            preMul[i + 1] = preMul[i] * nums[i];
        }
        // 再求后缀积
        int[] postMul = new int[nums.length + 1];
        postMul[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            postMul[i] = postMul[i + 1] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 结果就是当前元素的前缀积乘以后缀积，直接取是因为前后缀积索引取的时候都加了1，这里直接取相当于是自动减了1
            result[i] = preMul[i] * postMul[i + 1];
        }
        return result;
    }
}
