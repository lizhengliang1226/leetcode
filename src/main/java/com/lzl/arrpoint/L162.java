package com.lzl.arrpoint;

/**
 * 162. 寻找峰值
 * 中等
 * 相关标签
 * 相关企业
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * <p>
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * <p>
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/12/18
 */
public class L162 {
    public static void main(String[] args) {

    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int left = 1;
        int right = nums.length - 2;
        while (left <= right) {
            if (nums[left - 1] < nums[left] && nums[left + 1] < nums[left]) {
                return left;
            }
            if (nums[right - 1] < nums[right] && nums[right + 1] < nums[right]) {
                return right;
            }
            left++;
            right--;
        }
        return -1;
    }
}