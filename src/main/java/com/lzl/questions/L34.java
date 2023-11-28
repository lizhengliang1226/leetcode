package com.lzl.questions;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @author lzl
 * @version 1.0
 * @since 2023/11/28
 */
public class L34 {
    public static void main(String[] args) {
        System.out.println(new L34().searchRange(new int[]{1, 2, 3, 4, 4, 5, 6, 7, 8}, 4));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            if (nums[0] == target) return new int[]{0, 0};
            return res;
        }
        if (nums.length == 2) {
            if (nums[0] == target && nums[1] != target) {
                return new int[]{0, 0};
            } else if (nums[0] != target && nums[1] == target) {
                return new int[]{1, 1};
            } else if (nums[0] == target) {
                return new int[]{0, 1};
            } else {
                return new int[]{-1, -1};
            }
        }
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        if (i - 1 == nums.length) return res;
        if (nums[j] == target) {
            res[1] = j;
        } else {
            return res;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                j = mid - 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        res[0] = i;
        return res;
    }
}
