package com.lzl.questions;

import java.util.Arrays;

/**
 * 128. 最长连续序列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/14
 */
public class L128 {
    public static void main(String[] args) {
        System.out.println(new L128().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1 && nums[i] != nums[i - 1]) {
                max = Math.max(count, max);
                if (nums.length - i <= count) {
                    break;
                }
                count = 1;
            }
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            }
        }
        return Math.max(max, count);
    }
}